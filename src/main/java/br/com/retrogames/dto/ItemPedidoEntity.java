package br.com.retrogames.dto;


import br.com.retrogames.dto.pk.ItemPedidoPK;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "item_pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ItemPedidoEntity {

    @Id
    private ItemPedidoPK id;
    private Long qtdProduto;

}
