package control.produccion.back.repository;

import control.produccion.back.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoJpaRepository extends JpaRepository<Producto, Long> {
}