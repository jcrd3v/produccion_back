package control.produccion.back.service;

import control.produccion.back.model.Usuario;

import java.util.List;

public interface UsuarioServiceInterface {
    Usuario guardarUsuario(Usuario usuario); // crear un usuario (CREATE)
    Usuario buscarUsuario(Long idUsuario); // leer o buscar un usuario (READ)
    Usuario actualizarUsuario(Long idUsuario, Usuario usuario); // actualizar un usuario (UPDATE)
    void eliminarUsuario(Long idUsuario);
    List<Usuario> buscarUsuarios();
    Usuario actualizarClaveUsuario(Long idUsuario, Usuario usuario);
}
