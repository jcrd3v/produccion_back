package control.produccion.back.repository;

import control.produccion.back.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoJpaRepository extends JpaRepository<Pedido, Long> {
}