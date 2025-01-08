package br.com.retrogames.service;

import br.com.retrogames.domain.request.ClienteRequest;
import br.com.retrogames.domain.response.ClienteResponse;
import br.com.retrogames.dto.ClienteEntity;
import br.com.retrogames.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    LoginService loginService;

    public ClienteResponse cadastrar(ClienteRequest request) {
        ModelMapper modelMapper = new ModelMapper();
        ClienteEntity entity = modelMapper.map(request, ClienteEntity.class);
        log.info("cadastro de cliente: {}", entity);
        var clienteId =  clienteRepository.save(entity);
        loginService.cadastroCliente(request, clienteId.getIdCliente() );
        return ClienteResponse.builder().nome(entity.getNmCliente()).build();
    }

    public ClienteResponse buscar(Long id) {
        Optional<ClienteEntity> clienteEntity =  clienteRepository.findById(id);
        return clienteEntity.map(entity -> ClienteResponse.builder().nome(entity.getNmCliente()).build()).orElse(null);
    }
}
