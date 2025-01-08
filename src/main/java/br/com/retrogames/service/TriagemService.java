package br.com.retrogames.service;

import br.com.retrogames.domain.request.TriagemRequest;
import br.com.retrogames.domain.response.TriagemResponse;
import br.com.retrogames.dto.TriagemEntity;
import br.com.retrogames.repository.TriagemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TriagemService {
    @Autowired
    private TriagemRepository triagemRepository;

    public TriagemResponse cadastrar(TriagemRequest triagemRequest) {
        ModelMapper modelMapper = new ModelMapper();
        TriagemEntity entity = triagemRepository.save(modelMapper.map(triagemRequest, TriagemEntity.class));
        return new TriagemResponse(entity.getIdOrcamento());
    }

    public TriagemResponse buscar(Long id) {
        Optional<TriagemEntity> optional = triagemRepository.findById(id);
        return optional.map(triagemEntity -> new TriagemResponse(triagemEntity.getIdOrcamento())).orElse(null);
    }
}
