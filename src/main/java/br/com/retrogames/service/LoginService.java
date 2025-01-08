package br.com.retrogames.service;

import br.com.retrogames.domain.request.ClienteRequest;
import br.com.retrogames.domain.request.LoginRequest;
import br.com.retrogames.domain.response.UsuarioResponse;
import br.com.retrogames.dto.UsuarioEntity;
import br.com.retrogames.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class LoginService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ModelMapper modelMapper;

    public UsuarioResponse login(LoginRequest loginRequest) {
        Optional<UsuarioEntity> response = usuarioRepository.login(loginRequest.getUsername(), loginRequest.getPassword());
        return response.map(usuarioEntity -> new UsuarioResponse(usuarioEntity.getUsername())).orElse(null);
    }

    public UsuarioEntity cadastroCliente(ClienteRequest request, Long idCliente){
        UsuarioEntity entity = modelMapper.map(request, UsuarioEntity.class);
        entity.setFlAdm(false);
        entity.setIdCliente(idCliente);
        usuarioRepository.save(entity);
        return entity;
    }

    public UsuarioResponse cadastroAdm(LoginRequest loginRequest) {
        UsuarioEntity entity = modelMapper.map(loginRequest, UsuarioEntity.class);
        entity.setFlAdm(true);
        usuarioRepository.save(entity);
        return new UsuarioResponse(entity.getUsername());
    }

    public UsuarioResponse loginAdm(LoginRequest loginRequest) {
        Optional<UsuarioEntity> response = usuarioRepository.loginAdm(loginRequest.getUsername(), loginRequest.getPassword());
        return response.map(usuarioEntity -> new UsuarioResponse(usuarioEntity.getUsername())).orElse(null);
    }

}
