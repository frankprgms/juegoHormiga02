
package movimientos;

import enums.EnumEntidades;
import enums.EnumEntidades.DireccionEntidades;
import java.awt.Rectangle;


public class MovimientoBuscarComida implements InterfasDeMovimiento{
    DetectorDeColisiones DetectorDeColisiones ;
    Rectangle comida;
    public MovimientoBuscarComida(DetectorDeColisiones DetectorDeColisiones) {
        
        this.DetectorDeColisiones = DetectorDeColisiones;
    }
        
        
    @Override
    public DireccionEntidades moverse(cordenadas posicionEntidad, DireccionEntidades DireccionEntidades) {
        if (comida!=null) {
            comida.getX();
            comida.getY();
        }
            
        return null;
        
    }
    public boolean compararCercania(Rectangle entidad, Rectangle comida,int alcanceDeteccion){
        if (DetectorDeColisiones.estaCercaAEntidad(entidad, comida, alcanceDeteccion)) {
            this.comida= comida;
            return true;
        }else{
            this.comida=null;
            return false;
        }
        
    }

    public void setComida(Rectangle comida) {
        this.comida = comida;
    }
}
