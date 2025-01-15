package br.com.retrogames.repository;


import br.com.retrogames.dto.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    @Query(value = "select * from usuario where username = ?1  and senha = ?2 ", nativeQuery = true)
    Optional<UsuarioEntity> login(String username, String pass );

    @Query(value = "select * from usuario where username = ?1  and senha = ?2 and fl_adm = 1 ", nativeQuery = true)
    Optional<UsuarioEntity> loginAdm(String username, String pass );
}
