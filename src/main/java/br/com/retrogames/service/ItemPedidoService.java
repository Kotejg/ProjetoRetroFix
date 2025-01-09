package br.com.retrogames.service;

import br.com.retrogames.domain.request.PedidoRequest;
import br.com.retrogames.domain.response.ItemPedidoResponse;
import br.com.retrogames.dto.ItemPedidoEntity;
import br.com.retrogames.repository.ItemPedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ItemPedidoResponse> cadastroItem(PedidoRequest pedidoRequest) {
        List<ItemPedidoEntity> listaEntities =
                pedidoRequest.getItems().stream()
                        .map(item -> modelMapper.map(item, ItemPedidoEntity.class))
                        .toList();
        itemPedidoRepository.saveAll(listaEntities);
        return listaEntities.stream()
                .map(resp -> modelMapper.map(resp, ItemPedidoResponse.class))
                .toList();
    }
}
