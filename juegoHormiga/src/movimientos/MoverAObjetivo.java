package movimientos;

import enums.EnumEntidades.DireccionEntidades;
import static enums.EnumEntidades.DireccionEntidades.ABAJO;
import static enums.EnumEntidades.DireccionEntidades.ARRIBA;
import static enums.EnumEntidades.DireccionEntidades.DERECHA;
import static enums.EnumEntidades.DireccionEntidades.IZQUIERDA;

public class MoverAObjetivo implements InterfasDeMovimiento{
    
    private final Desplazador desplazador = new Desplazador();
    
    cordenadas posicionObjetivo;
    @Override
    public DireccionEntidades moverse( cordenadas posicionEntidad, DireccionEntidades DireccionEntidades) {
        int destinoX=(int) posicionObjetivo.getPosicionX();
        int destinoY=(int) posicionObjetivo.getPosicionY();
        
        int entidadesX=(int) posicionEntidad.getPosicionX();
        int entidadesY=(int) posicionEntidad.getPosicionY();
                
        if  (destinoX!=entidadesX||destinoY!=entidadesY){

            if (destinoX>entidadesX) {
                DireccionEntidades=DERECHA;
            }else if (destinoX<entidadesX) {
                DireccionEntidades=IZQUIERDA;
            }else if (destinoY<entidadesY) {
                DireccionEntidades=ARRIBA;
            }else if (destinoY>entidadesY) {
                DireccionEntidades=ABAJO;
            }
        }
        switch(DireccionEntidades){
            case ABAJO:desplazador.moverAbajo( posicionEntidad);break;
            case ARRIBA:desplazador.moverArriba( posicionEntidad);break;
            case DERECHA:desplazador.moverDerecha( posicionEntidad);break;
            case IZQUIERDA:desplazador.moverIzquierda( posicionEntidad);break;
        }
        return DireccionEntidades;
    }

    public cordenadas getObjetivo() {
        return posicionObjetivo;
    }

    public void setObjetivo(cordenadas posicionObjetivo) {
        this.posicionObjetivo = posicionObjetivo;
    }
    
    
    
}
