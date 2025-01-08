package br.com.retrogames.domain.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoRequest {

    private String descricao;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal vlProduto;
    private String urlImg;
}
