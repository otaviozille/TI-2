CREATE DATABASE loja;

-- Entre no banco "loja" e depois execute:
CREATE TABLE produto (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(200) NOT NULL,
    preco DOUBLE PRECISION NOT NULL
);
