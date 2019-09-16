package com.pedidos.api.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ClienteTipo {

    PESSOA_FISICA(0, "Pessoa fisíca"),
    PESSOA_JURIDICA(1, "Pessoa jurídica");

    private Integer id;
    private final String nome;

    ClienteTipo(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

}
