package aplicacao;

import java.util.Date;

import dao.ClienteDAO;
import model.Cliente;

//MVC
/*
 * Model
 * View
 * Controller
 */

public class Main {

    public static void main(String[] args) {

        ClienteDAO clienteDao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setNome("Maria Gabriela Dias");
        cliente.setCpf("001.111.222-33");
        cliente.setEndereco("R. Pernambuco, 128, Betim-MG");
        cliente.setEmail("maria@gmail.com");
        cliente.setSenha("Maria123");
        cliente.setDataCadastro(new Date());

        clienteDao.save(cliente);

        for (Cliente c : clienteDao.getClientes()) {
            System.out.println("Cliente: " + c.getNome());
        }
    }

}