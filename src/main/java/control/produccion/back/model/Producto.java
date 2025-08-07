package control.produccion.back.model;

import control.produccion.back.enums.Ubicacion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "productos", schema = "produccion")
@Getter @Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_producto")
    private Long idProducto;

    @Column(name = "nombre_producto", nullable = false)
    private String nombreProducto;

    @Column(name = "unidad_medida_producto", nullable = false)
    private String unidadMedidaProducto;

    @Column(name = "stock_producto", nullable = false)
    private Double stockProducto;

    @Enumerated(EnumType.STRING)
    @Column(name = "ubicacion_producto", nullable = false)
    private Ubicacion ubicacionProducto;
}
