package com.gammaPedidos.Restaurantes.Restaurantes.entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;

    // Relación muchos a muchos con Plato a través de Pedido_Plato
    @ManyToMany
    @JoinTable(
            name = "Pedido_Plato",
            joinColumns = @JoinColumn(name = "id_pedido"),
            inverseJoinColumns = @JoinColumn(name = "id_plato")
    )
    private List<Plato> platos;

    public enum EstadoPedido {
        CREADO,
        PAGADO,
        ACEPTADO,
        PREPARACION,
        ENVIADO,
        RECIBIDO
    }
}

