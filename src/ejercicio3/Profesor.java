package ejercicio3;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un profesor en el sistema universitário
 * Implementa relación bidireccional 1 a N con Curso
 */
public class Profesor {
    private String id;
    private String nombre;
    private String especialidad;
    private List<Curso> cursos;

    /**
     * Constructor de la clase Profesor
     * @param id Identificador único del profesor
     * @param nombre Nombre completo del profesor
     * @param especialidad Área principal de especialización
     */
    public Profesor(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cursos = new ArrayList<>();
    }

    /**
     * Agrega un curso a la lista del profesor manteniendo la bidireccionalidad
     * @param c Curso a agregar
     */
    public void agregarCurso(Curso c) {
        if (c == null) {
            System.out.println("Error: No se puede agregar un curso nulo");
            return;
        }

        // Si el curso ya está en la lista, no lo agregamos
        if (cursos.contains(c)) {
            System.out.println("El curso " + c.getNombre() + " ya está asignado al profesor " + nombre);
            return;
        }

        // Agregar el curso a la lista del profesor
        cursos.add(c);
        
        // Sincronizar el lado del curso: si el curso no tiene este profesor, asignarlo
        if (c.getProfesor() != this) {
            c.setProfesor(this);
        }
        
        System.out.println("Curso " + c.getNombre() + " agregado al profesor " + nombre);
    }

    /**
     * Elimina un curso de la lista del profesor y sincroniza la relación
     * @param c Curso a eliminar
     */
    public void eliminarCurso(Curso c) {
        if (c == null) {
            return;
        }

        if (cursos.remove(c)) {
            // Sincronizar el lado del curso: quitar la referencia al profesor
            if (c.getProfesor() == this) {
                c.setProfesorInterno(null); // Método interno para evitar recursión
            }
            System.out.println("Curso " + c.getNombre() + " eliminado del profesor " + nombre);
        }
    }

    /**
     * Lista todos los cursos que dicta el profesor
     */
    public void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("El profesor " + nombre + " no dicta ningún curso");
            return;
        }

        System.out.println("Cursos dictados por " + nombre + ":");
        for (Curso curso : cursos) {
            System.out.println("• " + curso.getCodigo() + " - " + curso.getNombre());
        }
    }

    /**
     * Muestra la información completa del profesor
     */
    public void mostrarInfo() {
        System.out.println("================================");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Cantidad de cursos: " + cursos.size());
        if (!cursos.isEmpty()) {
            System.out.println("Cursos:");
            for (Curso curso : cursos) {
                System.out.println("  • " + curso.getCodigo() + " - " + curso.getNombre());
            }
        }
        System.out.println("================================");
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Curso> getCursos() {
        return new ArrayList<>(cursos); // Retorna una copia para proteger la integridad
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", cantidadCursos=" + cursos.size() +
                '}';
    }
}