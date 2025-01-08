package br.com.retrogames.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ProdutoEntity {
    @Id
    private Long idProduto;
    private String descricao;
    private BigDecimal vlProduto;
    private boolean flDisponivel;
    private Long qtdEstoque;

}
