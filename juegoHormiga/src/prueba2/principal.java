package prueba2;

import entidades.ConfiguracionSpriteSheet;
import entidades.Entidades;
import static enums.EnumEntidades.DireccionEntidades.*;
import java.util.ArrayList;
import movimientos.cordenadas;

public class principal {

    private static final String RUTA_SPRITE_SHEET = "/home/frank-user/Imágenes/2.png";
    private static final float ANCHO_SPRITE = 256f;
    private static final float ALTO_SPRITE = 256f;
    private static final int COLUMNA_HORMIGA = 16;
    private static final int FILA_HORMIGA = 0;

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.crearVentana();
        Shader shader = new Shader();
        Malla malla = new Malla();
        Textura textura = new Textura();
        ArrayList<Entidades> arraylisEntidades = new ArrayList<>();
        
        ConfiguracionSpriteSheet ConfiguracionSpriteSheet=new ConfiguracionSpriteSheet();
        shader.crearShaders();

        malla.crearQuad(ANCHO_SPRITE, ALTO_SPRITE);

        textura.cargarTextura(RUTA_SPRITE_SHEET);
        
        Entidades entidad = new Entidades(
                new cordenadas(0, 0, ANCHO_SPRITE, ALTO_SPRITE),
                COLUMNA_HORMIGA, 
                FILA_HORMIGA, 
                ANCHO_SPRITE, 
                ALTO_SPRITE,
                textura,
                ConfiguracionSpriteSheet,ABAJO,4);
        Entidades entidad2 = new Entidades(
                new cordenadas(256,256, ANCHO_SPRITE, ALTO_SPRITE),
                COLUMNA_HORMIGA, 
                FILA_HORMIGA, 
                ANCHO_SPRITE, 
                ALTO_SPRITE,
                textura,
                ConfiguracionSpriteSheet,ARRIBA,4);
        Entidades entidad3 = new Entidades(
                new cordenadas(256,0, ANCHO_SPRITE, ALTO_SPRITE),
                COLUMNA_HORMIGA, 
                FILA_HORMIGA, 
                ANCHO_SPRITE, 
                ALTO_SPRITE,
                textura,ConfiguracionSpriteSheet,DERECHA,4);
        Entidades entidad4 = new Entidades(
                new cordenadas(0,256, ANCHO_SPRITE, ALTO_SPRITE),
                COLUMNA_HORMIGA, 
                FILA_HORMIGA, 
                ANCHO_SPRITE, 
                ALTO_SPRITE,
                textura,ConfiguracionSpriteSheet,IZQUIERDA,4);
        
        arraylisEntidades.add(entidad);
        arraylisEntidades.add(entidad2);
        arraylisEntidades.add(entidad3);
        arraylisEntidades.add(entidad4);
        
        //textura.extraertextura(COLUMNA_HORMIGA, FILA_HORMIGA, ANCHO_SPRITE, ALTO_SPRITE);
        actulaizador actulaizador = new actulaizador(ventana, shader, malla,arraylisEntidades);
        actulaizador.bucle();

        malla.limpiar();
        textura.limpiar();
        shader.limpiar();
        ventana.limpiar();
    }
}