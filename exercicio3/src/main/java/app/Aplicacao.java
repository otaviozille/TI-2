package app;

import static spark.Spark.*;

import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {
        port(4567);

        staticFiles.location("/public");

        ProdutoDAO dao = new ProdutoDAO();

        get("/", (request, response) -> {
            response.redirect("/index.html");
            return null;
        });

        post("/salvar", (request, response) -> {
            String nome = request.queryParams("nome");
            String descricao = request.queryParams("descricao");
            String precoTexto = request.queryParams("preco");

            double preco = Double.parseDouble(precoTexto);

            Produto produto = new Produto(nome, descricao, preco);
            dao.inserir(produto);

            response.redirect("/listar");
            return null;
        });

        get("/listar", (request, response) -> {
            List<Produto> lista = dao.listar();

            String html = """
                <!DOCTYPE html>
                <html lang="pt-BR">
                <head>
                    <meta charset="UTF-8">
                    <title>Lista de Produtos</title>
                    <style>
                        body {
                            font-family: Arial, sans-serif;
                            background-color: #f5f5f5;
                            padding: 30px;
                        }
                        h1 {
                            color: #333;
                        }
                        table {
                            width: 100%;
                            border-collapse: collapse;
                            background: white;
                        }
                        th, td {
                            border: 1px solid #ccc;
                            padding: 10px;
                            text-align: left;
                        }
                        th {
                            background-color: #222;
                            color: white;
                        }
                        a {
                            display: inline-block;
                            margin-top: 20px;
                            text-decoration: none;
                            color: white;
                            background: #007bff;
                            padding: 10px 16px;
                            border-radius: 6px;
                        }
                    </style>
                </head>
                <body>
                    <h1>Produtos Cadastrados</h1>
                    <table>
                        <tr>
                            <th>ID</th>
                            <th>Nome</th>
                            <th>Descrição</th>
                            <th>Preço</th>
                        </tr>
            """;

            for (Produto p : lista) {
                html += "<tr>";
                html += "<td>" + p.getId() + "</td>";
                html += "<td>" + p.getNome() + "</td>";
                html += "<td>" + p.getDescricao() + "</td>";
                html += "<td>R$ " + String.format("%.2f", p.getPreco()) + "</td>";
                html += "</tr>";
            }

            html += """
                    </table>
                    <a href="/index.html">Voltar ao cadastro</a>
                </body>
                </html>
            """;

            return html;
        });
    }
}
