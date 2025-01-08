package br.com.retrogames.dto.pk;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoPK implements Serializable {
    private Long idPedido;
    private Long idProduto;
}
