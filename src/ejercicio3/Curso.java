package ejercicio3;

/**
 * Clase que representa un curso en el sistema universitário
 * Implementa relación bidireccional N a 1 con Profesor
 */
public class Curso {
    private String codigo;
    private String nombre;
    private Profesor profesor;

    /**
     * Constructor de la clase Curso
     * @param codigo Código único del curso
     * @param nombre Nombre del curso
     */
    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = null;
    }

    /**
     * Constructor de la clase Curso con profesor
     * @param codigo Código único del curso
     * @param nombre Nombre del curso
     * @param profesor Profesor responsable del curso
     */
    public Curso(String codigo, String nombre, Profesor profesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        setProfesor(profesor); // Usar el setter para mantener bidireccionalidad
    }

    /**
     * Asigna o cambia el profesor del curso manteniendo la bidireccionalidad
     * @param p Nuevo profesor responsable
     */
    public void setProfesor(Profesor p) {
        // Si ya tenía un profesor previo, quitarse de su lista
        if (this.profesor != null && this.profesor != p) {
            this.profesor.eliminarCurso(this);
        }

        // Asignar el nuevo profesor
        this.profesor = p;

        // Si el nuevo profesor no es null, agregarse a su lista
        if (p != null && !p.getCursos().contains(this)) {
            p.agregarCurso(this);
        }
    }

    /**
     * Método interno para asignar profesor sin sincronización (evita recursión)
     * @param p Profesor a asignar
     */
    protected void setProfesorInterno(Profesor p) {
        this.profesor = p;
    }

    /**
     * Muestra la información del curso
     */
    public void mostrarInfo() {
        System.out.println("================================");
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        if (profesor != null) {
            System.out.println("Profesor: " + profesor.getNombre() + " (" + profesor.getEspecialidad() + ")");
        } else {
            System.out.println("Profesor: Sin asignar");
        }
        System.out.println("================================");
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", profesor=" + (profesor != null ? profesor.getNombre() : "Sin asignar") +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Curso curso = (Curso) obj;
        return codigo.equals(curso.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}