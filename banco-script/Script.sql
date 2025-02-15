create database db_retrofix; 

use db_retrofix;


CREATE TABLE cliente (
    id_cliente INT PRIMARY key AUTO_INCREMENT,
    nm_cliente VARCHAR(100),
    telefone VARCHAR(11),
    data_nasc DATE,
    email VARCHAR(50)
);	



create table usuario (
	id_usuario int PRIMARY key auto_increment,
    username VARCHAR(50),
    senha VARCHAR(10),
    fl_adm BIT,
    id_cliente int,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

CREATE TABLE orcamento (
    id_orcamento INT PRIMARY key AUTO_INCREMENT,
    id_cliente INT,
    nm_videogame VARCHAR(50),
    ds_problema VARCHAR(500),
    tp_servico VARCHAR(50),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

CREATE TABLE pedido (
    id_pedido INT  PRIMARY key AUTO_INCREMENT,
    id_cliente INT,
    dt_pedido DATE,
    status_pedido VARCHAR(30),
    vl_total DECIMAL(10,2), 
    forma_pagto VARCHAR(30),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

CREATE TABLE produto (
    id_produto INT PRIMARY key AUTO_INCREMENT,
    descricao VARCHAR(500),
    vl_produto DECIMAL(10,2),
    fl_disponivel BIT,
    url_img VARCHAR(500),
    qtd_estoque INT
);

CREATE TABLE item_pedido (
    id_produto INT,
    id_pedido INT,
    qtd_produto int,
    primary key (id_produto,id_pedido),
    FOREIGN KEY (id_produto) REFERENCES produto(id_produto),
    FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido)
);

select * from cliente;

select * from usuario u;

select * from orcamento;


select * from produto;


-- Triggers
-- Atualizar estoque quando um pedido for feito

CREATE TRIGGER atualizar_estoque
AFTER INSERT ON item_pedido
FOR EACH ROW
BEGIN
    UPDATE produto
    SET qtd_estoque = qtd_estoque - NEW.qtd_produto
    WHERE id_produto = NEW.id_produto;
END; 


-- cadastras ja a quandidade como 1 unidade, sempre
CREATE TRIGGER trigger_atualiza_estoque_produto
BEFORE INSERT ON produto  
FOR EACH ROW
BEGIN
    SET NEW.qtd_estoque = 1;
end;

-- validacao para evitar cadastro duplicado

CREATE TRIGGER tr_produto_duplicado
BEFORE INSERT ON produto
FOR EACH ROW
BEGIN
    -- Verifica se já existe um produto com a mesma descrição
    IF EXISTS (SELECT 1 FROM produto WHERE descricao = NEW.descricao) THEN
        -- Se existir, impede a inserção e sinaliza um erro
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Produto com essa descrição já cadastrado.';
    END IF;
END 


-- Stored Procedures
CREATE PROCEDURE atualizar_quantidade_produto(
    IN p_id_produto INT,
    IN p_quantidade INT
)
BEGIN
    UPDATE produto
    SET qtd_estoque = p_quantidade
    WHERE id_produto = p_id_produto;

    IF ROW_COUNT() = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Produto não encontrado';
    END IF;
end;







-- Views
-- Produtos disponíveis no estoque

CREATE VIEW produtos_disponiveis AS
SELECT id_produto, descricao, vl_produto, qtd_estoque
FROM produto
WHERE fl_disponivel = 1 AND qtd_estoque > 0;

select * from produtos_disponiveis;
-- Functions
-- Calcular total de produtos em estoque

CREATE FUNCTION total_estoque()
RETURNS INT
DETERMINISTIC  -- Important: Add this if your SQL dialect supports it and the function is deterministic
READS SQL DATA -- Important: Add this to explicitly state that the function reads data
BEGIN
    DECLARE total INT;

    SELECT COALESCE(SUM(qtd_estoque), 0) INTO total FROM produto; -- Handle NULLs

    RETURN total;
END;


select total_estoque()


select * from produto;

INSERT INTO produto (descricao,vl_produto,fl_disponivel,url_img,qtd_estoque) VALUES
	 ('3ds',22.00,0,'https://i5.walmartimages.com/seo/Nintendo-GameBoy-Game-Boy-Color-Atomic-Purple-Authentic-100-OEM_af704870-eee2-401a-b2d1-a5b463213a37.3edcbe62993c043ee53a9cc925ef5c40.png',1);
	

select * from orcamento o ;