import java.util.Scanner;

/**
 * Clase principal del TP6 - Colecciones
 * Permite ejecutar cualquiera de los tres ejercicios implementados
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===============================================");
        System.out.println("    TP6 - COLECCIONES Y SISTEMA DE STOCK");
        System.out.println("         PROGRAMACIÓN II - 2025");
        System.out.println("===============================================");
        
        while (true) {
            System.out.println("\n¿Qué ejercicio deseas ejecutar?");
            System.out.println("1. Ejercicio 1 - Sistema de Stock (Inventario)");
            System.out.println("2. Ejercicio 2 - Sistema de Biblioteca");
            System.out.println("3. Ejercicio 3 - Sistema Universitario (Bidireccional)");
            System.out.println("4. Mostrar información del proyecto");
            System.out.println("0. Salir");
            System.out.print("\nIngresa tu opción (0-4): ");
            
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("\n" + "=".repeat(50));
                    System.out.println("EJECUTANDO EJERCICIO 1 - SISTEMA DE STOCK");
                    System.out.println("=".repeat(50));
                    ejercicio1.MainEjercicio1.main(new String[]{});
                    break;
                    
                case 2:
                    System.out.println("\n" + "=".repeat(50));
                    System.out.println("EJECUTANDO EJERCICIO 2 - SISTEMA DE BIBLIOTECA");
                    System.out.println("=".repeat(50));
                    ejercicio2.MainEjercicio2.main(new String[]{});
                    break;
                    
                case 3:
                    System.out.println("\n" + "=".repeat(50));
                    System.out.println("EJECUTANDO EJERCICIO 3 - SISTEMA UNIVERSITARIO");
                    System.out.println("=".repeat(50));
                    ejercicio3.MainEjercicio3.main(new String[]{});
                    break;
                    
                case 4:
                    mostrarInformacionProyecto();
                    break;
                    
                case 0:
                    System.out.println("\n¡Gracias por usar el sistema! 👋");
                    System.out.println("TP6 realizado exitosamente ✅");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("\n❌ Opción inválida. Por favor, ingresa un número del 0 al 4.");
            }
            
            System.out.println("\n" + "=".repeat(60));
            System.out.println("¿Deseas ejecutar otro ejercicio? (Presiona Enter para continuar)");
            try {
                System.in.read();
                System.in.read(); // Consumir el salto de línea
            } catch (Exception e) {
                // Ignorar excepción
            }
        }
    }
    
    private static void mostrarInformacionProyecto() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("           INFORMACIÓN DEL PROYECTO");
        System.out.println("=".repeat(60));
        System.out.println("📚 TRABAJO PRÁCTICO 6: Colecciones y Sistema de Stock");
        System.out.println("🎓 MATERIA: Programación II");
        System.out.println("📅 AÑO: 2025");
        System.out.println();
        System.out.println("🎯 OBJETIVO:");
        System.out.println("   Desarrollar estructuras de datos dinámicas en Java mediante");
        System.out.println("   el uso de colecciones (ArrayList) y enumeraciones (enum)");
        System.out.println();
        System.out.println("📋 EJERCICIOS IMPLEMENTADOS:");
        System.out.println("   1️⃣  Sistema de Stock con Inventario");
        System.out.println("       • Enum CategoriaProducto con descripciones");
        System.out.println("       • Clase Producto con encapsulamiento");
        System.out.println("       • Clase Inventario con ArrayList");
        System.out.println("       • 10 tareas de gestión implementadas");
        System.out.println();
        System.out.println("   2️⃣  Sistema de Biblioteca (Composición 1 a N)");
        System.out.println("       • Relación Biblioteca → Libros");
        System.out.println("       • Composición: si se elimina biblioteca, se eliminan libros");
        System.out.println("       • Gestión de autores y filtrado por año");
        System.out.println("       • 9 tareas de biblioteca implementadas");
        System.out.println();
        System.out.println("   3️⃣  Sistema Universitario (Bidireccional 1 a N)");
        System.out.println("       • Relación bidireccional Profesor ⟷ Curso");
        System.out.println("       • Sincronización automática en ambos lados");
        System.out.println("       • Invariantes de asociación mantenidos");
        System.out.println("       • 8 tareas universitarias implementadas");
        System.out.println();
        System.out.println("🔧 CONCEPTOS APLICADOS:");
        System.out.println("   ✅ ArrayList y colecciones dinámicas");
        System.out.println("   ✅ Enumeraciones (enum) con métodos");
        System.out.println("   ✅ Relaciones 1 a N y composición");
        System.out.println("   ✅ Relaciones bidireccionales");
        System.out.println("   ✅ Encapsulamiento y métodos");
        System.out.println("   ✅ Búsqueda, filtrado y ordenamiento");
        System.out.println("   ✅ Ciclos for-each y operaciones CRUD");
        System.out.println();
        System.out.println("📁 ESTRUCTURA:");
        System.out.println("   src/ejercicio1/ - Sistema de Stock");
        System.out.println("   src/ejercicio2/ - Sistema de Biblioteca");
        System.out.println("   src/ejercicio3/ - Sistema Universitario");
        System.out.println("   README.md - Documentación completa");
        System.out.println("=".repeat(60));
    }
}