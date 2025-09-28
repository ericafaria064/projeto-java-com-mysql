CREATE DATABASE cadastrousuario;

USE cadastrousuario;

CREATE TABLE usuario (
    id INT NOT NULL AUTO_INCREMENT,
    codigo VARCHAR(45) NOT NULL,
    nome VARCHAR(45) NOT NULL,
    endereco VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO usuario (codigo, nome, endereco) VALUES ('111', 'Joao', 'Taguatinga');
INSERT INTO usuario (codigo, nome, endereco) VALUES ('222', 'Erica', 'Ceilândia');

SELECT * FROM usuario;

SELECT * FROM usuario WHERE id = 2;

UPDATE usuario SET codigo = '888', nome = 'Erica', endereco = 'Japao' WHERE id = 2;

DELETE FROM usuario WHERE id = 1;