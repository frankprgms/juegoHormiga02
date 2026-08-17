package consumibles;

import movimientos.Cordenadas;


public class Comida {
    Cordenadas posicionEntidad;
    int alimentoRestante;

    public Comida(Cordenadas posicionEntidad, int alimentoRestante) {
        this.posicionEntidad = posicionEntidad;
        this.alimentoRestante = alimentoRestante;
    }

    public Cordenadas getPosicionEntidad() {
        return posicionEntidad;
    }

    public void setPosicionEntidad(Cordenadas posicionEntidad) {
        this.posicionEntidad = posicionEntidad;
    }

    public int getAlimentoRestante() {
        return alimentoRestante;
    }

    public void setAlimentoRestante(int alimentoRestante) {
        this.alimentoRestante = alimentoRestante;
    }
    

}
