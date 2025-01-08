package br.com.retrogames.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PedidoEntity {
    @Id
    private Long idPedido;
    private Long idCliente;
    private Date dt_pedido;
    private String status_pedido;
    private BigDecimal vlTotal;
}

