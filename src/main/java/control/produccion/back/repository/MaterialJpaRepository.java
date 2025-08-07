package control.produccion.back.repository;

import control.produccion.back.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialJpaRepository extends JpaRepository<Material, Long> {
}
