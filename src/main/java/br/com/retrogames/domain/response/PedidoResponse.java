package br.com.retrogames.domain.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PedidoResponse(Long idPedido,
                             LocalDate dt_pedido,
                             String status_pedido,
                             BigDecimal vlTotal) {}
