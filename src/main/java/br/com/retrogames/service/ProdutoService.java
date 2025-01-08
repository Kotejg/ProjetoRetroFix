package br.com.retrogames.service;

import br.com.retrogames.domain.request.ProdutoRequest;
import br.com.retrogames.domain.response.ProdutoResponse;
import br.com.retrogames.dto.ProdutoEntity;
import br.com.retrogames.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    ModelMapper modelMapper;

    public ProdutoResponse cadastrar(ProdutoRequest produtoRequest) {
        var entityResponse =  produtoRepository.save(modelMapper.map(produtoRequest, ProdutoEntity.class));
        return new ProdutoResponse(entityResponse.getDescricao(),
                                    entityResponse.getVlProduto(),
                                    entityResponse.isFlDisponivel(),
                                    entityResponse.getQtdEstoque()==null  ? 0 : entityResponse.getQtdEstoque() ,
                                    entityResponse.getUrlImg());
    }

    public ProdutoResponse buscarPorId(Long id) {
        Optional<ProdutoEntity> entityResponse = produtoRepository.findById(id);
//        if(entityResponse.isPresent()) {
//            return modelMapper.map(entityResponse, ProdutoResponse.class);
//        }
//        return null;
        return entityResponse.map(entity -> new ProdutoResponse(entity.getDescricao(),
                entity.getVlProduto(),
                entity.isFlDisponivel(),
                entity.getQtdEstoque()==null  ? 0 : entity.getQtdEstoque() ,
                entity.getUrlImg())).orElse(null);
    }

    public List<ProdutoResponse> buscarTodos() {
        List<ProdutoEntity> listaProdutos = produtoRepository.findAll();
        if (listaProdutos.isEmpty()) {
            return null;
        }
        return listaProdutos.stream()
                .map(entity ->  new ProdutoResponse(entity.getDescricao(),
                        entity.getVlProduto(),
                        entity.isFlDisponivel(),
                        entity.getQtdEstoque()==null  ? 0 : entity.getQtdEstoque(),
                        entity.getUrlImg()))
                .collect(Collectors.toList());
    }

}
