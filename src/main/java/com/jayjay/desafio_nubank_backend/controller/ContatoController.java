package com.jayjay.desafio_nubank_backend.controller;

import com.jayjay.desafio_nubank_backend.dto.ContatoRequest;
import com.jayjay.desafio_nubank_backend.dto.ContatoResponse;
import com.jayjay.desafio_nubank_backend.service.ClienteService;
import com.jayjay.desafio_nubank_backend.service.ContatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContatoController {

    private final ContatoService contatoService;
    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    // post - contatos
    @PostMapping("/contatos/{id}")
    public ResponseEntity<ContatoResponse> criarContato(@RequestBody ContatoRequest contatoRequest, @PathVariable Long id){
        ContatoResponse contatoResponse = contatoService.criarContato(contatoRequest,id);
        return ResponseEntity.status(HttpStatus.CREATED).body(contatoResponse);
    }

    // get - contatos
    @GetMapping("/clientes/{id}/contatos")
    public ResponseEntity<List<ContatoResponse>> listarContatosPorId(@PathVariable Long id){
        List<ContatoResponse> contatoResponsesIdList = contatoService.listarContatosPorId(id);
        return ResponseEntity.ok(contatoResponsesIdList);
    }
}
