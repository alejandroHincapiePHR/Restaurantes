package com.gammaPedidos.Restaurantes.Restaurantes.repositorios;
import com.gammaPedidos.Restaurantes.Restaurantes.entidades.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RestauranteRepositorio extends JpaRepository<Restaurante, Long> {
}

