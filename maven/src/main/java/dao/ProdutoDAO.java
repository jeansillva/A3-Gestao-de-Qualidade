package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Produto;

public class ProdutoDAO {
    public void saveProduto(Produto produto) {
        String sql = "INSERT INTO produtos(nome, preco, qtd) VALUES (?,?,?)";

        Connection conn = null;
        java.sql.PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, produto.getNome());
            pstm.setDouble(2, produto.getPreco());
            pstm.setInt(3, produto.getQtd());
            pstm.execute();

            System.out.println("Produto cadastrado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public List<Produto> getProdutos() {
        String sql = "SELECT * FROM produtos";

        List<Produto> produtos = new ArrayList<Produto>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while (rset.next()) {
                Produto produto = new Produto();
                produto.setId(rset.getInt("id"));
                produto.setNome(rset.getString("nome"));
                produto.setPreco(rset.getDouble("preco"));
                produto.setQtd(rset.getInt("qtd"));
                produtos.add(produto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }

                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return produtos;
    }

}
