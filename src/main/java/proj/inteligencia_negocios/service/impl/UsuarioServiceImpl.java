package proj.inteligencia_negocios.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proj.inteligencia_negocios.model.Usuario;
import proj.inteligencia_negocios.repository.UsuarioRepository;
import proj.inteligencia_negocios.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findById(Long idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    @Override
    public Usuario create(Usuario usuario) {
        usuario.setIdUsuario(null);
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> update(Long idUsuario, Usuario usuario) {
        return usuarioRepository.findById(idUsuario).map(existing -> {
            existing.setNombre(usuario.getNombre());
            existing.setCorreo(usuario.getCorreo());
            return usuarioRepository.save(existing);
        });
    }

    @Override
    public void delete(Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }
}


