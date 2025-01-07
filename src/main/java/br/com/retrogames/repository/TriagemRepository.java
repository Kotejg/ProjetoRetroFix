package br.com.retrogames.repository;

import br.com.retrogames.dto.TriagemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TriagemRepository extends JpaRepository<TriagemEntity, Long> {
}
