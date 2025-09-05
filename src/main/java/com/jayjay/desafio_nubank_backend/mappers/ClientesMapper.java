package com.jayjay.desafio_nubank_backend.mappers;

import com.jayjay.desafio_nubank_backend.dto.ClientesRequest;
import com.jayjay.desafio_nubank_backend.dto.ClientesResponse;
import com.jayjay.desafio_nubank_backend.dto.ContatoRequest;
import com.jayjay.desafio_nubank_backend.entity.Clientes;
import com.jayjay.desafio_nubank_backend.entity.Contato;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientesMapper {
    public Clientes toEntity(ClientesRequest clientesRequest){
        Clientes clientes = new Clientes();
        clientes.setNome(clientesRequest.nome());

        if(clientesRequest.contatoDTOS() != null && clientesRequest.contatoDTOS().size() > 0) {
            List<Contato> contatoList = clientesRequest.contatoDTOS().stream()
                    .map(m -> {
                        Contato contato = new Contato();
                        contato.setTelefone(m.telefone());
                        contato.setEmail(m.email());
                        contato.setClientes(clientes);
                        return contato;
                    }).toList();
            clientes.setContatoList(contatoList);
        }
        return clientes;
    }

    public ClientesResponse toResponse(Clientes clientes){
        List<ContatoRequest> contatoDTOS = clientes.getContatoList().stream()
                .map(contato -> new ContatoRequest(contato.getTelefone(), contato.getEmail())).toList();
        return new ClientesResponse(clientes.getId(), clientes.getNome(),contatoDTOS);
    }
}
