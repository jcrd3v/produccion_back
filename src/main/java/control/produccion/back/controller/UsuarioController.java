package control.produccion.back.controller;

import control.produccion.back.model.Usuario;
import control.produccion.back.service.UsuarioServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioServiceInterface usuarioService;

    UsuarioController(UsuarioServiceInterface service){
        this.usuarioService = service;
    }

    @GetMapping
    public List<Usuario> getUsuarios(){
        return usuarioService.buscarUsuarios();
    }

    @GetMapping("/{idUsuario}")
    public Usuario getUsuario(@PathVariable Long idUsuario) {
        return usuarioService.buscarUsuario(idUsuario);
    }

    @PostMapping
    public Usuario postUsuario(@RequestBody Usuario usuario){
        return usuarioService.guardarUsuario(usuario);
    }

    @PutMapping("/{idUsuario}")
    public Usuario putUsuario(@RequestBody Usuario usuario, @PathVariable Long idUsuario) {
        return usuarioService.actualizarUsuario(idUsuario, usuario);
    }

    @DeleteMapping("/{idUsuario}")
    public void deleteUsuario(@PathVariable Long idUsuario){
        usuarioService.eliminarUsuario(idUsuario);
    }

    @PatchMapping("/{idUsuario}")
    public void patchUsuario(@RequestBody Usuario usuario, @PathVariable Long idUsuario){
        usuarioService.actualizarClaveUsuario(idUsuario, usuario);
    }

}
