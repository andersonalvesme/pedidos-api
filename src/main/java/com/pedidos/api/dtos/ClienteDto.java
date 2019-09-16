package com.pedidos.api.dtos;

import com.pedidos.api.entities.ClienteTipo;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
public class ClienteDto {

    private Long id;

    @NotBlank(message = "O nome deve ser informado")
    private String nome;

    private ClienteTipo tipo;

    @CPF
    private String cpf;

    private String telefonePrincipal;

    private String telefoneSecundario;

    @Email
    private String email;

    private Boolean ativo;

    private String observacao;

}
