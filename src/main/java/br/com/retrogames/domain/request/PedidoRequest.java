package br.com.retrogames.domain.request;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PedidoRequest {
    private Long idCliente;
    private BigDecimal vlTotal;
}
