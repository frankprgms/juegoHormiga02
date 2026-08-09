
package enums;

import static enums.EnumTecnologia.Categoria.EDIFICIOS;
import static enums.EnumTecnologia.Categoria.MEJORAS_UNIDADES;
import static enums.EnumTecnologia.Categoria.NIDO;
import java.util.ArrayList;


public class EnumTecnologia {
    
    
    public enum Categoria {
        MEJORAS_UNIDADES, NIDO, EDIFICIOS
    }
    public enum NombreTecnologia {
        
        // ------------------ Sin categoría ------------------
        NADA(null, null, "Tecnología base sin efectos"),

        // ------------------ MEJORAS_UNIDADES ------------------
        CAMARA_DE_CRIA_AVANZADA(MEJORAS_UNIDADES, new NombreTecnologia[]{NADA}, "Aumenta la tasa de reproducción"),
        VELOCIDAD_MEJORADA(MEJORAS_UNIDADES, new NombreTecnologia[]{CAMARA_DE_CRIA_AVANZADA}, "Incrementa la velocidad de las unidades"),
        ATAQUE_MEJORADO(MEJORAS_UNIDADES, new NombreTecnologia[]{VELOCIDAD_MEJORADA}, "Mejora el daño de ataque"),
        DEFENSA_MEJORADA(MEJORAS_UNIDADES, new NombreTecnologia[]{ATAQUE_MEJORADO}, "Incrementa la defensa de las unidades"),
        ESCUDO_MEJORADO(MEJORAS_UNIDADES, new NombreTecnologia[]{DEFENSA_MEJORADA}, "Agrega escudos a las unidades"),

        // ------------------ NIDO ------------------
        INCUBADORA_DE_LARVAS(EDIFICIOS, new NombreTecnologia[]{NADA}, "Permite generar nuevas larvas"),
        HORMIGA_DE_EXPLORACION(NIDO, new NombreTecnologia[]{INCUBADORA_DE_LARVAS}, "Habilita unidades exploradoras"),
        HORMIGA_DE_CONTRUCCION(NIDO, new NombreTecnologia[]{INCUBADORA_DE_LARVAS}, "Permite construir estructuras"),
        HORMIGA_DE_ATAQUE(NIDO, new NombreTecnologia[]{HORMIGA_DE_CONTRUCCION}, "Unidad ofensiva básica"),
        HORMIGA_DE_DEFENSA(NIDO, new NombreTecnologia[]{HORMIGA_DE_ATAQUE}, "Unidad defensiva básica"),
        HORMIGA_DE_ESCUDO(NIDO, new NombreTecnologia[]{HORMIGA_DE_DEFENSA}, "Unidad tanque con escudo"),

        // ------------------ CONSTRUCCIÓN ------------------
        CAMARA_DE_CONSTRUTORAS(EDIFICIOS, new NombreTecnologia[]{HORMIGA_DE_CONTRUCCION}, "Centro de operaciones de construcción"),
        AMPLIACION_DE_COLMENA(EDIFICIOS, new NombreTecnologia[]{CAMARA_DE_CONSTRUTORAS}, "Expande la capacidad del nido"),
        ALMACENAMIENTO(EDIFICIOS, new NombreTecnologia[]{AMPLIACION_DE_COLMENA}, "Aumenta la capacidad de recursos"),
        VENTILADORES(EDIFICIOS, new NombreTecnologia[]{ALMACENAMIENTO}, "Permite la contruccion de ventildores para mejora la ventilación del nido"),

        // ------------------ MULTI-REQUISITOS ------------------
        HORMIGA_DE_PODEROSA(NIDO, new NombreTecnologia[]{ATAQUE_MEJORADO, DEFENSA_MEJORADA, ESCUDO_MEJORADO}, "Unidad de élite poderosa"),
        TECNOLOGIA_AVANZADA(MEJORAS_UNIDADES, new NombreTecnologia[]{ATAQUE_MEJORADO, DEFENSA_MEJORADA, ESCUDO_MEJORADO}, "Desbloquea todas las tecnologías avanzadas");

            
        
            
            

        private final Categoria categoria;
        private final NombreTecnologia []requisito;
        private String descripcion;

        NombreTecnologia(Categoria categoria,NombreTecnologia [] requisito, String descripcion) {
            this.categoria = categoria;
            this.requisito = requisito;
            this.descripcion = descripcion;
        }
        
        public Categoria getCategoria() {
            return categoria;
        }
        public NombreTecnologia []getRequisitos() {
            return requisito;
        }

        public String getDescripcion() {
            return descripcion;
        }
    }
}


/*public enum NombreTecnologia{
        NADA,
        //----------------------------------------------------------------------------------
        CAMARA_DE_CRIA_AVANZADA,VELOCIDAD_MEJORADA,ATAQUE_MEJORADO,DEFENSA_MEJORADA,ESCUDO_MEJORADO,
        //------------------------------------------------------------------------------------
        INCUBADORA_DE_LARVAS,HORMIGA_DE_ATAQUE,HORMIGA_DE_DEFENSA,HORMIGA_DE_ESCUDO,HORMIGA_DE_EXPLORACION,SS,SSS,SSSS,
        //-----------------------------------------------------------------------------------------
        CAMARA_DE_CONSTRUTORAS,HORMIGA_DE_CONTRUCCION,AMPLIACION_DE_COLMENA,ALMACENAMIENTO,VENTILADORES
    }*/
        
        /*CAMARA_DE_CRIA_AVANZADA(Categoria.MEJORAS_UNIDADES),
        VELOCIDAD_MEJORADA(Categoria.MEJORAS_UNIDADES),
        ATAQUE_MEJORADO(Categoria.NIDO),
        DEFENSA_MEJORADA(Categoria.NIDO),
        ESCUDO_MEJORADO(Categoria.NIDO),
        INCUBADORA_DE_LARVAS(Categoria.NIDO),
        HORMIGA_DE_ATAQUE(Categoria.NIDO),
        HORMIGA_DE_DEFENSA(Categoria.NIDO),
        HORMIGA_DE_ESCUDO(Categoria.NIDO),
        HORMIGA_DE_EXPLORACION(Categoria.NIDO),
        SS(Categoria.NIDO),
        SSS(Categoria.NIDO),
        SSSS(Categoria.NIDO),
        CAMARA_DE_CONSTRUTORAS(Categoria.EDIFICIOS),
        HORMIGA_DE_CONTRUCCION(Categoria.EDIFICIOS),
        AMPLIACION_DE_COLMENA(Categoria.EDIFICIOS),
        ALMACENAMIENTO(Categoria.EDIFICIOS),
        VENTILADORES(Categoria.EDIFICIOS),
        NADA(null);*/



//unidades
//bonos CAMARA_DE_CRIA_AVANZADA
//edificios  CAMARA_DE_CRIA_AVANZADA