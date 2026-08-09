
package enums;


public enum TipoDeConstrucciones {
    
    casa("Unidad trabajadora"),
    Colomena("Unidad hostil");
    
    
    
    String descripcion;
    
    TipoDeConstrucciones(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
