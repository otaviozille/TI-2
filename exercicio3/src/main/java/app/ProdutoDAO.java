package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Connection conexao;

    public ProdutoDAO() {
        conectar();
    }

    public boolean conectar() {
        boolean status = false;

        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/loja";
            String usuario = "postgres";
            String senha = "1234"; // TROQUE PELA SUA SENHA DO POSTGRESQL

            conexao = DriverManager.getConnection(url, usuario, senha);
            status = true;
            System.out.println("Conectado ao PostgreSQL com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }

        return status;
    }

    public boolean inserir(Produto produto) {
        boolean status = false;

        try {
            String sql = "INSERT INTO produto (nome, descricao, preco) VALUES (?, ?, ?)";
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setString(1, produto.getNome());
            st.setString(2, produto.getDescricao());
            st.setDouble(3, produto.getPreco());
            st.executeUpdate();
            st.close();
            status = true;
        } catch (Exception e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
        }

        return status;
    }

    public List<Produto> listar() {
        List<Produto> produtos = new ArrayList<>();

        try {
            String sql = "SELECT * FROM produto ORDER BY id";
            PreparedStatement st = conexao.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Produto p = new Produto(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getDouble("preco")
                );
                produtos.add(p);
            }

            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }

        return produtos;
    }
}
