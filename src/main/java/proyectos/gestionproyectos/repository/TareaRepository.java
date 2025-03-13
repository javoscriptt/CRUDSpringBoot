package proyectos.gestionproyectos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import proyectos.gestionproyectos.model.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
