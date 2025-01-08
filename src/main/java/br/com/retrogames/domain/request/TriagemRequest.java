package br.com.retrogames.domain.request;


import lombok.Data;

@Data
public class TriagemRequest {
    private Long idCliente;
    private String nmVideogame;
    private String dsProblema;
    private String tpServico;

}
