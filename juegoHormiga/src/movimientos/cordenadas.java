
package movimientos;

public class cordenadas {
    private float posicionX;
    private float posicionY;
    private float anchoSprite;
    private float altoSprite;

    public cordenadas(float posicionX, float posicionY, float anchoSprite, float altoSprite) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.anchoSprite = anchoSprite;
        this.altoSprite = altoSprite;
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
    
    public boolean EstanCerca( cordenadas posicionEntidadComparar){
        float ans=this.anchoSprite;
        float als=this.altoSprite;
        
        float pex=this.posicionX;
        float pey=this.posicionY;
        
        float ansc=posicionEntidadComparar.getAnchoSprite();
        float alsc=posicionEntidadComparar.getAltoSprite();
        float pexc = posicionEntidadComparar.getPosicionX();
        float peyc = posicionEntidadComparar.getPosicionY();
        
        
        float anchoTotalE=pex+ans;
        float anchoTotalEC=pexc+ansc;
        
        
        float altoTotalE=pey+als;
        float altoTotalEc=peyc+alsc;
         
        if (anchoTotalE>pexc){
            
        }
        return false;
    }
    public boolean EstanColisionando(cordenadas posicionEntidadComparar){
        
        return false;
        
    }
}
