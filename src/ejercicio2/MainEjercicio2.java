package ejercicio2;

import java.util.List;

/**
 * Clase principal para probar el sistema de biblioteca
 * Implementa las 9 tareas requeridas del Ejercicio 2
 */
public class MainEjercicio2 {
    public static void main(String[] args) {
        System.out.println("===== SISTEMA DE BIBLIOTECA - TP6 COLECCIONES =====");
        
        // TAREA 1: Crear una biblioteca
        System.out.println("\n1. CREANDO BIBLIOTECA");
        System.out.println("=".repeat(50));
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central Municipal");
        System.out.println("Biblioteca creada: " + biblioteca.getNombre());
        
        // TAREA 2: Crear al menos tres autores
        System.out.println("\n2. CREANDO AUTORES");
        System.out.println("=".repeat(50));
        Autor autor1 = new Autor("A001", "Gabriel García Márquez", "Colombiana");
        Autor autor2 = new Autor("A002", "Jorge Luis Borges", "Argentina");
        Autor autor3 = new Autor("A003", "Isabel Allende", "Chilena");
        
        System.out.println("Autores creados:");
        autor1.mostrarInfo();
        autor2.mostrarInfo();
        autor3.mostrarInfo();
        
        // TAREA 3: Agregar 5 libros asociados a los autores
        System.out.println("\n3. AGREGANDO LIBROS A LA BIBLIOTECA");
        System.out.println("=".repeat(50));
        biblioteca.agregarLibro("978-84-376-0494-7", "Cien años de soledad", 1967, autor1);
        biblioteca.agregarLibro("978-84-376-0495-8", "El amor en los tiempos del cólera", 1985, autor1);
        biblioteca.agregarLibro("978-84-204-6087-4", "Ficciones", 1944, autor2);
        biblioteca.agregarLibro("978-84-204-6088-5", "El Aleph", 1949, autor2);
        biblioteca.agregarLibro("978-84-204-3935-4", "La casa de los espíritus", 1982, autor3);
        
        // TAREA 4: Listar todos los libros con información del autor
        System.out.println("\n4. LISTADO DE TODOS LOS LIBROS");
        System.out.println("=".repeat(50));
        biblioteca.listarLibros();
        
        // TAREA 5: Buscar un libro por ISBN
        System.out.println("\n5. BÚSQUEDA DE LIBRO POR ISBN");
        System.out.println("=".repeat(50));
        String isbnBuscado = "978-84-376-0494-7";
        Libro libroEncontrado = biblioteca.buscarLibroPorIsbn(isbnBuscado);
        if (libroEncontrado != null) {
            System.out.println("Libro encontrado con ISBN " + isbnBuscado + ":");
            libroEncontrado.mostrarInfo();
        } else {
            System.out.println("No se encontró libro con ISBN: " + isbnBuscado);
        }
        
        // TAREA 6: Filtrar libros por año específico
        System.out.println("\n6. FILTRAR LIBROS POR AÑO (1985)");
        System.out.println("=".repeat(50));
        int anioFiltro = 1985;
        List<Libro> librosPorAnio = biblioteca.filtrarLibrosPorAnio(anioFiltro);
        if (librosPorAnio.isEmpty()) {
            System.out.println("No hay libros publicados en el año " + anioFiltro);
        } else {
            System.out.println("Libros publicados en " + anioFiltro + ":");
            for (Libro libro : librosPorAnio) {
                libro.mostrarInfo();
            }
        }
        
        // TAREA 7: Eliminar un libro por ISBN
        System.out.println("\n7. ELIMINAR LIBRO POR ISBN");
        System.out.println("=".repeat(50));
        String isbnEliminar = "978-84-204-6088-5";
        biblioteca.eliminarLibro(isbnEliminar);
        System.out.println("\nLibros restantes después de eliminar " + isbnEliminar + ":");
        biblioteca.listarLibros();
        
        // TAREA 8: Mostrar cantidad total de libros
        System.out.println("\n8. CANTIDAD TOTAL DE LIBROS");
        System.out.println("=".repeat(50));
        int cantidadTotal = biblioteca.obtenerCantidadLibros();
        System.out.println("Cantidad total de libros en la biblioteca: " + cantidadTotal);
        
        // TAREA 9: Listar todos los autores disponibles
        System.out.println("\n9. AUTORES DISPONIBLES EN LA BIBLIOTECA");
        System.out.println("=".repeat(50));
        biblioteca.mostrarAutoresDisponibles();
        
        System.out.println("\n===== FIN DEL EJERCICIO 2 =====");
        
        // Demostración de composición: si eliminamos la biblioteca, los libros también se eliminan
        System.out.println("\n===== DEMOSTRACIÓN DE COMPOSICIÓN =====");
        System.out.println("Al eliminar la biblioteca, los libros también se eliminan automáticamente");
        System.out.println("(En Java esto ocurre por garbage collection cuando no hay más referencias)");
        biblioteca = null; // La biblioteca y sus libros serán eliminados por el garbage collector
        System.out.println("Biblioteca eliminada exitosamente");
    }
}