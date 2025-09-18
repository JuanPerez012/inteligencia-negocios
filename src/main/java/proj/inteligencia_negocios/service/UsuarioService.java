package proj.inteligencia_negocios.service;

import proj.inteligencia_negocios.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> findAll();
    Optional<Usuario> findById(Long idUsuario);
    Usuario create(Usuario usuario);
    Optional<Usuario> update(Long idUsuario, Usuario usuario);
    void delete(Long idUsuario);
}


