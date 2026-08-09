package enums;

public class EnumEntidades {
    
    public enum RolesEntidades {
        OBRERA,
        SOLDADO,
        EXPLORACION,
        DEEFENSA,
        ESCUDO,
        ALZADORA,
        CONSTRUCTORA,
        REINA,
        GUIA,
        CONVERTIDORA,
        TRANPORTISTA,
        CRIADORA,
        CRIA
    }
    public enum EstadoEntidades {
        VIVA,
        MUERTA

    }
    public enum EspecieEntidades {
        HORMIGA,
        ARANIA 

    }
    public enum TamanioEntidades {
        CRIA,
        JOVEN,
        ADULTA,
    }
    
    public static enum DireccionEntidades {
        DERECHA,
        IZQUIERDA,
        ARRIBA,
        ABAJO
    }
}


/*
    


    

    private String descripcion;
    private int valor;

    private RolesEntidades(String descripcion) {
        this.descripcion = descripcion;
    }
    private RolesEntidades(int valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public int getvalor() {
        return valor;
    }*/