package ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase que representa una biblioteca
 * Implementa relación de composición 1 a N con Libro
 * Si la Biblioteca se elimina, también se eliminan sus Libros
 */
public class Biblioteca {
    private String nombre;
    private List<Libro> libros;

    /**
     * Constructor de la clase Biblioteca
     * @param nombre Nombre de la biblioteca
     */
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
    }

    /**
     * Agrega un libro a la biblioteca
     * @param isbn ISBN del libro
     * @param titulo Título del libro
     * @param anioPublicacion Año de publicación
     * @param autor Autor del libro
     */
    public void agregarLibro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        // Verificar que no exista un libro con el mismo ISBN
        if (buscarLibroPorIsbn(isbn) != null) {
            System.out.println("Error: Ya existe un libro con ISBN: " + isbn);
            return;
        }

        Libro nuevoLibro = new Libro(isbn, titulo, anioPublicacion, autor);
        libros.add(nuevoLibro);
        System.out.println("Libro agregado exitosamente: " + titulo);
    }

    /**
     * Lista todos los libros de la biblioteca
     */
    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("La biblioteca '" + nombre + "' no tiene libros");
            return;
        }

        System.out.println("\n===== LIBROS EN BIBLIOTECA: " + nombre + " =====");
        for (Libro libro : libros) {
            libro.mostrarInfo();
        }
    }

    /**
     * Busca un libro por su ISBN
     * @param isbn ISBN del libro a buscar
     * @return Libro encontrado o null si no existe
     */
    public Libro buscarLibroPorIsbn(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    /**
     * Elimina un libro de la biblioteca por su ISBN
     * @param isbn ISBN del libro a eliminar
     * @return true si se eliminó exitosamente, false si no se encontró
     */
    public boolean eliminarLibro(String isbn) {
        Libro libro = buscarLibroPorIsbn(isbn);
        if (libro != null) {
            libros.remove(libro);
            System.out.println("Libro eliminado exitosamente: " + libro.getTitulo());
            return true;
        } else {
            System.out.println("No se encontró el libro con ISBN: " + isbn);
            return false;
        }
    }

    /**
     * Obtiene la cantidad total de libros en la biblioteca
     * @return Número de libros
     */
    public int obtenerCantidadLibros() {
        return libros.size();
    }

    /**
     * Filtra libros por año de publicación
     * @param anio Año de publicación a filtrar
     * @return Lista de libros publicados en el año especificado
     */
    public List<Libro> filtrarLibrosPorAnio(int anio) {
        List<Libro> librosFiltrados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAnioPublicacion() == anio) {
                librosFiltrados.add(libro);
            }
        }
        return librosFiltrados;
    }

    /**
     * Muestra todos los autores únicos de los libros en la biblioteca
     */
    public void mostrarAutoresDisponibles() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca");
            return;
        }

        Set<String> autoresUnicos = new HashSet<>();
        System.out.println("\n===== AUTORES DISPONIBLES EN BIBLIOTECA: " + nombre + " =====");
        
        for (Libro libro : libros) {
            if (libro.getAutor() != null) {
                String autorInfo = libro.getAutor().getNombre() + " (" + 
                                 libro.getAutor().getNacionalidad() + ")";
                autoresUnicos.add(autorInfo);
            }
        }

        if (autoresUnicos.isEmpty()) {
            System.out.println("No hay autores registrados");
        } else {
            for (String autor : autoresUnicos) {
                System.out.println("• " + autor);
            }
        }
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nombre='" + nombre + '\'' +
                ", cantidadLibros=" + libros.size() +
                '}';
    }
}