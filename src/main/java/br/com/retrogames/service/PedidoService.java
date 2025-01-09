package br.com.retrogames.service;

import br.com.retrogames.domain.request.PedidoRequest;
import br.com.retrogames.domain.response.PedidoResponse;
import br.com.retrogames.dto.PedidoEntity;
import br.com.retrogames.repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemPedidoService itemPedidoService;


    public PedidoResponse cadastrar(PedidoRequest pedidoRequest) {
        PedidoEntity entity = modelMapper.map(pedidoRequest, PedidoEntity.class);
        entity.setDt_pedido(LocalDate.now());
        entity.setStatus_pedido("Preparando");
        PedidoEntity entityResponse = pedidoRepository.save(entity);
        itemPedidoService.cadastroItem(pedidoRequest);
        return new PedidoResponse(entityResponse.getCodPedido(),
                                  entityResponse.getDt_pedido(),
                                  entityResponse.getStatus_pedido(),
                                  entityResponse.getVlTotal());
    }

    public List<PedidoResponse> buscarTodosPorCliente(Long idCliente) {
        List<PedidoEntity> pedidosPorCliente = pedidoRepository.findAllByIdCliente(idCliente);
        if (!pedidosPorCliente.isEmpty()) {
            return pedidosPorCliente.stream().map(pedido -> new PedidoResponse(pedido.getCodPedido(),
                    pedido.getDt_pedido(),
                    pedido.getStatus_pedido(),
                    pedido.getVlTotal())).toList();
        }
        return null;
    }
}
