package br.com.retrogames.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "triagem")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TriagemEntity {
    @Id
    private int idPedido;
}
