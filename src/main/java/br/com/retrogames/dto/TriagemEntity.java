package br.com.retrogames.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Long idOrcamento;
    private Long idCliente;
    private String nmVideoGame;
    private String dsProblema;
    private String tpServico;

}
