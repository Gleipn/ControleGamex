drop database if exists gamex;
create database if not exists gamex default character set utf8 collate utf8_general_ci;
use gamex;

-- table cliente
create table cliente (
id_cliente bigint not null auto_increment,
cpf_cliente varchar(20) UNIQUE NOT NULL,
nome_cliente varchar(120) not NULL,
endereco_cliente varchar(255) not null,
telefone_cliente varchar(20) not null,
email_cliente varchar(120) not null,
criado_em timestamp not null default current_timestamp,
PRIMARY KEY (id_cliente)
) engine = innodb;

-- table fornecedor
create table fornecedor (
id_fornecedor bigint not null auto_increment,
cnpj_fornecedor varchar(20) NOT NULL,
nome_fornecedor varchar(120) NOT NULL,
endereco_fornecedor varchar(120) NOT NULL,
email_fornecedor varchar(120) not NULL,
criado_em timestamp not null default current_timestamp,
PRIMARY KEY (id_fornecedor)
) engine = innodb;

-- table jogo
create table jogo (
id_jogo bigint not null auto_increment,
nome_jogo varchar(120) not null,
categoria_jogo varchar(120) not null,
desenvolvedor_jogo varchar(120) not null,
valor_jogo numeric (5, 2) not null,
estoque_jogo int not null,
criado_em timestamp not null default current_timestamp,
 PRIMARY KEY (id_jogo)
) engine = innodb;

-- table usuario
create table usuario (
id_usuario bigint not null auto_increment,
cpf_usuario varchar(20) not null,
nome_usuario varchar(120) not null,
email_usuario varchar(120) not null,
senha_usuario varchar(120) not null,
criado_em timestamp not null default current_timestamp,
PRIMARY KEY (id_usuario)
) engine = innodb;

-- table venda
create table venda (
id_venda bigint not null auto_increment,
jogo_id bigint not NULL,
cliente_id bigint not NULL,
criado_em timestamp not null default current_timestamp,
PRIMARY KEY (id_venda),
foreign key(jogo_id) references jogo(id_jogo),
foreign key(cliente_id) references cliente(id_cliente)
) engine = innodb;

-- table compra
create table compra (
id_compra bigint not null auto_increment,
fornecedor_id bigint not NULL,
jogo_id bigint not NULL,
criado_em timestamp not null default current_timestamp,
PRIMARY KEY (id_compra),
foreign key(fornecedor_id) references fornecedor(id_fornecedor),
foreign key(jogo_id) references jogo(id_jogo)
) engine = innodb;

-- table status
create table status (
id_status bigint not null auto_increment,
situacao_status varchar(120) NOT NULL,
venda_id bigint not NULL,
criado_em timestamp not null default current_timestamp,
 PRIMARY KEY (id_status),
 foreign key(venda_id) references venda(id_venda)
) engine = innodb;

-- table feedback
create table feedback (
id_feedback bigint not null auto_increment,
feedback varchar(255) NOT NULL,
venda_id bigint not null,
criado_em timestamp not null default current_timestamp,
PRIMARY KEY (id_feedback),
foreign key(venda_id) references venda(id_venda)
) engine = innodb;


insert into usuario(cpf_usuario, nome_usuario, email_usuario, senha_usuario) values ('1', 'Adminstrador', 'admin', md5('admin123'));