create database agenda;
use agenda;


create table contatos(
idcon INT IDENTITY(1,1) PRIMARY KEY,
nome varchar(50) not null,
fone varchar(50) not null,
email varchar(50) 
);

insert into contatos (nome,fone,email) values ('Rafael', '99999-1111','rafa@outlook.com');

Select * from contatos;

