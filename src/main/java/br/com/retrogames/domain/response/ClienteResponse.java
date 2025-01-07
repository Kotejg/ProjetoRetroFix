package br.com.retrogames.domain.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteResponse {
    private String nome;
}
