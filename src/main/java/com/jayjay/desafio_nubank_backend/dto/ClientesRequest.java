package com.jayjay.desafio_nubank_backend.dto;

import java.util.List;

public record ClientesRequest(String nome, List<ContatoRequest> contatoDTOS) {
}
