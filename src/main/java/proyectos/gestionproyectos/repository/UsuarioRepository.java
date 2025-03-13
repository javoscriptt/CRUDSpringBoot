package proyectos.gestionproyectos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import proyectos.gestionproyectos.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
