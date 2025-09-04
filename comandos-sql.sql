create database cadastrousuario;

CREATE TABLE `cadastrousuario`.`usuario` (
  `id` INT NOT NULL auto_increment,
  `codigo` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
   `endereco` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
  
select * from usuario;
select * from usuario where id="2";

insert into usuario (codigo, nome, endereco) values ("1", "joao", "Taguatinga");

update usuario set codigo='888', nome = 'Erica', endereco='Japão' where id="2";

delete from usuario where id = '1';


  