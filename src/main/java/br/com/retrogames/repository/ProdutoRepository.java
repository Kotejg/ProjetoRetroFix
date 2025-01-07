package br.com.retrogames.repository;

import br.com.retrogames.dto.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<PedidoEntity, Long> {
}
