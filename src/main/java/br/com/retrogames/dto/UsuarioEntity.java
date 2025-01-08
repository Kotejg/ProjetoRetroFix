package br.com.retrogames.dto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UsuarioEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String username;
    @Column(name = "senha")
    private String password;
    private boolean flAdm;
    private Long idCliente;


}
