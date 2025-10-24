package ejercicio2;

/**
 * Clase que representa un libro en el sistema de biblioteca
 * Relación de composición: cada libro pertenece obligatoriamente a una biblioteca
 */
public class Libro {
    private String isbn;
    private String titulo;
    private int anioPublicacion;
    private Autor autor;

    /**
     * Constructor de la clase Libro
     * @param isbn Identificador único del libro (ISBN)
     * @param titulo Título del libro
     * @param anioPublicacion Año de publicación
     * @param autor Autor del libro
     */
    public Libro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
    }

    /**
     * Muestra la información completa del libro en consola
     */
    public void mostrarInfo() {
        System.out.println("================================");
        System.out.println("ISBN: " + isbn);
        System.out.println("Título: " + titulo);
        System.out.println("Año de Publicación: " + anioPublicacion);
        System.out.print("Autor: ");
        if (autor != null) {
            autor.mostrarInfo();
        } else {
            System.out.println("Sin autor asignado");
        }
        System.out.println("================================");
    }

    // Getters y Setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                ", autor=" + (autor != null ? autor.getNombre() : "Sin autor") +
                '}';
    }
}