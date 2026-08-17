
package movimientos;

import enums.EnumEntidades.DireccionEntidades;

public class Cordenadas {
    private float posicionX;
    private float posicionY;
    private float anchoSprite;
    private float altoSprite;
    private int columnaImagen;
    private int filaImagen;

    public Cordenadas(
            float posicionX, float posicionY, float anchoSprite, 
            float altoSprite,int columnaImagen, int filaImagen
    ) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.anchoSprite = anchoSprite;
        this.altoSprite = altoSprite;
        this.columnaImagen = columnaImagen;
        this.filaImagen = filaImagen;
    }
    

    
    
    public boolean EstanCerca( Cordenadas cordenada, int cercania, DireccionEntidades direccionEntidad){
        Cordenadas cordenada2;
        switch (direccionEntidad) {
            case ARRIBA->{
                cordenada2 = new Cordenadas(
                cordenada.getPosicionX(), 
                cordenada.getPosicionY()-cercania, 
                cordenada.getAnchoSprite(), 
                cordenada.getAltoSprite(),
                cordenada.getColumnaImagen(),
                cordenada.getFilaImagen()
                );
            }
            case ABAJO->{
                cordenada2 = new Cordenadas(
                cordenada.getPosicionX(),
                cordenada.getPosicionY(),
                cordenada.getAnchoSprite(),
                cordenada.getAltoSprite()+cercania,
                cordenada.getColumnaImagen(),
                cordenada.getFilaImagen()
                ); 
                
            }
            case DERECHA->{
                cordenada2 = new Cordenadas(
                cordenada.getPosicionX(),
                cordenada.getPosicionY(),
                cordenada.getAnchoSprite()+cercania,
                cordenada.getAltoSprite(),
                cordenada.getColumnaImagen(),
                cordenada.getFilaImagen()
                ); 
                
            }
            case IZQUIERDA->{
                cordenada2 = new Cordenadas(
                cordenada.getPosicionX()-cercania,
                cordenada.getPosicionY(),
                cordenada.getAnchoSprite(),
                cordenada.getAltoSprite(),
                cordenada.getColumnaImagen(),
                cordenada.getFilaImagen()
                ); 
                
            }
            default -> {
                cordenada2 = new Cordenadas(
                cordenada.getPosicionX(),
                cordenada.getPosicionY(),
                cordenada.getAnchoSprite(),
                cordenada.getAltoSprite(),
                cordenada.getColumnaImagen(),
                cordenada.getFilaImagen()
                );
            }

        }
        return estanColisionando( cordenada2);
    }
    public boolean estanColisionando(Cordenadas cordenada){
                 
        float tan=this.anchoSprite;
        float tal=this.altoSprite;
        
        float tpx=this.posicionX;
        float tpy=this.posicionY;
        
        float can=cordenada.getAnchoSprite();
        float cal=cordenada.getAltoSprite();
        
        float cpx = cordenada.getPosicionX();
        float cpy = cordenada.getPosicionY();
        
        float tant=tpx+tan;
        float talt=tpy+tal;
        
        float cant=cpx+can;
        float calt=cpy+cal;
        
        return !((tant<cpx||tant>cant)||(talt<cpy||talt>calt));
    }

    public float getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(float posicionX) {
        this.posicionX = posicionX;
    }

    public float getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(float posicionY) {
        this.posicionY = posicionY;
    }

    public float getAnchoSprite() {
        return anchoSprite;
    }

    public void setAnchoSprite(float anchoSprite) {
        this.anchoSprite = anchoSprite;
    }

    public float getAltoSprite() {
        return altoSprite;
    }

    public void setAltoSprite(float altoSprite) {
        this.altoSprite = altoSprite;
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
    
    
}
