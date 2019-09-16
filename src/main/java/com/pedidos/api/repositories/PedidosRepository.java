package com.pedidos.api.repositories;

import com.pedidos.api.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRepository extends JpaRepository<Pedido, Long> {
}
