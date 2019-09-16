CREATE TABLE pedidos (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    cliente_id BIGINT(20) NOT NULL,
    status TINYINT(2) NOT NULL,
    ativo TINYINT(1) DEFAULT 1,
    observacao VARCHAR(255),
    data_criacao DATETIME NOT NULL,
    data_atualizacao DATETIME NOT NULL,

    CONSTRAINT fk_pedidos_clientes FOREIGN KEY (cliente_id) REFERENCES clientes (id),
    INDEX idx_pedidos_clientes (cliente_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;