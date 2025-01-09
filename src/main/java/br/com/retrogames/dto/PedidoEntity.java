package br.com.retrogames.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long codPedido;
    private Long idCliente;
    private LocalDate dt_pedido;
    private String status_pedido;
    private BigDecimal vlTotal;

    @JsonIgnore
    @OneToMany(mappedBy = "pedidoEntity")
    private List<ItemPedidoEntity> itemPedido;
}

