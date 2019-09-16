CREATE TABLE pedidos_items (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    pedido_id BIGINT(20) NOT NULL,
    produto_id BIGINT(20) NOT NULL,
    quantidade INT(5) NOT NULL,
    valor DECIMAL(15, 2) NOT NULL,
    valor_total DECIMAL(15, 2) NOT NULL,

    CONSTRAINT fk_pedidos_items_pedidos FOREIGN KEY (pedido_id) REFERENCES pedidos (id),
    CONSTRAINT fk_pedidos_items_produtos FOREIGN KEY (produto_id) REFERENCES produtos (id),

    INDEX idx_pedidos_items_pedidos (pedido_id),
    INDEX idx_pedidos_items_produtos (produto_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


