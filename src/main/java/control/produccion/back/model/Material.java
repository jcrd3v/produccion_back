package control.produccion.back.model;

import control.produccion.back.enums.Ubicacion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "materiales", schema = "produccion")
@Getter @Setter
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_material")
    private Long idMaterial;

    @Column(name = "nombre_material", nullable = false)
    private String nombreMaterial;

    @Column(name = "unidad_medida_material", nullable = false)
    private String unidadMedidaMaterial;

    @Column(name = "stock_material", nullable = false)
    private Double stockMaterial;

    @Enumerated(EnumType.STRING)
    @Column(name = "ubicacion_material", nullable = false)
    private Ubicacion ubicacionMaterial;
}
