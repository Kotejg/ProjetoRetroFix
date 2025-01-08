package br.com.retrogames.controller;

import br.com.retrogames.domain.request.PedidoRequest;
import br.com.retrogames.domain.response.PedidoResponse;
import br.com.retrogames.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;


    @PostMapping("/novo")
    public ResponseEntity<PedidoResponse> cadastrarPedido(@RequestBody PedidoRequest pedidoRequest){
        PedidoResponse response = pedidoService.cadastrar(pedidoRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<PedidoResponse>> buscarCliente(@PathVariable Long id){
        List<PedidoResponse> responses = pedidoService.buscarTodosPorCliente(id);
        return ResponseEntity.ok(responses);
    }
}
