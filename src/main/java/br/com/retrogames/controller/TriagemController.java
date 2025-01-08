package br.com.retrogames.controller;

import br.com.retrogames.domain.request.TriagemRequest;
import br.com.retrogames.domain.response.TriagemResponse;
import br.com.retrogames.service.TriagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/triagem")
public class TriagemController {

    @Autowired
    private TriagemService triagemService;

    @PostMapping("/novo")
    public ResponseEntity<TriagemResponse> cadastarTriagem(@RequestBody TriagemRequest triagemRequest){
        TriagemResponse response = triagemService.cadastrar(triagemRequest);
        return ResponseEntity.ok().body(response);

    }

    @GetMapping("{id}")
    public ResponseEntity<TriagemResponse> buscarTriagem(@PathVariable Long id){
        TriagemResponse response = triagemService.buscar(id);
        if(response == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(response);
    }



}
