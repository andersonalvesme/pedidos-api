CREATE TABLE produtos (
    id BIGINT(20) AUTO_INCREMENT,
    categoria_id BIGINT(20) NOT NULL,
    nome VARCHAR(60) NOT NULL,
    valor DECIMAL(15,2),
    ativo TINYINT(1) DEFAULT 1,
    observacao VARCHAR(255),
    data_criacao DATETIME NOT NULL,
    data_atualizacao DATETIME NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT fk_produtos_categorias FOREIGN KEY (categoria_id) REFERENCES categorias (id),
    INDEX idx_produtos_categorias (categoria_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;