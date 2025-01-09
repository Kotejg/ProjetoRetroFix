package br.com.retrogames.dto;


import br.com.retrogames.dto.pk.ItemPedidoPK;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "item_pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ItemPedidoEntity {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ItemPedidoPK id;
    private Long qtdProduto;

    @ManyToOne(fetch=FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinColumn(name = "idPedido", insertable = false, updatable = false)
    private PedidoEntity pedidoEntity;

}
