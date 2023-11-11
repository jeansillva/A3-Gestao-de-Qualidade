package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Vendedor;

public class VendedorDAO {
    public void saveVendedor(Vendedor vendedor) {
        String sql = "INSERT INTO vendedores(nome,cnpj,endereco,email,senha,dataCadastro) VALUES (?,?,?,?,?,?)";
        Connection conn = null;
        java.sql.PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, vendedor.getNome());
            pstm.setString(2, vendedor.getCnpj());
            pstm.setString(3, vendedor.getEndereco());
            pstm.setString(4, vendedor.getEmail());
            pstm.setString(5, vendedor.getSenha());
            pstm.setDate(6, new Date(vendedor.getDataCadastro().getTime()));

            pstm.execute();

            System.out.println("Vendedor salvo com sucesso!");
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

    public List<Vendedor> getVendedores() {
        String sql = "SELECT * FROM vendedores";
        List<Vendedor> vendedores = new ArrayList<Vendedor>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while (rset.next()) {
                Vendedor vendedor = new Vendedor();

                vendedor.setId(rset.getInt("id"));
                vendedor.setNome(rset.getString("nome"));
                vendedor.setCnpj(rset.getString("cnpj"));
                vendedor.setEndereco(rset.getString("endereco"));
                vendedor.setEmail(rset.getString("email"));
                vendedor.setSenha(rset.getString("senha"));
                vendedor.setDataCadastro(rset.getDate("datacadastro"));
                vendedores.add(vendedor);
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
        return vendedores;
    }
}
