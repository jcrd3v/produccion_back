package control.produccion.back.model;

import control.produccion.back.enums.EstadoPedido;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pedidos", schema = "produccion")
@Getter @Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long idPedido;

    @Column(name = "nombre_pedido", nullable = false)
    private String nombrePedido;

    @Column(name = "descripcion_pedido", nullable = false)
    private String descripcionPedido;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_pedido", nullable = false)
    private EstadoPedido estadoPedido = EstadoPedido.PENDIENTE;
}