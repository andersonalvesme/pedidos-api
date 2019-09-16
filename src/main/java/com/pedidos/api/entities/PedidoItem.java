package com.pedidos.api.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "pedidos_items")
public class PedidoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private Integer quantidade;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @PreUpdate
    public void preUpdate() {
        valorTotal = BigDecimal.valueOf(quantidade).multiply(valor);
    }

    @PrePersist
    public void prePersist() {
        valorTotal = BigDecimal.valueOf(quantidade).multiply(valor);
    }

}
