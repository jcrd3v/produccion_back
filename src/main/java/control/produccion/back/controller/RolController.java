package control.produccion.back.controller;

import control.produccion.back.model.Rol;
import control.produccion.back.service.RolServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {

    private final RolServiceInterface rolService;

    public RolController(RolServiceInterface service){
        this.rolService = service;
    }

    @GetMapping
    public List<Rol> getRoles() {
        return rolService.buscarRoles();
    }

    @GetMapping("/{idRol}")
    public Rol getRol(@PathVariable Long idRol) {
        return rolService.buscarRol(idRol);
    }

    @PostMapping
    public Rol postRol(@RequestBody Rol rol){
        return rolService.guardarRol(rol);
    }

    @PutMapping("/{idRol}")
    public Rol putRol(@RequestBody Rol rol, @PathVariable Long idRol) {
        return rolService.actualizarRol(idRol, rol);
    }

    @DeleteMapping("/{idRol}")
    public void eliminarRol(@PathVariable Long idRol) { // cambiar por deleteRol
        rolService.eliminarRol(idRol);
    }
}
