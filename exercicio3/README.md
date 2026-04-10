# Produto Web - Java + Spark + PostgreSQL

Projeto simples de cadastro de produtos para entrega de exercício.

## Tecnologias usadas
- Java
- Maven
- Spark Java
- PostgreSQL
- HTML

## Estrutura
- `src/main/java/app/Produto.java`
- `src/main/java/app/ProdutoDAO.java`
- `src/main/java/app/Aplicacao.java`
- `src/main/resources/public/index.html`

## Banco de dados

Crie o banco:
```sql
CREATE DATABASE loja;
```

Depois crie a tabela:
```sql
CREATE TABLE produto (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(200) NOT NULL,
    preco DOUBLE PRECISION NOT NULL
);
```

## Ajuste importante
No arquivo `src/main/java/app/ProdutoDAO.java`, troque a senha do PostgreSQL:

```java
String usuario = "postgres";
String senha = "1234";
```

## Como rodar no VS Code

Abra o terminal na pasta do projeto e execute:

```bash
mvn clean compile
mvn exec:java
```

Depois acesse:
```text
http://localhost:4567
```

## Observação
O exercício foi desenvolvido no VS Code, mas usando as tecnologias pedidas no enunciado:
- Maven
- PostgreSQL
- Spark
- Java

A IDE não altera o funcionamento do projeto.
