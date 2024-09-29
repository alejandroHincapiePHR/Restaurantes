package com.gammaPedidos.Restaurantes.Restaurantes.repositorios;
import com.gammaPedidos.Restaurantes.Restaurantes.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {
    List<Pedido> findByClienteId(Long clienteId);
}
