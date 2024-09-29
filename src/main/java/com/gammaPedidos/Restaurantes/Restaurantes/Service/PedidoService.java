package com.gammaPedidos.Restaurantes.Restaurantes.Service;
import com.gammaPedidos.Restaurantes.Restaurantes.entidades.Pedido;
import com.gammaPedidos.Restaurantes.Restaurantes.repositorios.ClienteRepositorio;
import com.gammaPedidos.Restaurantes.Restaurantes.repositorios.PedidoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepositorio pedidoRepository;

    // Obtener todos los pedidos
    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidoRepository.findAll();
    }

    // Obtener pedido por ID
    public Optional<Pedido> obtenerPedidoPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    // Crear un nuevo pedido
    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // Actualizar un pedido existente
    public Pedido actualizarPedido(Long id, Pedido pedidoActualizado) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow();
        pedido.setPlatos(pedidoActualizado.getPlatos());
        pedido.setEstado(pedidoActualizado.getEstado());
        return pedidoRepository.save(pedido);
    }

    // Eliminar un pedido
    public boolean eliminarPedido(Long id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Obtener todos los pedidos de un cliente
    public List<Pedido> obtenerPedidosPorCliente(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }

    // Actualizar el estado de un pedido
    public Pedido actualizarEstadoPedido(Long id, Pedido.EstadoPedido estado) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow();
        pedido.setEstado(estado);
        return pedidoRepository.save(pedido);
    }
}

