drop database if exists gamex;
create database if not exists gamex default character set utf8 collate utf8_general_ci;
use gamex;

-- table cliente
create table cliente (
id bigint not null auto_increment,
cpf varchar(20) UNIQUE NOT NULL,
nome varchar(120) not NULL,
endereco varchar(255),
telefone varchar(20),
email varchar(120) not null,
criado_em timestamp not null default current_timestamp,
PRIMARY KEY (id)
) engine = innodb;

-- table fornecedor
create table fornecedor (
id bigint not null auto_increment,
cnpj varchar(20) NOT NULL,
nome varchar(120) NOT NULL,
endereco varchar(120) NOT NULL,
email varchar(120) not NULL,
criado_em timestamp not null default current_timestamp,
PRIMARY KEY (id)
) engine = innodb;

-- table jogos
create table jogos (
id bigint not null auto_increment,
nome varchar(120) not null,
categoria varchar(120),
desenvolvedor varchar(120) not null,
valor numeric (5, 2) not null,
estoque int not null,
criado_em timestamp not null default current_timestamp,
 PRIMARY KEY (id)
) engine = innodb;

-- table usuario
create table usuario (
id bigint not null auto_increment,
cpf varchar(20) not null,
nome varchar(120) not null,
email varchar(120) not null,
senha varchar(120) not null,
criado_em timestamp not null default current_timestamp,
PRIMARY KEY (id)
) engine = innodb;

-- table venda
create table venda (
id bigint not null auto_increment,
jogo_id bigint DEFAULT NULL,
cliente_id bigint DEFAULT NULL,
criado_em timestamp not null default current_timestamp,
PRIMARY KEY (id),
foreign key(jogo_id) references jogos(id),
foreign key(cliente_id) references cliente(id)
) engine = innodb;

-- table compra
create table compra (
id bigint not null auto_increment,
nota_fiscal bigint unique NOT NULL,
fornecedor_id bigint not NULL,
jogo_id bigint not NULL,
criado_em timestamp not null default current_timestamp,
PRIMARY KEY (id),
foreign key(fornecedor_id) references fornecedor(id),
foreign key(jogo_id) references jogos(id)
) engine = innodb;

-- table status
create table status (
id bigint not null auto_increment,
status varchar(120) NOT NULL,
venda_id bigint not NULL,
criado_em timestamp not null default current_timestamp,
 PRIMARY KEY (id),
 foreign key(venda_id) references venda(id)
) engine = innodb;

-- table feedback
create table feedback (
id bigint not null auto_increment,
feedback varchar(255) NOT NULL,
venda_id bigint not null,
criado_em timestamp not null default current_timestamp,
PRIMARY KEY (id),
foreign key(venda_id) references venda(id)
) engine = innodb;


insert into usuario(cpf, nome, email, senha) values ('1', 'Adminstrador', 'admin', md5('admin123'));