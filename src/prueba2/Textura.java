package prueba2;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL33.*;
import static org.lwjgl.stb.STBImage.*;
import static org.lwjgl.system.MemoryStack.stackPush;

public class Textura {

    private int idTextura;
    private float uInicio, uFin, vInicio, vFin;
    private int anchoImagen;
    private int altoImagen;

    public void cargarTextura(String rutaSpriteSheet ) {
        try (org.lwjgl.system.MemoryStack stack = stackPush()) {
            IntBuffer w = stack.mallocInt(1);
            IntBuffer h = stack.mallocInt(1);
            IntBuffer comp = stack.mallocInt(1);

            stbi_set_flip_vertically_on_load(false);

            ByteBuffer imagen = stbi_load(rutaSpriteSheet, w, h, comp, 4);
            if (imagen == null) {
                throw new RuntimeException("Error al cargar la imagen: " + stbi_failure_reason());
            }

            anchoImagen = w.get();
            altoImagen = h.get();

            idTextura = glGenTextures();
            glBindTexture(GL_TEXTURE_2D, idTextura);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);

            glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, anchoImagen, altoImagen, 0, GL_RGBA, GL_UNSIGNED_BYTE, imagen);

            stbi_image_free(imagen);

        }
    }
    
    public RecorteSprite extraertextura(int columnaImagen, int filaImagen,float anchoSprite, float altoSprite){
        
        uInicio = (columnaImagen * anchoSprite) / anchoImagen;
        uFin    = ((columnaImagen + 1) * anchoSprite) / anchoImagen;
        vInicio = (filaImagen * altoSprite) / altoImagen;
        vFin    = ((filaImagen + 1) * altoSprite) / altoImagen;
        return new RecorteSprite(uInicio, uFin, vInicio, vFin);
        
    }

    public void limpiar() {
        glDeleteTextures(idTextura);
    }

    public int getIdTextura() {
        return idTextura;
    }

    public float getuInicio() {
        return uInicio;
    }

    public float getuFin() {
        return uFin;
    }

    public float getvInicio() {
        return vInicio;
    }

    public float getvFin() {
        return vFin;
    }
}