package br.com.retrogames.service;

import br.com.retrogames.repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ModelMapper modelMapper;

//    public List<ProdutoResponse> buscarTodosPorCliente(Long idCliente) {
//        List<ProdutoEntity> pedidosPorCliente = pedidoRepository.findAllByIdCliente(idCliente);
//        if (!pedidosPorCliente.isEmpty()) {
//            return pedidosPorCliente.forEach(pedido -> modelMapper.map());
//        }
//
//    }
}
