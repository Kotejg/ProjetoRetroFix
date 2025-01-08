package br.com.retrogames.controller;

import br.com.retrogames.domain.request.LoginRequest;
import br.com.retrogames.domain.response.UsuarioResponse;
import br.com.retrogames.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/cliente")
    public ResponseEntity<UsuarioResponse> login (@RequestBody LoginRequest loginRequest) {
        UsuarioResponse response = loginService.login(loginRequest);
        if (response == null) {
            return ResponseEntity.status(HttpStatusCode.valueOf(401)).build();
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/adm")
    public ResponseEntity<UsuarioResponse> loginAdm (@RequestBody LoginRequest loginRequest) {
        UsuarioResponse response = loginService.loginAdm(loginRequest);
        if (response == null) {
            return ResponseEntity.status(HttpStatusCode.valueOf(401)).build();
        }
        return ResponseEntity.ok(response);
    }

}
