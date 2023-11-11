package aplicacao;

import java.util.Date;

import dao.ClienteDAO;
import dao.VendedorDAO;
import model.Cliente;
import model.Vendedor;

public class Main {

    public static void main(String[] args) {

        // Adicionando Cliente ao banco
        ClienteDAO clienteDao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setNome("Maria Gabriela Dias");
        cliente.setCpf("001.111.222-33");
        cliente.setEndereco("R. Pernambuco, 128, Betim-MG");
        cliente.setEmail("maria@gmail.com");
        cliente.setSenha("Maria123");
        cliente.setDataCadastro(new Date()); // SAVE DO CLIENTE
        clienteDao.saveCliente(cliente);

        for (Cliente c : clienteDao.getClientes()) {
            System.out.println("Cliente: " + c.getNome());
        }

        // Adicionando Vendedor ao banco
        VendedorDAO vendedorDAO = new VendedorDAO();
        Vendedor vendedor = new Vendedor();
        vendedor.setNome("William Bonner");
        vendedor.setCnpj("00.000.000/0001-00");
        vendedor.setEndereco("R. Florinda, 001, São Paulo-SP");
        vendedor.setEmail("vendedor@gmail.com");
        vendedor.setSenha("Vendomuito123");
        vendedor.setDataCadastro(new Date());
        vendedorDAO.saveVendedor(vendedor); // SAVE DO VENDEDOR
        for(Vendedor v : vendedorDAO.getVendedores()){
            System.out.println("Vendedor: " + v.getNome());
        }
    }

}