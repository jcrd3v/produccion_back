package control.produccion.back.service;

import control.produccion.back.model.Rol;

import java.util.List;

public interface RolServiceInterface {
    Rol guardarRol(Rol rol); // crear un Rol (CREATE)
    Rol buscarRol(Long idRol); // mostrar un rol por id (READ)
    Rol actualizarRol(Long idRol, Rol rol); // actualizar un Rol (UPDATE)
    void eliminarRol(Long idRol);
    List<Rol> buscarRoles(); // mostrar todos los Roles (READ (ALL))


}
