package com.pedidos.api.repositories;

import com.pedidos.api.entities.ProdutoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosCategoriasRepository extends JpaRepository<ProdutoCategoria, Long> {
}
