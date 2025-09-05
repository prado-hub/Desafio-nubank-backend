package com.jayjay.desafio_nubank_backend.mappers;

import com.jayjay.desafio_nubank_backend.dto.ContatoRequest;
import com.jayjay.desafio_nubank_backend.dto.ContatoResponse;
import com.jayjay.desafio_nubank_backend.entity.Contato;
import org.springframework.stereotype.Component;

@Component
public class ContatoMapper {
    public Contato toEntity(ContatoRequest contatoRequest){
        Contato contato = new Contato();
        contato.setTelefone(contatoRequest.telefone());
        contato.setEmail(contatoRequest.email());
        return  contato;
    }

    public ContatoResponse toResponse(Contato contato){
        return new ContatoResponse(contato.getId(),contato.getTelefone(),contato.getEmail());
    }
}
