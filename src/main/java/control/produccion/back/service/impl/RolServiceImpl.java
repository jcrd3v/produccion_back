package control.produccion.back.service.impl;

import control.produccion.back.model.Rol;
import control.produccion.back.repository.RolJpaRepository;
import control.produccion.back.service.RolServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolServiceInterface {

    private RolJpaRepository rolRepository;

    RolServiceImpl(RolJpaRepository rolJpaRepository){
        this.rolRepository = rolJpaRepository;
    }

    @Override
    public Rol guardarRol(Rol rol){
        return rolRepository.save(rol);
    }

    @Override
    public Rol buscarRol(Long idRol) {
        return rolRepository.findById(idRol).orElse(null);
    }

    @Override
    public Rol actualizarRol(Long idRol, Rol rol) {
        Rol rolExistente = rolRepository.findById(idRol).orElse(null); // aquí se está buscando el rol que tiene el id que se pasó como parámetro y se guarda en la variable rolExistente
        rolExistente.setNombreRol(rol.getNombreRol());
        return rolRepository.save(rolExistente);
    }

    @Override
    public void eliminarRol(Long idRol) {
        Rol rolExistente = rolRepository.findById(idRol).orElse(null);
        rolRepository.delete(rolExistente);
    }

    @Override
    public List<Rol> buscarRoles() {
        return rolRepository.findAll();
    }
}
