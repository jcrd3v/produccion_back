package control.produccion.back.controller;

import control.produccion.back.model.Usuario;
import control.produccion.back.repository.UsuarioJpaRepository;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UsuarioJpaRepository usuarioRepository;

    AuthController(UsuarioJpaRepository repository) {
        this.usuarioRepository = repository;
    }

    @PostMapping("/autenticacion")
    public ResponseEntity<?> iniciarSesion(@RequestBody Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByNombreUsuarioAndClaveUsuario(usuario.getNombreUsuario(), usuario.getClaveUsuario());
        if (usuarioExistente.isPresent()) {
            return ResponseEntity.ok("Credenciales correctas");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }
}
