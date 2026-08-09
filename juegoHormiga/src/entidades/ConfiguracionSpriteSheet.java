package entidades;

import enums.EnumEntidades.DireccionEntidades;
import imprimir.Imprimir;
import prueba2.RecorteSprite;
import prueba2.Textura;

public class ConfiguracionSpriteSheet {


    public RecorteSprite obtenerRecorte(
            DireccionEntidades direccion, Textura textura,int imagenActual, 
            int columnaImagen, int filaImagen,float anchoSprite, float altoSprite
    ) {

        RecorteSprite base;
        RecorteSprite resultado;
        Imprimir.mostrarEnConsolaln(imagenActual);
        
        switch (direccion) {
            case ARRIBA:
                base = textura.extraertextura(columnaImagen+imagenActual, filaImagen+0, anchoSprite, altoSprite);
                resultado = base;
                break;
            case ABAJO:
                base = textura.extraertextura(columnaImagen+imagenActual, filaImagen+0, anchoSprite, altoSprite);
                resultado = new RecorteSprite(base.getuInicio(), base.getuFin(), base.getvFin(), base.getvInicio());
                break;
            case DERECHA:
                base = textura.extraertextura(columnaImagen+imagenActual, filaImagen+2, anchoSprite, altoSprite);
                resultado = base;
                break;
            case IZQUIERDA:
                base = textura.extraertextura(columnaImagen+imagenActual, filaImagen+2, anchoSprite, altoSprite);
                resultado = new RecorteSprite(base.getuFin(), base.getuInicio(), base.getvInicio(), base.getvFin());
                break;
            default:
                resultado = textura.extraertextura(columnaImagen+imagenActual, filaImagen+0, anchoSprite, altoSprite);
        }

        return resultado;
    }
}