package br.com.retrogames.domain.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class PedidoRequest {
    private Long idCliente;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal vlTotal;
    private String formaPagto;
    private List<ItemPedidoRequest> items;
}
