package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Cliente;

public class ClienteDAO {

    public void saveCliente(Cliente cliente) {

        String sql = "INSERT INTO clientes(nome, cpf, endereco, email, senha, dataCadastro) VALUES (?, ?, ?,?, ?,?)";

        Connection conn = null;
        java.sql.PreparedStatement pstm = null;

        try {
            // Criar uma conexao com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();

            // Criamos uma PreparedStatement, para executar uma query
            pstm = conn.prepareStatement(sql);
            // Adicionar os valores que sao esperados pela query
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getCpf());
            pstm.setString(3, cliente.getEndereco());
            pstm.setString(4, cliente.getEmail());
            pstm.setString(5, cliente.getSenha());
            pstm.setDate(6, new Date(cliente.getDataCadastro().getTime()));

            // Executar a query
            pstm.execute();

            System.out.println("Cliente salvo com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // Fechar as conexoes
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

    public List<Cliente> getClientes() {

        String sql = "SELECT * FROM clientes";

        List<Cliente> clientes = new ArrayList<Cliente>();

        Connection conn = null;
        PreparedStatement pstm = null;
        // Classe que vai recuperar os dados do banco. ***SELECT****
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while (rset.next()) {

                Cliente cliente = new Cliente();

                
                cliente.setId(rset.getInt("id"));
                cliente.setNome(rset.getString("nome"));
                cliente.setCpf(rset.getString("cpf"));
                cliente.setEndereco(rset.getString("endereco"));
                cliente.setEmail(rset.getString("email"));
                cliente.setSenha(rset.getString("senha"));
                cliente.setDataCadastro(rset.getDate("datacadastro"));
                clientes.add(cliente);

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

        return clientes;
    }

}