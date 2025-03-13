package proyectos.gestionproyectos.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// @Entity marca esta clase como una entidad JPA, lo que significa que se mapeará a una tabla en la base de datos
@Entity
// @Table especifica el nombre de la tabla en la base de datos
@Table(name = "proyectos")
public class Proyecto {

    // @Id marca este campo como la clave primaria de la tabla
    @Id
    // @GeneratedValue indica que el ID se generará automáticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Este es el identificador de la entidad

    private String nombre;

    private String descripcion;

    // @Column permite personalizar la columna en la base de datos
    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    // @Enumerated especifica cómo se debe almacenar el enum en la base de datos
    @Enumerated(EnumType.STRING)
    private EstadoProyecto estado;

    // @OneToMany establece una relación uno a muchos con Tarea
    // mappedBy indica que la relación es bidireccional y está mapeada por el campo
    // "proyecto" en Tarea
    // cascade especifica que las operaciones deben cascada a las tareas
    // relacionadas
    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tarea> tareas = new ArrayList<>();

    // Constructor por defecto requerido por JPA
    public Proyecto() {
    }

    // Getters y setters - necesarios para que Spring pueda acceder a los campos
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public EstadoProyecto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProyecto estado) {
        this.estado = estado;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }
}
