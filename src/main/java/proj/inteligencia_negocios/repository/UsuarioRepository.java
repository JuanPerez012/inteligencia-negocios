package proj.inteligencia_negocios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.inteligencia_negocios.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreo(String correo);
}


