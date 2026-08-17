package movimientos;

import enums.ubicacion.UbicacionBorde;
import imprimir.Imprimir;

public class GestorDeEntorno {
    private final int anchoPanel;
    private final int altoPanel;
    private static final int MARGEN = 25; // Tamaño de la entidad

    public GestorDeEntorno(int anchoPanel, int altoPanel) {
        this.anchoPanel = anchoPanel;
        this.altoPanel = altoPanel;
        
    }

    public UbicacionBorde detectarBorde(Cordenadas posicionEntidad) {
        
        boolean izq = posicionEntidad.getPosicionX() <= 0;
        boolean der = posicionEntidad.getPosicionX() + posicionEntidad.getAnchoSprite()>= (anchoPanel - MARGEN);
        boolean sup = posicionEntidad.getPosicionY() <= 0;
        boolean inf = posicionEntidad.getPosicionY() + posicionEntidad.getAltoSprite() >= (altoPanel - MARGEN);
        
        return UbicacionBorde.obtener(izq, der, sup, inf);
    }
    
    
    
}