package control.produccion.back.service.impl;

import control.produccion.back.model.Usuario;
import control.produccion.back.repository.UsuarioJpaRepository;
import control.produccion.back.service.UsuarioServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioServiceInterface {

    private UsuarioJpaRepository usuarioRepository;

    UsuarioServiceImpl(UsuarioJpaRepository repository){
        this.usuarioRepository = repository;
    }


    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarUsuario(Long idUsuario) {
        return usuarioRepository.findById(idUsuario).orElse(null);
    }

    @Override
    public Usuario actualizarUsuario(Long idUsuario, Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(idUsuario).orElse(null);
        usuarioExistente.setNombreUsuario(usuario.getNombreUsuario());
        usuarioExistente.setClaveUsuario(usuario.getClaveUsuario());
        usuarioExistente.setRol(usuario.getRol());
        return usuarioRepository.save(usuarioExistente);
    }

    @Override
    public void eliminarUsuario(Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

    @Override
    public List<Usuario> buscarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario actualizarClaveUsuario(Long idUsuario, Usuario usuario){
        Usuario usuarioExistente = usuarioRepository.findById(idUsuario).orElse(null);
        usuarioExistente.setClaveUsuario(usuario.getClaveUsuario());
        return usuarioRepository.save(usuarioExistente);
    }
}
