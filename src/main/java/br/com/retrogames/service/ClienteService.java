package br.com.retrogames.service;

import br.com.retrogames.domain.request.ClienteRequest;
import br.com.retrogames.domain.response.ClienteResponse;
import br.com.retrogames.dto.ClienteEntity;
import br.com.retrogames.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public ClienteResponse cadastrar(ClienteRequest request) {
        ModelMapper modelMapper = new ModelMapper();
        ClienteEntity entity = modelMapper.map(request, ClienteEntity.class);
        System.out.println(entity.getDataNasc());
        clienteRepository.save(entity);
        return ClienteResponse.builder().nome(entity.getNmCliente()).build();
    }
}
