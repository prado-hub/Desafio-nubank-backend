package com.jayjay.desafio_nubank_backend.dto;

import java.util.List;

public record ClientesResponse(Long id,String nome, List<ContatoRequest> contatoDTOS) {
}
