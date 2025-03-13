package proyectos.gestionproyectos.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import proyectos.gestionproyectos.model.Usuario;
import proyectos.gestionproyectos.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    String string = "hola";

    private final UsuarioRepository usuarioRepository;

    public CustomUserDetailsService(@Lazy UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles(usuario.getRole())
                .build();
    }
}
