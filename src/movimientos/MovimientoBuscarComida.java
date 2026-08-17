
package movimientos;

import enums.EnumEntidades;
import enums.EnumEntidades.DireccionEntidades;
import java.awt.Rectangle;


public class MovimientoBuscarComida implements InterfasDeMovimiento{
    DetectorDeColisiones DetectorDeColisiones ;
    Cordenadas comida;
    public MovimientoBuscarComida(DetectorDeColisiones DetectorDeColisiones) {
        
        this.DetectorDeColisiones = DetectorDeColisiones;
    }
        
        
    @Override
    public DireccionEntidades moverse(Cordenadas posicionEntidad, DireccionEntidades DireccionEntidades) {
        if (comida!=null) {

        }
            
        return null;
        
    }
    public boolean compararCercania(
            Cordenadas posicionEntidad, 
            Cordenadas comparar,
            int alcanceDeteccion, 
            DireccionEntidades direccionEntidad
    ){
        if (posicionEntidad.EstanCerca(comparar, alcanceDeteccion, direccionEntidad)) {
            this.comida= comparar;
            return true;
        }else{
            return false;
        }
        

    }

    public void setComida(Cordenadas comida) {
        this.comida = comida;
    }
}
        
        
        
        
        /*if (DetectorDeColisiones.estaCercaAEntidad(entidad, comida, alcanceDeteccion)) {
            this.comida= comida;
            return true;
        }else{
            this.comida=null;
            return false;
        }
        */