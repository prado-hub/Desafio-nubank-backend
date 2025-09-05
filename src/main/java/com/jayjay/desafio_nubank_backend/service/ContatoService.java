package com.jayjay.desafio_nubank_backend.service;

import com.jayjay.desafio_nubank_backend.dto.ContatoRequest;
import com.jayjay.desafio_nubank_backend.dto.ContatoResponse;
import com.jayjay.desafio_nubank_backend.entity.Clientes;
import com.jayjay.desafio_nubank_backend.entity.Contato;
import com.jayjay.desafio_nubank_backend.mappers.ContatoMapper;
import com.jayjay.desafio_nubank_backend.repository.ClientesRepository;
import com.jayjay.desafio_nubank_backend.repository.ContatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {
    private final ClientesRepository clientesRepository;
    private final ContatoRepository contatoRepository;
    private final ContatoMapper contatoMapper;

    public ContatoService(ClientesRepository clientesRepository, ContatoRepository contatoRepository, ContatoMapper contatoMapper) {
        this.clientesRepository = clientesRepository;
        this.contatoRepository = contatoRepository;
        this.contatoMapper = contatoMapper;
    }

    // post - contato
    public ContatoResponse criarContato(ContatoRequest contatoRequest, Long id){
        Clientes clientes = clientesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encotrado"));
        Contato contatoCriado = contatoMapper.toEntity(contatoRequest);
        contatoCriado.setClientes(clientes);
        contatoRepository.save(contatoCriado);
        return contatoMapper.toResponse(contatoCriado);
    }

    // get - contatos
    public List<ContatoResponse> listarContatosPorId(Long id){
        Clientes clienteId = clientesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        List<Contato> contatoList = clienteId.getContatoList();
        return contatoList
                .stream()
                .map(contatoMapper::toResponse)
                .toList();
    }
}
