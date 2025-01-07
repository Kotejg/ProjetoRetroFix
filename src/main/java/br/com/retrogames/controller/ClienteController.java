package br.com.retrogames.controller;

import br.com.retrogames.domain.request.ClienteRequest;
import br.com.retrogames.domain.response.ClienteResponse;
import br.com.retrogames.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/novo")
    public ResponseEntity<ClienteResponse> cadastrar(@RequestBody ClienteRequest request) {
        ClienteResponse novoCliente = clienteService.cadastrar(request);
        return ResponseEntity.ok().body(novoCliente);
    }

}
