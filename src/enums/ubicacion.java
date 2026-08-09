
package enums;

import enums.EnumEntidades.DireccionEntidades;
import static enums.EnumEntidades.DireccionEntidades.ARRIBA;
import static enums.EnumEntidades.DireccionEntidades.ABAJO;
import static enums.EnumEntidades.DireccionEntidades.DERECHA;
import static enums.EnumEntidades.DireccionEntidades.IZQUIERDA;


public class ubicacion  {
   public enum UbicacionBorde {
    NINGUNO, 
    NORTE, SUR, ESTE, OESTE, 
    ESQUINA_SUP_IZQ, ESQUINA_SUP_DER, ESQUINA_INF_IZQ, ESQUINA_INF_DER;   
        public static UbicacionBorde obtener(boolean izq, boolean der, boolean sup, boolean inf) {
            if (izq && sup) return ESQUINA_SUP_IZQ;
            if (der && sup) return ESQUINA_SUP_DER;
            if (izq && inf) return ESQUINA_INF_IZQ;
            if (der && inf) return ESQUINA_INF_DER;

            if (izq) return OESTE;
            if (der) return ESTE;
            if (sup) return NORTE;
            if (inf) return SUR;

            return NINGUNO;
        }
        public DireccionEntidades invertirDireccion(DireccionEntidades direccionActual) {
            switch (this) {
                case NORTE:
                    return (direccionActual == ARRIBA) ? ABAJO : direccionActual;
                case SUR:
                    return (direccionActual == ABAJO) ? ARRIBA : direccionActual;
                case ESTE:
                    return (direccionActual == DERECHA) ? IZQUIERDA : direccionActual;
                case OESTE:
                    return (direccionActual == IZQUIERDA) ? DERECHA : direccionActual;
                case ESQUINA_SUP_IZQ:
                    return (direccionActual == ARRIBA) ? ABAJO : DERECHA;
                case ESQUINA_SUP_DER:
                    return (direccionActual == ARRIBA) ? ABAJO : IZQUIERDA;
                case ESQUINA_INF_IZQ:
                    return (direccionActual == ABAJO) ? ARRIBA : DERECHA;
                case ESQUINA_INF_DER:
                    return (direccionActual == ABAJO) ? ARRIBA : IZQUIERDA;
                default:
                    return direccionActual;
            }
        }
    }
}
