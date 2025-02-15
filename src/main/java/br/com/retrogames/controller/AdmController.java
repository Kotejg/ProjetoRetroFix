package br.com.retrogames.controller;

import br.com.retrogames.domain.request.LoginRequest;
import br.com.retrogames.domain.response.UsuarioResponse;
import br.com.retrogames.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adm")
public class AdmController {

    @Autowired
    LoginService loginService;

    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastroAdm(@RequestBody LoginRequest loginRequest){
        UsuarioResponse response = loginService.cadastroAdm(loginRequest);
        return ResponseEntity.ok(response);
    }
}
