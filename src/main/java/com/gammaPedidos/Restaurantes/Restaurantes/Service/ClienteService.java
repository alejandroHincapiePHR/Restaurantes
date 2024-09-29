package com.gammaPedidos.Restaurantes.Restaurantes.Service;

import com.gammaPedidos.Restaurantes.Restaurantes.entidades.Cliente;
import com.gammaPedidos.Restaurantes.Restaurantes.entidades.Pedido;
import com.gammaPedidos.Restaurantes.Restaurantes.repositorios.ClienteRepositorio;
import com.gammaPedidos.Restaurantes.Restaurantes.repositorios.PedidoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepositorio clienteRepository;
    private final PedidoRepositorio pedidoRepository;

    // Obtener todos los clientes
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    // Obtener cliente por ID
    public Optional<Cliente> obtenerClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    // Crear un nuevo cliente
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Actualizar un cliente existente
    public Cliente actualizarCliente(Long id, Cliente clienteActualizado) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        cliente.setNombre(clienteActualizado.getNombre());
        cliente.setEmail(clienteActualizado.getEmail());
        cliente.setUbicacion(clienteActualizado.getUbicacion());
        return clienteRepository.save(cliente);
    }

    // Eliminar un cliente
    public boolean eliminarCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Obtener todos los pedidos de un cliente específico
    public List<Pedido> obtenerPedidosPorCliente(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }
}