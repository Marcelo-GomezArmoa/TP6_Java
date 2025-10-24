package ejercicio1;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un inventario de productos
 */
public class Inventario {
    private ArrayList<Producto> productos;

    /**
     * Constructor de la clase Inventario
     */
    public Inventario() {
        this.productos = new ArrayList<>();
    }

    /**
     * Agrega un producto al inventario
     * @param p Producto a agregar
     */
    public void agregarProducto(Producto p) {
        if (p != null) {
            productos.add(p);
            System.out.println("Producto agregado exitosamente: " + p.getNombre());
        } else {
            System.out.println("Error: No se puede agregar un producto nulo");
        }
    }

    /**
     * Lista todos los productos del inventario
     */
    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío");
            return;
        }

        System.out.println("\n===== LISTADO DE PRODUCTOS =====");
        for (Producto producto : productos) {
            producto.mostrarInfo();
        }
    }

    /**
     * Busca un producto por su ID
     * @param id ID del producto a buscar
     * @return Producto encontrado o null si no existe
     */
    public Producto buscarProductoPorId(String id) {
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                return producto;
            }
        }
        return null;
    }

    /**
     * Elimina un producto del inventario por su ID
     * @param id ID del producto a eliminar
     * @return true si se eliminó exitosamente, false si no se encontró
     */
    public boolean eliminarProducto(String id) {
        Producto producto = buscarProductoPorId(id);
        if (producto != null) {
            productos.remove(producto);
            System.out.println("Producto eliminado exitosamente: " + producto.getNombre());
            return true;
        } else {
            System.out.println("No se encontró el producto con ID: " + id);
            return false;
        }
    }

    /**
     * Actualiza el stock de un producto
     * @param id ID del producto
     * @param nuevaCantidad Nueva cantidad en stock
     * @return true si se actualizó exitosamente, false si no se encontró
     */
    public boolean actualizarStock(String id, int nuevaCantidad) {
        Producto producto = buscarProductoPorId(id);
        if (producto != null) {
            int cantidadAnterior = producto.getCantidad();
            producto.setCantidad(nuevaCantidad);
            System.out.println("Stock actualizado para " + producto.getNombre() + 
                             ": " + cantidadAnterior + " → " + nuevaCantidad);
            return true;
        } else {
            System.out.println("No se encontró el producto con ID: " + id);
            return false;
        }
    }

    /**
     * Filtra productos por categoría
     * @param categoria Categoría a filtrar
     * @return Lista de productos de la categoría especificada
     */
    public List<Producto> filtrarPorCategoria(CategoriaProducto categoria) {
        List<Producto> productosFiltrados = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getCategoria() == categoria) {
                productosFiltrados.add(producto);
            }
        }
        return productosFiltrados;
    }

    /**
     * Obtiene el total de stock de todos los productos
     * @return Suma total de cantidades en stock
     */
    public int obtenerTotalStock() {
        int total = 0;
        for (Producto producto : productos) {
            total += producto.getCantidad();
        }
        return total;
    }

    /**
     * Obtiene el producto con mayor stock
     * @return Producto con mayor cantidad en stock o null si no hay productos
     */
    public Producto obtenerProductoConMayorStock() {
        if (productos.isEmpty()) {
            return null;
        }

        Producto productoConMayorStock = productos.get(0);
        for (Producto producto : productos) {
            if (producto.getCantidad() > productoConMayorStock.getCantidad()) {
                productoConMayorStock = producto;
            }
        }
        return productoConMayorStock;
    }

    /**
     * Filtra productos por rango de precios
     * @param min Precio mínimo
     * @param max Precio máximo
     * @return Lista de productos dentro del rango de precios
     */
    public List<Producto> filtrarProductosPorPrecio(double min, double max) {
        List<Producto> productosFiltrados = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getPrecio() >= min && producto.getPrecio() <= max) {
                productosFiltrados.add(producto);
            }
        }
        return productosFiltrados;
    }

    /**
     * Muestra todas las categorías disponibles con sus descripciones
     */
    public void mostrarCategoriasDisponibles() {
        System.out.println("\n===== CATEGORÍAS DISPONIBLES =====");
        for (CategoriaProducto categoria : CategoriaProducto.values()) {
            System.out.println(categoria + ": " + categoria.getDescripcion());
        }
    }

    /**
     * Obtiene la lista de productos
     * @return ArrayList de productos
     */
    public ArrayList<Producto> getProductos() {
        return productos;
    }
}