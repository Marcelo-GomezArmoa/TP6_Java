package ejercicio1;

/**
 * Enumeración que representa las categorías de productos disponibles
 * en el sistema de stock.
 */
public enum CategoriaProducto {
    ALIMENTOS("Productos comestibles"),
    ELECTRONICA("Dispositivos electrónicos"),
    ROPA("Prendas de vestir"),
    HOGAR("Artículos para el hogar");

    private final String descripcion;

    /**
     * Constructor del enum
     * @param descripcion Descripción de la categoría
     */
    CategoriaProducto(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la descripción de la categoría
     * @return Descripción de la categoría
     */
    public String getDescripcion() {
        return descripcion;
    }
}