package br.com.retrogames.domain.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemPedidoRequest {

    private Long idPedido;
    private Long idProduto;
    private Long qtdProduto;
}
