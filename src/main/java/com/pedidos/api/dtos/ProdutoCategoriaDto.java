package com.pedidos.api.dtos;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
public class ProdutoCategoriaDto {

    private Long id;

    @NotBlank(message = "O nome deve ser informado")
    private String nome;

    private String ativo;

}
