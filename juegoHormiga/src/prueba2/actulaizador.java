package prueba2;

import entidades.Entidades;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import static org.lwjgl.BufferUtils.createFloatBuffer;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL33.*;

public class actulaizador {

    private final Ventana ventana;
    private Shader shader;
    private Malla malla;

    private int frames = 0;
    private double timer;
    ArrayList<Entidades> arraylistEntidades ;
    public actulaizador(Ventana ventana, Shader shader, Malla malla,ArrayList<Entidades> arraylisEntidades ) {
        this.ventana = ventana;
        this.shader = shader;
        this.malla = malla;
        this.arraylistEntidades=arraylisEntidades;
        
    }
    private void render(int locPosicion, int locUV){
        for (Entidades Entidad : arraylistEntidades) {

            RecorteSprite direcciondo = Entidad.direcciondo();
            float uInicio = direcciondo.getuInicio();
            float uFin = direcciondo.getuFin();
            float vInicio = direcciondo.getvInicio();
            float vFin = direcciondo.getvFin();

            int idTextura = Entidad.getTextura().getIdTextura();
            
            glUniform2f(locPosicion, Entidad.getPosicionEntidad().getPosicionX(),  Entidad.getPosicionEntidad().getPosicionY());
            glUniform4f(locUV, uInicio, vInicio, uFin, vFin);
            glBindTexture(GL_TEXTURE_2D, idTextura);
            glBindVertexArray(malla.getVao());
            glDrawElements(GL_TRIANGLES, 6, GL_UNSIGNED_INT, 0);
            glBindVertexArray(0);
        }
    }
    private void updater(double currentTime){
        for (Entidades Entidad : arraylistEntidades) {
            Entidad.cambioFrame(currentTime);
            
        }
    }
    public void bucle() {
        long handleVentana = ventana.getVentana();
        int shaderProgram = shader.getShaderProgram();

        float[] proyeccion = Proyeccion.crearMatrizOrtografica(
                ventana.getAnchoPantalla(), ventana.getAltoPantalla()
        );
        org.lwjgl.BufferUtils.createFloatBuffer(16);
        FloatBuffer proyeccionBuffer = createFloatBuffer(16);
        proyeccionBuffer.put(proyeccion).flip();

        int locProyeccion = glGetUniformLocation(shaderProgram, "uProjection");
        int locPosicion = glGetUniformLocation(shaderProgram, "uPosicion");
        int locTextura = glGetUniformLocation(shaderProgram, "uTextura");
        int locUV = glGetUniformLocation(shaderProgram, "uUV");

        glUniform1i(locTextura, 0);
        timer = glfwGetTime();

        while (!glfwWindowShouldClose(handleVentana)) {
           
            double currentTime = glfwGetTime();

            glfwPollEvents();

            glClearColor(0f, 0f, 0f, 1f);
            glClear(GL_COLOR_BUFFER_BIT);

            glUseProgram(shaderProgram);
            glUniformMatrix4fv(locProyeccion, false, proyeccionBuffer);
            
            glActiveTexture(GL_TEXTURE0);
            
            updater(currentTime);
            render(locPosicion, locUV);
                
            glfwSwapBuffers(handleVentana);

            frames++;
            if (currentTime - timer >= 1.0) {
                System.out.println("FPS: " + frames);
//                System.out.println("currentTime: " + currentTime);
//                System.out.println("timer: " + timer);
//                System.out.println("-------------");
                frames = 0;
                timer += 1.0;
            }
        }
    }
    
    
}