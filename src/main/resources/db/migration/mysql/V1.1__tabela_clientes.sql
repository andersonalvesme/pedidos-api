CREATE TABLE clientes (
    id BIGINT(20) AUTO_INCREMENT,
    nome VARCHAR(60) NOT NULL,
    tipo TINYINT(1),
    cpf VARCHAR(60),
    telefone_principal VARCHAR(60),
    telefone_secundario VARCHAR(60),
    email VARCHAR(60),
    ativo TINYINT(1) DEFAULT 1,
    observacao VARCHAR(255),
    data_criacao DATETIME NOT NULL,
    data_atualizacao DATETIME NOT NULL,

    PRIMARY KEY (id),
    UNIQUE INDEX idx_clientes_cpf (cpf)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

