
package movimientos;

import java.awt.Rectangle;
import java.awt.geom.Point2D;
public class DetectorDeColisiones {

    public boolean estaColisionando(Rectangle entidad1,Rectangle entidad2){
        
        return entidad1.intersects(entidad2);
    }
    public boolean estaCercaAEntidad(Rectangle entidad1,Rectangle entidad2,double distacia){
        
        double distance = Point2D.distance(entidad1.getCenterX(), entidad1.getCenterY(),entidad2.getCenterX(), entidad2.getCenterY());
        
        return distance<distacia;
    }
    
}
