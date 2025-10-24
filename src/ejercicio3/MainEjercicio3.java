package ejercicio3;

/**
 * Clase principal para probar el sistema universitario
 * Implementa las 8 tareas requeridas del Ejercicio 3
 * Demuestra relación bidireccional entre Profesor y Curso
 */
public class MainEjercicio3 {
    public static void main(String[] args) {
        System.out.println("===== SISTEMA UNIVERSITARIO - TP6 COLECCIONES =====");
        System.out.println("Demostrando relación bidireccional Profesor ⟷ Curso");
        
        // Crear universidad
        Universidad universidad = new Universidad("Universidad Nacional de Tecnología");
        System.out.println("\nUniversidad creada: " + universidad.getNombre());
        
        // TAREA 1: Crear al menos 3 profesores y 5 cursos
        System.out.println("\n1. CREANDO PROFESORES Y CURSOS");
        System.out.println("=".repeat(60));
        
        // Crear profesores
        Profesor prof1 = new Profesor("P001", "Dr. Ana García", "Programación");
        Profesor prof2 = new Profesor("P002", "Mg. Carlos Rodríguez", "Matemáticas");
        Profesor prof3 = new Profesor("P003", "Dr. María López", "Bases de Datos");
        
        // Crear cursos
        Curso curso1 = new Curso("CS101", "Introducción a la Programación");
        Curso curso2 = new Curso("CS201", "Programación Orientada a Objetos");
        Curso curso3 = new Curso("MAT101", "Álgebra Lineal");
        Curso curso4 = new Curso("MAT201", "Cálculo Diferencial");
        Curso curso5 = new Curso("DB101", "Fundamentos de Bases de Datos");
        
        System.out.println("Profesores y cursos creados exitosamente");
        
        // TAREA 2: Agregar profesores y cursos a la universidad
        System.out.println("\n2. AGREGANDO PROFESORES Y CURSOS A LA UNIVERSIDAD");
        System.out.println("=".repeat(60));
        
        universidad.agregarProfesor(prof1);
        universidad.agregarProfesor(prof2);
        universidad.agregarProfesor(prof3);
        
        universidad.agregarCurso(curso1);
        universidad.agregarCurso(curso2);
        universidad.agregarCurso(curso3);
        universidad.agregarCurso(curso4);
        universidad.agregarCurso(curso5);
        
        // TAREA 3: Asignar profesores a cursos
        System.out.println("\n3. ASIGNANDO PROFESORES A CURSOS");
        System.out.println("=".repeat(60));
        
        universidad.asignarProfesorACurso("CS101", "P001");
        universidad.asignarProfesorACurso("CS201", "P001");
        universidad.asignarProfesorACurso("MAT101", "P002");
        universidad.asignarProfesorACurso("MAT201", "P002");
        universidad.asignarProfesorACurso("DB101", "P003");
        
        // TAREA 4: Listar cursos con su profesor y profesores con sus cursos
        System.out.println("\n4. LISTADO DE CURSOS CON SUS PROFESORES");
        System.out.println("=".repeat(60));
        universidad.listarCursos();
        
        System.out.println("\n4. LISTADO DE PROFESORES CON SUS CURSOS");
        System.out.println("=".repeat(60));
        universidad.listarProfesores();
        
        // TAREA 5: Cambiar el profesor de un curso y verificar sincronización
        System.out.println("\n5. CAMBIANDO PROFESOR DE UN CURSO (BIDIRECCIONALIDAD)");
        System.out.println("=".repeat(60));
        
        System.out.println("Antes del cambio:");
        Curso cursoCambio = universidad.buscarCursoPorCodigo("DB101");
        System.out.println("Curso " + cursoCambio.getNombre() + " tiene profesor: " + 
                         (cursoCambio.getProfesor() != null ? cursoCambio.getProfesor().getNombre() : "Ninguno"));
        
        // Cambiar el profesor del curso DB101 de Prof3 a Prof1
        universidad.asignarProfesorACurso("DB101", "P001");
        
        System.out.println("\nDespués del cambio:");
        System.out.println("Curso " + cursoCambio.getNombre() + " tiene profesor: " + 
                         (cursoCambio.getProfesor() != null ? cursoCambio.getProfesor().getNombre() : "Ninguno"));
        
        System.out.println("\nVerificando sincronización bidireccional:");
        System.out.println("Cursos del Prof. Ana García (debe incluir DB101):");
        prof1.listarCursos();
        System.out.println("Cursos del Dr. María López (no debe incluir DB101):");
        prof3.listarCursos();
        
        // TAREA 6: Remover un curso y confirmar que no aparece en la lista del profesor
        System.out.println("\n6. ELIMINANDO UN CURSO Y VERIFICANDO SINCRONIZACIÓN");
        System.out.println("=".repeat(60));
        
        System.out.println("Antes de eliminar CS201:");
        prof1.listarCursos();
        
        universidad.eliminarCurso("CS201");
        
        System.out.println("\nDespués de eliminar CS201:");
        prof1.listarCursos();
        
        // TAREA 7: Remover un profesor y dejar profesor = null en sus cursos
        System.out.println("\n7. ELIMINANDO UN PROFESOR Y ACTUALIZANDO SUS CURSOS");
        System.out.println("=".repeat(60));
        
        System.out.println("Antes de eliminar Prof. Carlos Rodríguez:");
        Curso cursoMat = universidad.buscarCursoPorCodigo("MAT101");
        System.out.println("Curso MAT101 tiene profesor: " + 
                         (cursoMat.getProfesor() != null ? cursoMat.getProfesor().getNombre() : "Ninguno"));
        
        universidad.eliminarProfesor("P002");
        
        System.out.println("\nDespués de eliminar Prof. Carlos Rodríguez:");
        System.out.println("Curso MAT101 tiene profesor: " + 
                         (cursoMat.getProfesor() != null ? cursoMat.getProfesor().getNombre() : "Ninguno"));
        
        // TAREA 8: Mostrar reporte de cantidad de cursos por profesor
        System.out.println("\n8. REPORTE: CANTIDAD DE CURSOS POR PROFESOR");
        System.out.println("=".repeat(60));
        universidad.mostrarReporteCursosPorProfesor();
        
        // Demostración adicional de bidireccionalidad
        System.out.println("\n===== DEMOSTRACIÓN ADICIONAL DE BIDIRECCIONALIDAD =====");
        
        // Crear un nuevo curso y asignarlo directamente desde el profesor
        Curso nuevoCurso = new Curso("CS301", "Algoritmos Avanzados");
        universidad.agregarCurso(nuevoCurso);
        
        System.out.println("\nAsignando curso directamente desde el profesor:");
        prof1.agregarCurso(nuevoCurso);
        
        System.out.println("\nVerificando que la relación se mantiene en ambos lados:");
        System.out.println("Curso CS301 tiene profesor: " + 
                         (nuevoCurso.getProfesor() != null ? nuevoCurso.getProfesor().getNombre() : "Ninguno"));
        prof1.listarCursos();
        
        System.out.println("\n===== FIN DEL EJERCICIO 3 =====");
        System.out.println("La relación bidireccional se mantiene correctamente en ambas direcciones");
    }
}