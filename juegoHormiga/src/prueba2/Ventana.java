package prueba2;

import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glViewport;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Ventana {

    private long ventana; // handle nativo de la ventana GLFW (puntero, no objeto Java)
    private int anchoPantalla, altoPantalla; // resolución de la ventana

    public void crearVentana() {
        if (!glfwInit()) { // inicializa GLFW; obligatorio antes de cualquier otra llamada GLFW
            throw new IllegalStateException("No se pudo inicializar GLFW");
        }

        glfwWindowHint(GLFW_DOUBLEBUFFER, GLFW_TRUE); // activa doble buffer (evita parpadeo)
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3); // versión de OpenGL: 3
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3); // versión de OpenGL: .3 (total 3.3)
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE); // usa el perfil core (sin funciones obsoletas)
        glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GLFW_TRUE); // compatibilidad hacia adelante, requerido en macOS

        long monitor = glfwGetPrimaryMonitor(); // obtiene el monitor principal del sistema
        GLFWVidMode videoMode = glfwGetVideoMode(monitor); // obtiene el modo de video actual del monitor
        anchoPantalla = videoMode.width(); // guarda el ancho de la pantalla
        altoPantalla = videoMode.height(); // guarda el alto de la pantalla

        ventana = glfwCreateWindow(anchoPantalla, altoPantalla, "Mi Juego", NULL, NULL); // crea la ventana (sin monitor fijo = modo ventana, no fullscreen)
        if (ventana == NULL) { // si el handle es NULL, la creación falló
            throw new RuntimeException("Fallo al crear la ventana de GLFW");
        }

        glfwMakeContextCurrent(ventana); // asocia el contexto OpenGL de esta ventana al hilo actual
        GL.createCapabilities(); // carga las funciones de OpenGL disponibles para este contexto

        glfwSwapInterval(1); // VSync

        glViewport(0, 0, anchoPantalla, altoPantalla); // define el área de renderizado dentro de la ventana
        glEnable(GL_BLEND); // activa la mezcla de colores (necesario para transparencias)
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA); // define la fórmula de mezcla (transparencia estándar)
    }

    public void limpiar() {
        glfwDestroyWindow(ventana); // destruye la ventana y libera sus recursos nativos
        glfwTerminate(); // finaliza GLFW por completo (debe ser lo último que se llame)
    }

    public long getVentana() {
        return ventana; // expone el handle de la ventana para otras clases (ej. actulaizador)
    }

    public int getAnchoPantalla() {
        return anchoPantalla; // expone el ancho de pantalla (ej. para calcular la proyección)
    }

    public int getAltoPantalla() {
        return altoPantalla; // expone el alto de pantalla (ej. para calcular la proyección)
    }
}