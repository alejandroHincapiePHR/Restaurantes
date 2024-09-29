package com.gammaPedidos.Restaurantes.Restaurantes.repositorios;
import com.gammaPedidos.Restaurantes.Restaurantes.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
}