-- Criar o banco de dados
CREATE DATABASE IF NOT EXISTS dbcontatos;
USE dbcontatos;

-- Tabela tb_contato
CREATE TABLE IF NOT EXISTS tb_contato (
    email VARCHAR(255) PRIMARY KEY,
    nome VARCHAR(255)
);

-- Inserir dados na tb_contato
INSERT INTO tb_contato (email, nome) VALUES 
    ('exemplo1@gmail.com', 'Exemplo Contato 1'),
    ('exemplo2@gmail.com', 'Exemplo Contato 2');

-- Tabela tb_login
CREATE TABLE IF NOT EXISTS tb_login (
    usuario VARCHAR(255) PRIMARY KEY,
    senha VARCHAR(255)
);

-- Inserir dados na tb_login
INSERT INTO tb_login (usuario, senha) VALUES 
    ('usuario1', 'senha1'),
    ('usuario2', 'senha2');

-- Verificar o conteúdo da tabela tb_contato
SELECT * FROM tb_contato;

-- Verificar o conteúdo da tabela tb_login
SELECT * FROM tb_login;

-- Excluir todos os registros da tabela tb_contato
DELETE FROM tb_contato;

-- Excluir todos os registros da tabela tb_login
DELETE FROM tb_login;