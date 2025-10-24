package ejercicio3;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una universidad y administra profesores y cursos
 * Gestiona las relaciones bidireccionales entre Profesor y Curso
 */
public class Universidad {
    private String nombre;
    private List<Profesor> profesores;
    private List<Curso> cursos;

    /**
     * Constructor de la clase Universidad
     * @param nombre Nombre de la universidad
     */
    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    /**
     * Agrega un profesor a la universidad
     * @param p Profesor a agregar
     */
    public void agregarProfesor(Profesor p) {
        if (p == null) {
            System.out.println("Error: No se puede agregar un profesor nulo");
            return;
        }

        if (profesores.contains(p)) {
            System.out.println("El profesor " + p.getNombre() + " ya está registrado");
            return;
        }

        // Verificar que no exista otro profesor con el mismo ID
        if (buscarProfesorPorId(p.getId()) != null) {
            System.out.println("Error: Ya existe un profesor con ID: " + p.getId());
            return;
        }

        profesores.add(p);
        System.out.println("Profesor agregado exitosamente: " + p.getNombre());
    }

    /**
     * Agrega un curso a la universidad
     * @param c Curso a agregar
     */
    public void agregarCurso(Curso c) {
        if (c == null) {
            System.out.println("Error: No se puede agregar un curso nulo");
            return;
        }

        if (cursos.contains(c)) {
            System.out.println("El curso " + c.getNombre() + " ya está registrado");
            return;
        }

        // Verificar que no exista otro curso con el mismo código
        if (buscarCursoPorCodigo(c.getCodigo()) != null) {
            System.out.println("Error: Ya existe un curso con código: " + c.getCodigo());
            return;
        }

        cursos.add(c);
        System.out.println("Curso agregado exitosamente: " + c.getNombre());
    }

    /**
     * Asigna un profesor a un curso usando sus identificadores
     * @param codigoCurso Código del curso
     * @param idProfesor ID del profesor
     */
    public void asignarProfesorACurso(String codigoCurso, String idProfesor) {
        Curso curso = buscarCursoPorCodigo(codigoCurso);
        Profesor profesor = buscarProfesorPorId(idProfesor);

        if (curso == null) {
            System.out.println("Error: No se encontró curso con código: " + codigoCurso);
            return;
        }

        if (profesor == null) {
            System.out.println("Error: No se encontró profesor con ID: " + idProfesor);
            return;
        }

        // Usar el método setProfesor del curso para mantener bidireccionalidad
        curso.setProfesor(profesor);
        System.out.println("Profesor " + profesor.getNombre() + " asignado al curso " + curso.getNombre());
    }

    /**
     * Lista todos los profesores de la universidad
     */
    public void listarProfesores() {
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados en " + nombre);
            return;
        }

        System.out.println("\n===== PROFESORES DE " + nombre.toUpperCase() + " =====");
        for (Profesor profesor : profesores) {
            profesor.mostrarInfo();
        }
    }

    /**
     * Lista todos los cursos de la universidad
     */
    public void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos registrados en " + nombre);
            return;
        }

        System.out.println("\n===== CURSOS DE " + nombre.toUpperCase() + " =====");
        for (Curso curso : cursos) {
            curso.mostrarInfo();
        }
    }

    /**
     * Busca un profesor por su ID
     * @param id ID del profesor
     * @return Profesor encontrado o null si no existe
     */
    public Profesor buscarProfesorPorId(String id) {
        for (Profesor profesor : profesores) {
            if (profesor.getId().equals(id)) {
                return profesor;
            }
        }
        return null;
    }

    /**
     * Busca un curso por su código
     * @param codigo Código del curso
     * @return Curso encontrado o null si no existe
     */
    public Curso buscarCursoPorCodigo(String codigo) {
        for (Curso curso : cursos) {
            if (curso.getCodigo().equals(codigo)) {
                return curso;
            }
        }
        return null;
    }

    /**
     * Elimina un curso de la universidad rompiendo la relación con su profesor
     * @param codigo Código del curso a eliminar
     * @return true si se eliminó exitosamente, false si no se encontró
     */
    public boolean eliminarCurso(String codigo) {
        Curso curso = buscarCursoPorCodigo(codigo);
        if (curso != null) {
            // Romper la relación con el profesor si la hubiera
            if (curso.getProfesor() != null) {
                curso.getProfesor().eliminarCurso(curso);
            }
            
            cursos.remove(curso);
            System.out.println("Curso eliminado exitosamente: " + curso.getNombre());
            return true;
        } else {
            System.out.println("No se encontró el curso con código: " + codigo);
            return false;
        }
    }

    /**
     * Elimina un profesor de la universidad dejando en null los cursos que dictaba
     * @param id ID del profesor a eliminar
     * @return true si se eliminó exitosamente, false si no se encontró
     */
    public boolean eliminarProfesor(String id) {
        Profesor profesor = buscarProfesorPorId(id);
        if (profesor != null) {
            // Antes de remover, dejar null los cursos que dictaba
            List<Curso> cursosDelProfesor = new ArrayList<>(profesor.getCursos());
            for (Curso curso : cursosDelProfesor) {
                curso.setProfesor(null);
            }
            
            profesores.remove(profesor);
            System.out.println("Profesor eliminado exitosamente: " + profesor.getNombre());
            System.out.println("Los cursos que dictaba ahora no tienen profesor asignado");
            return true;
        } else {
            System.out.println("No se encontró el profesor con ID: " + id);
            return false;
        }
    }

    /**
     * Genera un reporte de cantidad de cursos por profesor
     */
    public void mostrarReporteCursosPorProfesor() {
        System.out.println("\n===== REPORTE: CURSOS POR PROFESOR =====");
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados");
            return;
        }

        for (Profesor profesor : profesores) {
            int cantidadCursos = profesor.getCursos().size();
            System.out.println(profesor.getNombre() + " (" + profesor.getEspecialidad() + "): " + 
                             cantidadCursos + " curso" + (cantidadCursos != 1 ? "s" : ""));
        }

        // Estadísticas adicionales
        int totalCursos = 0;
        for (Profesor profesor : profesores) {
            totalCursos += profesor.getCursos().size();
        }
        double promedio = profesores.size() > 0 ? (double) totalCursos / profesores.size() : 0;
        System.out.println("\nTotal de asignaciones: " + totalCursos);
        System.out.println("Promedio de cursos por profesor: " + String.format("%.2f", promedio));
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Profesor> getProfesores() {
        return new ArrayList<>(profesores);
    }

    public List<Curso> getCursos() {
        return new ArrayList<>(cursos);
    }

    @Override
    public String toString() {
        return "Universidad{" +
                "nombre='" + nombre + '\'' +
                ", cantidadProfesores=" + profesores.size() +
                ", cantidadCursos=" + cursos.size() +
                '}';
    }
}