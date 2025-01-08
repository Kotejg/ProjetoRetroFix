package br.com.retrogames.controller;

import br.com.retrogames.domain.request.ProdutoRequest;
import br.com.retrogames.domain.response.ProdutoResponse;
import br.com.retrogames.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping("novo")
    public ResponseEntity<ProdutoResponse> cadastroProduto(@RequestBody ProdutoRequest produtoRequest) {
        ProdutoResponse response = produtoService.cadastrar(produtoRequest);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProdutoResponse> buscarProdutoPorId(@PathVariable Long id) {
        ProdutoResponse response = produtoService.buscarPorId(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("listartodos")
    public ResponseEntity<List<ProdutoResponse>> listarTodosProduto() {
        List<ProdutoResponse> todosProdutos = produtoService.buscarTodos();
        if (todosProdutos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(todosProdutos);
    }

}
