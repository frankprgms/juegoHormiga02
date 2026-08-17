
package entidades;

import consumibles.Comida;
import prueba2.RecorteSprite;
import prueba2.Textura;

import enums.EnumEntidades.DireccionEntidades;
import imprimir.Imprimir;
import java.util.List;
import movimientos.Cordenadas;
import movimientos.InterfasDeMovimiento;

public class Entidades {
    private Cordenadas posicionEntidad;
    private int columnaImagen;
    private int filaImagen;
    private float anchoSprite;
    private float altoSprite;
    private Textura textura;
    private RecorteSprite recorteSprite;
    private ConfiguracionSpriteSheet configuracionSpriteSheet;
    private DireccionEntidades direccionEntidad ;
    private int cantidadimagenes;
    private int imagenActual=0;
    //----------movimientos-------------
    protected InterfasDeMovimiento movimientoActual;
    
    
    private double tiempoCambioFrame;
    public Entidades(Cordenadas posicionEntidad,Textura textura,ConfiguracionSpriteSheet configuracionSpriteSheet,
            DireccionEntidades direccionEntidad,InterfasDeMovimiento movimientoActual,int cantidadimagenes
    ) {

        this.posicionEntidad = posicionEntidad;
        this.columnaImagen = posicionEntidad.getColumnaImagen();
        this.filaImagen =  posicionEntidad.getFilaImagen();
        this.anchoSprite =  posicionEntidad.getAnchoSprite();
        this.altoSprite =  posicionEntidad.getAltoSprite();
        this.textura = textura;
        this.direccionEntidad = direccionEntidad;
        this.configuracionSpriteSheet = configuracionSpriteSheet;
        this.cantidadimagenes = cantidadimagenes;
        this.movimientoActual = movimientoActual;
        
        //recorteSprite=textura.extraertextura(columnaImagen, filaImagen, anchoSprite, altoSprite);
    }

    //------------movimientos------------------------------------//
    public void setMovimientoActual(InterfasDeMovimiento movimientoActual) {
        this.movimientoActual = movimientoActual;
    }
    
    private void evaluarCambioDeMovimiento(List<Entidades> Entidades, List<Comida> comidas){
        for (Entidades Entidad : Entidades) {
            posicionEntidad.estanColisionando(Entidad.getPosicionEntidad());
        }
    }
    public void mover(List<Entidades> Entidades, List<Comida> comidas) {
        evaluarCambioDeMovimiento(Entidades, comidas);
        direccionEntidad = movimientoActual.moverse(posicionEntidad, direccionEntidad);
        
    }
    public InterfasDeMovimiento getMovimientoActual() {
        return movimientoActual;
    }
 
    public RecorteSprite direcciondo(){
        
        RecorteSprite obtenerRecorte = configuracionSpriteSheet.obtenerRecorte(
                direccionEntidad, textura, imagenActual, columnaImagen, filaImagen, anchoSprite, altoSprite
        );

        return obtenerRecorte;
        
    }
    
    public void cambioFrame(double tiempoCambioFrame) {
        if (this.tiempoCambioFrame-tiempoCambioFrame>=2){
            this.tiempoCambioFrame=tiempoCambioFrame;
            if (imagenActual==cantidadimagenes-1){
                imagenActual=0;
            }else{
                imagenActual++;
            }
        }
        this.tiempoCambioFrame+=1.0;
    }

    public Cordenadas getPosicionEntidad() {
        return posicionEntidad;
    }

    public void setPosicionEntidad(Cordenadas posicionEntidad) {
        this.posicionEntidad = posicionEntidad;
    }

    public int getColumnaImagen() {
        return columnaImagen;
    }

    public void setColumnaImagen(int columnaImagen) {
        this.columnaImagen = columnaImagen;
    }

    public int getFilaImagen() {
        return filaImagen;
    }

    public void setFilaImagen(int filaImagen) {
        this.filaImagen = filaImagen;
    }

    public float getAnchoSprite() {
        return anchoSprite;
    }

    public void setAnchoSprite(int anchoSprite) {
        this.anchoSprite = anchoSprite;
    }

    public float getAltoSprite() {
        return altoSprite;
    }

    public void setAltoSprite(int altoSprite) {
        this.altoSprite = altoSprite;
    }

    public Textura getTextura() {
        return textura;
    }

    public void setTextura(Textura textura) {
        this.textura = textura;
    }

    public RecorteSprite getRecorteSprite() {
        return recorteSprite;
    }

    public void setRecorteSprite(RecorteSprite recorteSprite) {
        this.recorteSprite = recorteSprite;
    }

    public int getImagenActual() {
        return imagenActual;
    }

    public void setImagenActual(int imagenActual) {
        this.imagenActual = imagenActual;
    }

    public double getTiempoCambioFrame() {
        return tiempoCambioFrame;
    }

    public DireccionEntidades getDireccionEntidad() {
        return direccionEntidad;
    }

    public void setDireccionEntidad(DireccionEntidades direccionEntidad) {
        this.direccionEntidad = direccionEntidad;
    }

    public int getCantidadimagenes() {
        return cantidadimagenes;
    }

    public void setCantidadimagenes(int cantidadimagenes) {
        this.cantidadimagenes = cantidadimagenes;
    }

    public ConfiguracionSpriteSheet getConfiguracionSpriteSheet() {
        return configuracionSpriteSheet;
    }

    public void setConfiguracionSpriteSheet(ConfiguracionSpriteSheet configuracionSpriteSheet) {
        this.configuracionSpriteSheet = configuracionSpriteSheet;
    }

   
}
//        float uInicio = recorteSprite.getuInicio();
//        float uFin = recorteSprite.getuFin();
//        float vInicio = recorteSprite.getvInicio();
//        float vFin = recorteSprite.getvFin();
//        
//        switch (direccionEntidad) {
//            
//            case ARRIBA:recorteSprite2=new RecorteSprite(uInicio,uFin,vInicio,vFin);break;
//            case ABAJO:recorteSprite2=new RecorteSprite(uInicio,uFin,vFin,vInicio);break;
//            case DERECHA:recorteSprite2=new RecorteSprite(uFin, uInicio, vInicio, vFin);break;
//            case IZQUIERDA:recorteSprite2=new RecorteSprite(uInicio,uFin,vInicio,vFin);break;
//            
//            default:recorteSprite2=recorteSprite;
//        }