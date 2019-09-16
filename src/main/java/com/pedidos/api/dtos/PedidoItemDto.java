package com.pedidos.api.dtos;

import com.pedidos.api.entities.Pedido;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;

@Getter
@Setter
public class PedidoItemDto {

    private Long id;

    @NotBlank(message = "O pedido deve ser informado")
    private Pedido pedido;

    @NotBlank(message = "O produto deve ser informado")
    private ProdutoDto produto;

    @NotBlank(message = "A quantidade deve ser informada")
    private Integer quantidade;

    @NotBlank(message = "O valor deve ser informado")
    private BigDecimal valor;

    private BigDecimal valorTotal;

}
