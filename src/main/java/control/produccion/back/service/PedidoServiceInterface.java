package control.produccion.back.service;

import control.produccion.back.model.Pedido;

import java.util.List;

public interface PedidoServiceInterface {
    List<Pedido> buscarPedidos(); // listar pedidos
    Pedido guardarPedido(Pedido pedido); // crear pedido
    Pedido actualizarEstadoPedido(Long idPedido, String estado); // actualizar estado
}