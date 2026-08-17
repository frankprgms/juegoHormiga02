
package movimientos;

import enums.EnumEntidades.DireccionEntidades;
import static enums.EnumEntidades.DireccionEntidades.*;
import enums.ubicacion.UbicacionBorde;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MoverAlatorio implements InterfasDeMovimiento{
    
    private GestorDeEntorno GestorDeEntorno;
    private int iteradorCambioDireccion=0;
    private final Random random = new Random();
    private int randomCambioDireccion  = random.nextInt(9)+1;
    private final Desplazador desplazador = new Desplazador();

    public MoverAlatorio( GestorDeEntorno GestorDeEntorno) {
        this.GestorDeEntorno = GestorDeEntorno;
    }
    private void reiniciarVariables(){
        
        iteradorCambioDireccion=0;
        randomCambioDireccion =random.nextInt(9)+1;
    }
    
    private DireccionEntidades selecionarCambioDirecion(List<DireccionEntidades> arraylisDireccionEntidades){
        return arraylisDireccionEntidades.get(random.nextInt(arraylisDireccionEntidades.size()));
        
    }
    
    private List<DireccionEntidades> direccionesAExcluir( UbicacionBorde detectarBorde){
        return switch (detectarBorde) {
            case NORTE            -> List.of(ARRIBA);
            case SUR              -> List.of(ABAJO);
            case ESTE             -> List.of(DERECHA);
            case OESTE            -> List.of(IZQUIERDA);
            case ESQUINA_SUP_IZQ  -> List.of(ARRIBA, IZQUIERDA);
            case ESQUINA_SUP_DER  -> List.of(ARRIBA, DERECHA);
            case ESQUINA_INF_DER  -> List.of(ABAJO, DERECHA);
            case ESQUINA_INF_IZQ  -> List.of(ABAJO, IZQUIERDA);
            case NINGUNO  ->List.of();
            default               -> List.of(); // Por si acaso llega otro valor
        };
    }
    
    @Override
    public DireccionEntidades moverse(Cordenadas posicionEntidad, DireccionEntidades DireccionEntidades) {
        DireccionEntidades nuevaDireccion=DireccionEntidades;
        
        List<DireccionEntidades> arraylisDireccionEntidades = new ArrayList<>(List.of(ARRIBA, ABAJO, DERECHA, IZQUIERDA));

        UbicacionBorde detectarBorde = GestorDeEntorno.detectarBorde(posicionEntidad);
        
        switch (detectarBorde) {
            case NORTE            -> {
                if (DireccionEntidades==ARRIBA){
                    arraylisDireccionEntidades.removeAll(direccionesAExcluir(detectarBorde));
                    nuevaDireccion= selecionarCambioDirecion(arraylisDireccionEntidades);
                }else{
                    iteradorCambioDireccion++;
                }
            }
            case SUR              -> {
                if (DireccionEntidades==ABAJO){
                    arraylisDireccionEntidades.removeAll(direccionesAExcluir(detectarBorde));
                    nuevaDireccion= selecionarCambioDirecion(arraylisDireccionEntidades);
                }else{
                    iteradorCambioDireccion++;
                }
            }
            case ESTE             -> {
                if (DireccionEntidades==DERECHA){
                    arraylisDireccionEntidades.removeAll(direccionesAExcluir(detectarBorde));
                    nuevaDireccion= selecionarCambioDirecion(arraylisDireccionEntidades);
                }else{
                    iteradorCambioDireccion++;
                }
            }
            case OESTE            -> {
                if (DireccionEntidades==IZQUIERDA){
                    arraylisDireccionEntidades.removeAll(direccionesAExcluir(detectarBorde));
                    nuevaDireccion= selecionarCambioDirecion(arraylisDireccionEntidades);
                }else{
                    iteradorCambioDireccion++;
                }
            }
            case ESQUINA_SUP_IZQ  ->{
                if (DireccionEntidades==ARRIBA||DireccionEntidades==IZQUIERDA){
                    arraylisDireccionEntidades.removeAll(direccionesAExcluir(detectarBorde));
                    nuevaDireccion= selecionarCambioDirecion(arraylisDireccionEntidades);
                }else{
                    iteradorCambioDireccion++;
                }
            }
            case ESQUINA_SUP_DER  -> {
                if (DireccionEntidades==ARRIBA||DireccionEntidades==DERECHA){
                    arraylisDireccionEntidades.removeAll(direccionesAExcluir(detectarBorde));
                    nuevaDireccion= selecionarCambioDirecion(arraylisDireccionEntidades);
                }else{
                    iteradorCambioDireccion++;
                }
            }
            case ESQUINA_INF_DER  ->{
                if (DireccionEntidades==ABAJO||DireccionEntidades==DERECHA){
                    arraylisDireccionEntidades.removeAll(direccionesAExcluir(detectarBorde));
                    nuevaDireccion= selecionarCambioDirecion(arraylisDireccionEntidades);
                }else{
                    iteradorCambioDireccion++;
                }
            }
            case ESQUINA_INF_IZQ  -> {
                if (DireccionEntidades==ABAJO||DireccionEntidades==IZQUIERDA){
                    arraylisDireccionEntidades.removeAll(direccionesAExcluir(detectarBorde));
                    nuevaDireccion= selecionarCambioDirecion(arraylisDireccionEntidades);
                }else{
                    iteradorCambioDireccion++;
                }
            }
            case NINGUNO  ->iteradorCambioDireccion++;
            default               -> iteradorCambioDireccion++; // Por si acaso llega otro valor
        }
     
        if(randomCambioDireccion*25==iteradorCambioDireccion){
            arraylisDireccionEntidades.removeAll(direccionesAExcluir(detectarBorde));
            nuevaDireccion= selecionarCambioDirecion(arraylisDireccionEntidades);
            reiniciarVariables();
        }

        switch(nuevaDireccion){
            case ABAJO -> desplazador.moverAbajo( posicionEntidad);
            case ARRIBA -> desplazador.moverArriba( posicionEntidad);
            case DERECHA -> desplazador.moverDerecha( posicionEntidad);
            case IZQUIERDA -> desplazador.moverIzquierda( posicionEntidad);
        }
        return nuevaDireccion;
    }
}
