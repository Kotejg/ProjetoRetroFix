package br.com.retrogames.dto;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;
    private String descricao;
    private String urlImg;
    private BigDecimal vlProduto;
    private boolean flDisponivel;
    private Long qtdEstoque;

}
