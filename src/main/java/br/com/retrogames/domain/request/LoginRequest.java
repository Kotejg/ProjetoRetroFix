package br.com.retrogames.domain.request;

import br.com.retrogames.domain.response.UsuarioResponse;
import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;

}
