package control.produccion.back.service.impl;

import control.produccion.back.enums.EstadoPedido;
import control.produccion.back.model.Pedido;
import control.produccion.back.repository.PedidoJpaRepository;
import control.produccion.back.service.PedidoServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoServiceInterface {

    private PedidoJpaRepository pedidoRepository;

    PedidoServiceImpl(PedidoJpaRepository repository) {
        this.pedidoRepository = repository;
    }

    @Override
    public List<Pedido> buscarPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido guardarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido actualizarEstadoPedido(Long idPedido, String estado) {
        Pedido pedidoExistente = pedidoRepository.findById(idPedido).orElse(null);
        if (pedidoExistente != null) {
            pedidoExistente.setEstadoPedido(EstadoPedido.valueOf(estado.toUpperCase()));
            return pedidoRepository.save(pedidoExistente);
        }
        return null;
    }
}