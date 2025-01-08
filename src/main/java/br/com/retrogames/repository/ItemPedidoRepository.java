package br.com.retrogames.repository;

import br.com.retrogames.dto.ItemPedidoEntity;
import br.com.retrogames.dto.pk.ItemPedidoPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedidoEntity, ItemPedidoPK> {
}
