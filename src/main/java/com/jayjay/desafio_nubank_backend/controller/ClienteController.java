package com.jayjay.desafio_nubank_backend.controller;

import com.jayjay.desafio_nubank_backend.dto.ClientesRequest;
import com.jayjay.desafio_nubank_backend.dto.ClientesResponse;
import com.jayjay.desafio_nubank_backend.service.ClienteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    private final ClienteService clienteService;
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // post - clientes
    @PostMapping("/clientes")
    public ResponseEntity<ClientesResponse> criarCliente(@RequestBody ClientesRequest clientesRequest){
        ClientesResponse clientesResponse = clienteService.criarCliente(clientesRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientesResponse);
    }

    // get - clientes
    @GetMapping("/clientes")
    public ResponseEntity<List<ClientesResponse>> listarClientes(){
        List<ClientesResponse> clientesResponseList = clienteService.listarClientes();
        return ResponseEntity.ok(clientesResponseList);
    }
}
