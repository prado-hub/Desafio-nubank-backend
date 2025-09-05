package com.jayjay.desafio_nubank_backend.service;

import com.jayjay.desafio_nubank_backend.dto.ClientesRequest;
import com.jayjay.desafio_nubank_backend.dto.ClientesResponse;
import com.jayjay.desafio_nubank_backend.entity.Clientes;
import com.jayjay.desafio_nubank_backend.mappers.ClientesMapper;
import com.jayjay.desafio_nubank_backend.repository.ClientesRepository;
import com.jayjay.desafio_nubank_backend.repository.ContatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClientesRepository clientesRepository;
    private final ClientesMapper clientesMapper;
    public ClienteService(ClientesRepository clientesRepository, ClientesMapper clientesMapper) {
        this.clientesRepository = clientesRepository;
        this.clientesMapper = clientesMapper;
    }

    // post - cliente
    public ClientesResponse criarCliente(ClientesRequest clientesRequest){
        Clientes clienteCriado = clientesMapper.toEntity(clientesRequest);
        clientesRepository.save(clienteCriado);
        return clientesMapper.toResponse(clienteCriado);
    }

    // get - clientes
    public List<ClientesResponse> listarClientes(){
        return clientesRepository.findAll()
                .stream()
                .map(clientesMapper::toResponse)
                .toList();
    }
}
