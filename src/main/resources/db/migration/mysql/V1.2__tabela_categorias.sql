CREATE TABLE categorias (
    id BIGINT(20) AUTO_INCREMENT,
    nome VARCHAR(60) NOT NULL,
    ativo TINYINT(1) DEFAULT 1,
    data_criacao DATETIME NOT NULL,
    data_atualizacao DATETIME NOT NULL,

    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO categorias (nome, data_criacao, data_atualizacao) VALUES ('Bebidas', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO categorias (nome, data_criacao, data_atualizacao) VALUES ('Calzone', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO categorias (nome, data_criacao, data_atualizacao) VALUES ('Lanches', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO categorias (nome, data_criacao, data_atualizacao) VALUES ('Pizza', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO categorias (nome, data_criacao, data_atualizacao) VALUES ('Porções', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO categorias (nome, data_criacao, data_atualizacao) VALUES ('Tábua', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
