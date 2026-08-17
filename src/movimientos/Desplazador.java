
package movimientos;

public class Desplazador {
    public Cordenadas moverArriba(Cordenadas posicionEntidad){
        posicionEntidad.setPosicionY(posicionEntidad.getPosicionY()-1);
        return posicionEntidad;
    }
    public Cordenadas moverAbajo(Cordenadas posicionEntidad){
        posicionEntidad.setPosicionY(posicionEntidad.getPosicionY()+1);
        return posicionEntidad;
    }
    public Cordenadas moverDerecha(Cordenadas posicionEntidad){
        posicionEntidad.setPosicionX(posicionEntidad.getPosicionX()+1);
        return posicionEntidad;
    }
    public Cordenadas moverIzquierda(Cordenadas posicionEntidad){
        posicionEntidad.setPosicionX(posicionEntidad.getPosicionX()-1);
        return posicionEntidad;
    }
}
