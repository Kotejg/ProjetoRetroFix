package br.com.retrogames.domain.request;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@Data
public class ClienteRequest {
    private String nmCliente;
    private String telefone;
    private LocalDate dataNasc;
    private String email;
}
