package prueba2;

public class Proyeccion {

    public static float[] crearMatrizOrtografica(float ancho, float alto) {
        float[] m = new float[16];
        m[0] = 2f / ancho;
        m[5] = -2f / alto;
        m[10] = -1f;
        m[12] = -1f;
        m[13] = 1f;
        m[15] = 1f;
        return m;
    }
}