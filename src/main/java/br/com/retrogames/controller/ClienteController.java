package br.com.retrogames.controller;

import br.com.retrogames.domain.request.ClienteRequest;
import br.com.retrogames.domain.response.ClienteResponse;
import br.com.retrogames.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private static final Logger log = LoggerFactory.getLogger(ClienteController.class);
    @Autowired
    ClienteService clienteService;

    @PostMapping("/novo")
    public ResponseEntity<ClienteResponse> cadastrar(@RequestBody ClienteRequest request) {
        ClienteResponse novoCliente = clienteService.cadastrar(request);
        return ResponseEntity.ok().body(novoCliente);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> buscar(@PathVariable Long id) {
        ClienteResponse novoCliente = clienteService.buscar(id);
        if(novoCliente == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(novoCliente);
    }


}
