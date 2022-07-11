CREATE SCHEMA IF NOT EXISTS usuarios;

CREATE TABLE usuarios.usuario (
	id INTEGER PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	cpf VARCHAR(100) NOT NULL,
	endereco VARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL,
	telefone VARCHAR(100) NOT NULL,
	data_cadastro TIMESTAMP NOT NULL
);