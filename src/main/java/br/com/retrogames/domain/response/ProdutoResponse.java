package br.com.retrogames.domain.response;

import java.math.BigDecimal;

public record ProdutoResponse(String descricao,
                             BigDecimal vlProduto,
                             boolean flDisponivel,
                             Long qtdEstoque,
                             String urlImg) {}
