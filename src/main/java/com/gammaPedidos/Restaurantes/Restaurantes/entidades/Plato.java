package com.gammaPedidos.Restaurantes.Restaurantes.entidades;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plato")
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlato;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idRestaurante", nullable = false)
    @JsonIgnore
    private Restaurante restaurante;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private Double precio;
}
