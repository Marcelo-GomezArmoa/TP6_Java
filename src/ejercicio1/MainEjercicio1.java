package ejercicio1;

import java.util.List;

/**
 * Clase principal para probar el sistema de stock
 * Implementa las 10 tareas requeridas del Ejercicio 1
 */
public class MainEjercicio1 {
    public static void main(String[] args) {
        System.out.println("===== SISTEMA DE STOCK - TP6 COLECCIONES =====");
        
        // Crear inventario
        Inventario inventario = new Inventario();
        
        // TAREA 1: Crear al menos cinco productos con diferentes categorías
        System.out.println("\n1. CREANDO Y AGREGANDO PRODUCTOS AL INVENTARIO");
        System.out.println("=".repeat(50));
        
        Producto p1 = new Producto("P001", "Arroz Integral", 1500.0, 25, CategoriaProducto.ALIMENTOS);
        Producto p2 = new Producto("P002", "Smartphone Samsung", 45000.0, 8, CategoriaProducto.ELECTRONICA);
        Producto p3 = new Producto("P003", "Remera Algodón", 2800.0, 15, CategoriaProducto.ROPA);
        Producto p4 = new Producto("P004", "Aspiradora", 12000.0, 5, CategoriaProducto.HOGAR);
        Producto p5 = new Producto("P005", "Pan Integral", 800.0, 30, CategoriaProducto.ALIMENTOS);
        
        inventario.agregarProducto(p1);
        inventario.agregarProducto(p2);
        inventario.agregarProducto(p3);
        inventario.agregarProducto(p4);
        inventario.agregarProducto(p5);
        
        // TAREA 2: Listar todos los productos
        System.out.println("\n2. LISTADO DE TODOS LOS PRODUCTOS");
        System.out.println("=".repeat(50));
        inventario.listarProductos();
        
        // TAREA 3: Buscar un producto por ID
        System.out.println("\n3. BÚSQUEDA DE PRODUCTO POR ID");
        System.out.println("=".repeat(50));
        String idBuscado = "P002";
        Producto encontrado = inventario.buscarProductoPorId(idBuscado);
        if (encontrado != null) {
            System.out.println("Producto encontrado con ID " + idBuscado + ":");
            encontrado.mostrarInfo();
        } else {
            System.out.println("No se encontró producto con ID: " + idBuscado);
        }
        
        // TAREA 4: Filtrar productos por categoría
        System.out.println("\n4. FILTRAR PRODUCTOS POR CATEGORÍA (ALIMENTOS)");
        System.out.println("=".repeat(50));
        List<Producto> alimentosProductos = inventario.filtrarPorCategoria(CategoriaProducto.ALIMENTOS);
        if (alimentosProductos.isEmpty()) {
            System.out.println("No hay productos en la categoría ALIMENTOS");
        } else {
            System.out.println("Productos en categoría ALIMENTOS:");
            for (Producto producto : alimentosProductos) {
                producto.mostrarInfo();
            }
        }
        
        // TAREA 5: Eliminar un producto por ID
        System.out.println("\n5. ELIMINAR PRODUCTO POR ID");
        System.out.println("=".repeat(50));
        String idEliminar = "P005";
        inventario.eliminarProducto(idEliminar);
        System.out.println("\nProductos restantes después de eliminar " + idEliminar + ":");
        inventario.listarProductos();
        
        // TAREA 6: Actualizar stock de un producto
        System.out.println("\n6. ACTUALIZAR STOCK DE PRODUCTO");
        System.out.println("=".repeat(50));
        String idActualizar = "P001";
        int nuevoStock = 50;
        inventario.actualizarStock(idActualizar, nuevoStock);
        
        // TAREA 7: Mostrar total de stock
        System.out.println("\n7. TOTAL DE STOCK DISPONIBLE");
        System.out.println("=".repeat(50));
        int totalStock = inventario.obtenerTotalStock();
        System.out.println("Total de productos en stock: " + totalStock + " unidades");
        
        // TAREA 8: Obtener producto con mayor stock
        System.out.println("\n8. PRODUCTO CON MAYOR STOCK");
        System.out.println("=".repeat(50));
        Producto mayorStock = inventario.obtenerProductoConMayorStock();
        if (mayorStock != null) {
            System.out.println("Producto con mayor stock:");
            mayorStock.mostrarInfo();
        } else {
            System.out.println("No hay productos en el inventario");
        }
        
        // TAREA 9: Filtrar productos por precio (entre $1000 y $3000)
        System.out.println("\n9. FILTRAR PRODUCTOS POR PRECIO ($1000 - $3000)");
        System.out.println("=".repeat(50));
        List<Producto> productosEnRango = inventario.filtrarProductosPorPrecio(1000.0, 3000.0);
        if (productosEnRango.isEmpty()) {
            System.out.println("No hay productos en el rango de precios $1000 - $3000");
        } else {
            System.out.println("Productos con precios entre $1000 y $3000:");
            for (Producto producto : productosEnRango) {
                producto.mostrarInfo();
            }
        }
        
        // TAREA 10: Mostrar categorías disponibles
        System.out.println("\n10. CATEGORÍAS DISPONIBLES");
        System.out.println("=".repeat(50));
        inventario.mostrarCategoriasDisponibles();
        
        System.out.println("\n===== FIN DEL EJERCICIO 1 =====");
    }
}