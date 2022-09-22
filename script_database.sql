drop database if exists gamex;
create database if not exists gamex default character set utf8 collate utf8_general_ci;
use gamex;

-- table cliente
create table cliente (
id_cliente bigint not null auto_increment,
cpf_cliente varchar(20) unique not null,
nome_cliente varchar(255) not null,
endereco_cliente varchar(255) not null,
telefone_cliente varchar(20) not null,
email_cliente varchar(255) not null,
senha_cliente varchar(255) not null,
criado_em timestamp not null default current_timestamp,
primary key (id_cliente)
) engine = innodb;

-- table fornecedor
create table fornecedor (
id_fornecedor bigint not null auto_increment,
cnpj_fornecedor varchar(20) not null,
nome_fornecedor varchar(255) not null,
endereco_fornecedor varchar(255) not null,
email_fornecedor varchar(255) not null,
criado_em timestamp not null default current_timestamp,
primary key (id_fornecedor)
) engine = innodb;

-- table jogo
create table jogo (
id_jogo bigint not null auto_increment,
nome_jogo varchar(255) not null,
categoria_jogo varchar(255) not null,
desenvolvedor_jogo varchar(255) not null,
valorcompra_jogo numeric (5, 2) default 0,
valorvenda_jogo numeric (5, 2) default 0,
estoque_jogo int default 0,
imagem_jogo varchar(255),
criado_em timestamp not null default current_timestamp,
 primary key (id_jogo)
) engine = innodb;

-- table usuario
create table usuario (
id_usuario bigint not null auto_increment,
nome_usuario varchar(255) not null,
email_usuario varchar(255) not null,
senha_usuario varchar(255) not null,
criado_em timestamp not null default current_timestamp,
primary key (id_usuario)
) engine = innodb;

-- table venda
create table venda (
id_venda bigint not null auto_increment,
jogo_id bigint not null,
cliente_id bigint not null,
criado_em timestamp not null default current_timestamp,
primary key (id_venda),
foreign key(jogo_id) references jogo(id_jogo),
foreign key(cliente_id) references cliente(id_cliente)
) engine = innodb;

-- table compra
create table compra (
id_compra bigint not null auto_increment,
fornecedor_id bigint not null,
jogo_id bigint not null,
criado_em timestamp not null default current_timestamp,
primary key (id_compra),
foreign key(fornecedor_id) references fornecedor(id_fornecedor),
foreign key(jogo_id) references jogo(id_jogo)
) engine = innodb;

insert into usuario(nome_usuario, email_usuario, senha_usuario) values ('adminstrador', 'admin@admin.com', md5('admin'));
insert into jogo (nome_jogo, categoria_jogo, desenvolvedor_jogo, valorcompra_jogo, valorvenda_jogo, estoque_jogo, imagem_jogo) values ("BattleField V", "Ação", "DICE", 100, 300, 11, "images/3b3337c17c.webp");
insert into jogo (nome_jogo, categoria_jogo, desenvolvedor_jogo, valorcompra_jogo, valorvenda_jogo, estoque_jogo, imagem_jogo) values ("Horizon Zero Dawn", "Aventura", "Guerrilla", 100, 300, 7, "images/horizon_zero_dawn_ps4_midia_fisica_pronta_entrega_897_1_20210216170058.webp");
insert into fornecedor (cnpj_fornecedor, nome_fornecedor, endereco_fornecedor, email_fornecedor) values ("00.000.000/0000-00", "Playstation", "Algum Lugar", "Ps@Sony.com");
insert into fornecedor (cnpj_fornecedor, nome_fornecedor, endereco_fornecedor, email_fornecedor) values ("00.000.000/0000-01", "Eletronic Arts", "Lugar Algum", "Fifa@Ea.com");
