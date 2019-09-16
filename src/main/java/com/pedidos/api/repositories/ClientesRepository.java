package com.pedidos.api.repositories;

import com.pedidos.api.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Cliente, Long> {
}
