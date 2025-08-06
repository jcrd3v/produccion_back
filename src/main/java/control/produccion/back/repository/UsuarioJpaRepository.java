package control.produccion.back.repository;

import control.produccion.back.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioJpaRepository extends JpaRepository<Usuario, Long> {

    //Usuario findByNombreUsuario(String nombreUsuario);

    Optional<Usuario> findByNombreUsuarioAndClaveUsuario(String nombreUsuario, String claveUsuario);
}
