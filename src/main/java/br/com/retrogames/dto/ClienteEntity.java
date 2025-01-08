package br.com.retrogames.dto;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Data
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    private String nmCliente;
    private String telefone;
    @Column(name = "data_nasc")
    private LocalDate dataNasc;
    private String email;

}
