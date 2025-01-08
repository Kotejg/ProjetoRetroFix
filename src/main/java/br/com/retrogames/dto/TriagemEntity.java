package br.com.retrogames.dto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orcamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TriagemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrcamento;
    private Long idCliente;
    private String nmVideogame;
    private String dsProblema;
    private String tpServico;

}
