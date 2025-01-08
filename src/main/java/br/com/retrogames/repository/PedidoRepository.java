package br.com.retrogames.repository;

import br.com.retrogames.dto.PedidoEntity;
import br.com.retrogames.dto.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

    List<ProdutoEntity> findAllByIdCliente(Long idCliente);
}
