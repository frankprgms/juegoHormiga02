package prueba2;

import static org.lwjgl.opengl.GL33.*;

public class Shader {

    private int shaderProgram;

    public void crearShaders() {
        String vertexSrc =
            "#version 330 core\n" +
            "layout (location = 0) in vec2 aPos;\n" +
            "layout (location = 1) in vec2 aTexCoord;\n" +
            "uniform mat4 uProjection;\n" +
            "uniform vec2 uPosicion;\n" +
            "uniform vec4 uUV;\n" +
            "out vec2 vTexCoord;\n" +
            "void main() {\n" +
            "    gl_Position = uProjection * vec4(aPos + uPosicion, 0.0, 1.0);\n" +
            "    vTexCoord = mix(uUV.xy, uUV.zw, aTexCoord);\n" +
            "}\n";

        String fragmentSrc =
            "#version 330 core\n" +
            "in vec2 vTexCoord;\n" +
            "out vec4 FragColor;\n" +
            "uniform sampler2D uTextura;\n" +
            "void main() {\n" +
            "    FragColor = texture(uTextura, vTexCoord);\n" +
            "}\n";

        int vertexShader = compilarShader(GL_VERTEX_SHADER, vertexSrc);
        int fragmentShader = compilarShader(GL_FRAGMENT_SHADER, fragmentSrc);

        shaderProgram = glCreateProgram();
        glAttachShader(shaderProgram, vertexShader);
        glAttachShader(shaderProgram, fragmentShader);
        glLinkProgram(shaderProgram);

        if (glGetProgrami(shaderProgram, GL_LINK_STATUS) == GL_FALSE) {
            throw new RuntimeException("Error al enlazar el programa de shaders: " + glGetProgramInfoLog(shaderProgram));
        }

        glDeleteShader(vertexShader);
        glDeleteShader(fragmentShader);
    }

    private int compilarShader(int tipo, String fuente) {
        int shader = glCreateShader(tipo);
        glShaderSource(shader, fuente);
        glCompileShader(shader);
        if (glGetShaderi(shader, GL_COMPILE_STATUS) == GL_FALSE) {
            throw new RuntimeException("Error al compilar shader: " + glGetShaderInfoLog(shader));
        }
        return shader;
    }

    public int getShaderProgram() {
        return shaderProgram;
    }
    
    public void limpiar() {
        glDeleteProgram(shaderProgram);
    }
}