create database marketplace;

create table
    clientes(
        id int not null auto_increment primary key,
        nome varchar(50),
        cpf char(14),
        endereco varchar(100),
        email varchar(80),
        senha varchar(30),
        dataCadastro date
    )