package com.pedidos.api.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private ClienteTipo tipo;

    private String cpf;

    @Column(name = "telefone_principal")
    private String telefonePrincipal;

    @Column(name = "telefone_secundario")
    private String telefoneSecundario;

    private String email;

    private Boolean ativo;

    private String observacao;

    @OneToMany
    @JoinColumn(name = "cliente_id")
    private List<Pedido> pedidos;

    @Column(name = "data_criacao")
    private Date dataCriacao;

    @Column(name = "data_atualizacao")
    private Date dataAtualizacao;

    @PreUpdate
    public void preUpdate() {
        dataAtualizacao = new Date();
    }

    @PrePersist
    public void prePersist() {
        final Date dataAtual = new Date();

        dataCriacao = dataAtual;
        dataAtualizacao = dataAtual;
    }

}
