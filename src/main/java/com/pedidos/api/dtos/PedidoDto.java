package com.pedidos.api.dtos;

import com.pedidos.api.entities.Cliente;
import com.pedidos.api.entities.PedidoStatus;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
public class PedidoDto {

    private Long id;

    @NotBlank(message = "O cliente deve ser informado")
    private Cliente cliente;

    private PedidoStatus status;

    private String observacao;

}
