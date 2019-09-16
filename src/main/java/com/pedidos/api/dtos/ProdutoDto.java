package com.pedidos.api.dtos;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoDto {

    private Long id;

    private ProdutoCategoriaDto categoria;

    @NotBlank(message = "O nome deve ser informado")
    private String nome;

    private BigDecimal valor;

    private Boolean ativo;

    private String observacao;

}
