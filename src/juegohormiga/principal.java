package juegohormiga;

import consumibles.Comida;
import entidades.ConfiguracionSpriteSheet;
import entidades.Entidades;
import static enums.EnumEntidades.DireccionEntidades.*;
import imprimir.Imprimir;
import java.util.ArrayList;
import movimientos.Cordenadas;
import movimientos.GestorDeEntorno;
import movimientos.InterfasDeMovimiento;
import movimientos.MoverAObjetivo;
import movimientos.MoverAlatorio;
import prueba2.Malla;
import prueba2.Shader;
import prueba2.Textura;
import prueba2.Ventana;
import prueba2.actulaizador;

public class principal {

    private static final String RUTA_SPRITE_SHEET = "/home/frank-user/Imágenes/2.png";
    private static final float ANCHO_SPRITE = 256f;
    private static final float ALTO_SPRITE = 256f;
    private static final int COLUMNA_HORMIGA = 16;
    private static final int FILA_HORMIGA = 0;
    private static void inicio(){
        
        Ventana ventana = new Ventana();
        ventana.crearVentana();
        Shader shader = new Shader();
        Malla malla = new Malla();
        Textura textura = new Textura();
        ArrayList<Entidades> arraylisEntidades = new ArrayList<>();
        ArrayList<Comida> arraylisComida = new ArrayList<>();
        
        ConfiguracionSpriteSheet ConfiguracionSpriteSheet=new ConfiguracionSpriteSheet();
        shader.crearShaders();

        malla.crearQuad(ANCHO_SPRITE, ALTO_SPRITE);

        textura.cargarTextura(RUTA_SPRITE_SHEET);
        InterfasDeMovimiento InterfasDeMovimiento2 = new MoverAlatorio(new GestorDeEntorno(ventana.getAnchoPantalla(),ventana.getAltoPantalla()));
        MoverAObjetivo InterfasDeMovimiento = new MoverAObjetivo();
        InterfasDeMovimiento.setObjetivo(new Cordenadas(500, 500, 0, 0, 0, 0));
        Entidades entidad = new Entidades(
                new Cordenadas(0, 0, ANCHO_SPRITE, ALTO_SPRITE,COLUMNA_HORMIGA,FILA_HORMIGA),
                textura,
                ConfiguracionSpriteSheet,
                ABAJO,
                InterfasDeMovimiento,
                4
        );
        Entidades entidad2 = new Entidades(
                new Cordenadas(256,256, ANCHO_SPRITE, ALTO_SPRITE,COLUMNA_HORMIGA,FILA_HORMIGA),
                textura,
                ConfiguracionSpriteSheet,
                ARRIBA,
                InterfasDeMovimiento,
                4
        );
        Entidades entidad3 = new Entidades(
                new Cordenadas(256,0, ANCHO_SPRITE, ALTO_SPRITE,COLUMNA_HORMIGA,FILA_HORMIGA),
                textura,
                ConfiguracionSpriteSheet,
                DERECHA,
                InterfasDeMovimiento,
                4
        );
        Entidades entidad4 = new Entidades(
                new Cordenadas(0,256, ANCHO_SPRITE, ALTO_SPRITE,COLUMNA_HORMIGA,FILA_HORMIGA),
                textura,ConfiguracionSpriteSheet,
                IZQUIERDA,
                InterfasDeMovimiento,
                4
        );
        
        arraylisEntidades.add(entidad);
        arraylisEntidades.add(entidad2);
        arraylisEntidades.add(entidad3);
        arraylisEntidades.add(entidad4);
        
        //textura.extraertextura(COLUMNA_HORMIGA, FILA_HORMIGA, ANCHO_SPRITE, ALTO_SPRITE);
        actulaizador actulaizador = new actulaizador(ventana, shader, malla,arraylisEntidades,arraylisComida);
        actulaizador.bucle();

        malla.limpiar();
        textura.limpiar();
        shader.limpiar();
        ventana.limpiar();
    }
    public static void main(String[] args) {

        inicio();
    }
}