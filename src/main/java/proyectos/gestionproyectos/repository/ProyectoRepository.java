package proyectos.gestionproyectos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyectos.gestionproyectos.model.Proyecto;

// Esta interfaz extiende JpaRepository, que proporciona métodos CRUD básicos
// JpaRepository<Proyecto, Long> indica que:
// - Proyecto es la entidad que manejará este repositorio
// - Long es el tipo de dato del ID de la entidad
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    // jpaRepository ya
    // - save(Proyecto proyecto) - para guardar o actualizar
    // - findById(Long id) - para buscar por ID
    // - findAll() - para obtener todos los proyectos
    // - deleteById(Long id) - para eliminar por ID
    // y muchos más...
}
