package ejercicio2;

/**
 * Clase que representa un autor en el sistema de biblioteca
 */
public class Autor {
    private String id;
    private String nombre;
    private String nacionalidad;

    /**
     * Constructor de la clase Autor
     * @param id Identificador único del autor
     * @param nombre Nombre del autor
     * @param nacionalidad Nacionalidad del autor
     */
    public Autor(String id, String nombre, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    /**
     * Muestra la información del autor en consola
     */
    public void mostrarInfo() {
        System.out.println("Autor ID: " + id + " | Nombre: " + nombre + " | Nacionalidad: " + nacionalidad);
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }
}