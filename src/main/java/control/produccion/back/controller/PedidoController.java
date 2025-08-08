package control.produccion.back.controller;

import control.produccion.back.model.Pedido;
import control.produccion.back.service.PedidoServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "http://localhost:4200")
public class PedidoController {

    private PedidoServiceInterface pedidoService;

    PedidoController(PedidoServiceInterface service) {
        this.pedidoService = service;
    }

    @GetMapping
    public List<Pedido> getPedidos() {
        return pedidoService.buscarPedidos();
    }

    @PostMapping
    public ResponseEntity<?> postPedido(@RequestBody Pedido pedido) {
        Pedido nuevoPedido = pedidoService.guardarPedido(pedido);
        return ResponseWrapper.exito(nuevoPedido, "Pedido creado exitosamente").toResponseEntity();
    }

    @PatchMapping("/{idPedido}/estado")
    public ResponseEntity<?> actualizarEstadoPedido(@PathVariable Long idPedido, @RequestBody Map<String, String> request) {
        System.out.println("Recibido PATCH para pedido: " + idPedido);
        System.out.println("Estado recibido: " + request.get("estado"));

        String estado = request.get("estado");
        Pedido pedidoActualizado = pedidoService.actualizarEstadoPedido(idPedido, estado);
        if (pedidoActualizado != null) {
            System.out.println("Pedido actualizado correctamente: " + pedidoActualizado.getEstadoPedido());
            return ResponseWrapper.exito(pedidoActualizado, "Estado actualizado").toResponseEntity();
        }
        System.out.println("Error: Pedido no encontrado");
        return ResponseWrapper.error("Pedido no encontrado", 404).toResponseEntity();
    }
}