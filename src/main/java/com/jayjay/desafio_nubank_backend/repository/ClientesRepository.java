package com.jayjay.desafio_nubank_backend.repository;

import com.jayjay.desafio_nubank_backend.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes,Long> {
}
