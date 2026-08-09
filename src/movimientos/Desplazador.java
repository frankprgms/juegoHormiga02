
package movimientos;

import java.awt.Rectangle;


public class Desplazador {
    
    
    public cordenadas moverArriba(cordenadas posicionEntidad){
//        int ubicacion2X=(int) ubicacion2.getX();
//        int ubicacion2y=(int) ubicacion2.getY();
//        ubicacion2.setLocation(ubicacion2X, ubicacion2y-1);
        posicionEntidad.setPosicionY(posicionEntidad.getPosicionY()-1);
        return posicionEntidad;
    }
    public cordenadas moverAbajo(cordenadas posicionEntidad){
//        int ubicacion2X=(int) ubicacion2.getX();
//        int ubicacion2y=(int) ubicacion2.getY();
//        ubicacion2.setLocation(ubicacion2X, ubicacion2y+1);
        posicionEntidad.setPosicionY(posicionEntidad.getPosicionY()+1);
        return posicionEntidad;
    }
    public cordenadas moverDerecha(cordenadas posicionEntidad){
//        int ubicacion2X=(int) ubicacion2.getX();
//        int ubicacion2y=(int) ubicacion2.getY();
//        ubicacion2.setLocation(ubicacion2X+1, ubicacion2y);
        posicionEntidad.setPosicionX(posicionEntidad.getPosicionX()+1);
        return posicionEntidad;
    }
    public cordenadas moverIzquierda(cordenadas posicionEntidad){
//        int ubicacion2X=(int) ubicacion2.getX();
//        int ubicacion2y=(int) ubicacion2.getY();
//        ubicacion2.setLocation(ubicacion2X-1, ubicacion2y);
        posicionEntidad.setPosicionX(posicionEntidad.getPosicionX()-1);
        return posicionEntidad;
    }
}
