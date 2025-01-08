package br.com.retrogames.service;

import br.com.retrogames.domain.request.ClienteRequest;
import br.com.retrogames.dto.UsuarioEntity;
import br.com.retrogames.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioEntity cadastroCliente(ClienteRequest request, Long idCliente){
        ModelMapper modelMapper = new ModelMapper();
        UsuarioEntity entity = modelMapper.map(request, UsuarioEntity.class);
        entity.setFlAdm(false);
        entity.setIdCliente(idCliente);
        usuarioRepository.save(entity);
        return entity;
    }

    public void cadastroAdm(){

    }
}
