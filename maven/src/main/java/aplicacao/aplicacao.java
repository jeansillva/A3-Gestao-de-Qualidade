package aplicacao;

import dao.ClienteDAO;
import dao.ProdutoDAO;
import dao.VendedorDAO;
import model.Cliente;
import model.Produto;
import model.Vendedor;

import java.util.Date;

public class aplicacao {

    public static void cadastrarNovoCliente() {
        ClienteDAO clienteDao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setNome("Maria Gabriela Dias");
        cliente.setCpf("001.111.222-33");
        cliente.setEndereco("R. Pernambuco, 128, Betim-MG");
        cliente.setEmail("maria@gmail.com");
        cliente.setSenha("Maria123");
        cliente.setDataCadastro(new Date());
        clienteDao.saveCliente(cliente);
    }

    public static void exibirClientes() {
        ClienteDAO clienteDao = new ClienteDAO();
        for (Cliente c : clienteDao.getClientes()) {
            System.out.println("Cliente: " + c.getNome());
        }
    }

    public static void cadastrarNovoVendedor() {
        VendedorDAO vendedorDAO = new VendedorDAO();
        Vendedor vendedor = new Vendedor();
        vendedor.setNome("William Bonner");
        vendedor.setCnpj("00.000.000/0001-00");
        vendedor.setEndereco("R. Florinda, 001, São Paulo-SP");
        vendedor.setEmail("vendedor@gmail.com");
        vendedor.setSenha("Vendomuito123");
        vendedor.setDataCadastro(new Date());
        vendedorDAO.saveVendedor(vendedor);
    }

    public static void exibirVendedores() {
        VendedorDAO vendedorDAO = new VendedorDAO();
        for (Vendedor v : vendedorDAO.getVendedores()) {
            System.out.println("Vendedor: " + v.getNome());
        }
    }

    public static void cadastrarNovoProduto() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = new Produto();
        produto.setNome("Bola Branca");
        produto.setPreco(18.50);
        produto.setQtd(10);
        produtoDAO.saveProduto(produto);
    }

    public static void exibirProdutos() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        for (Produto p : produtoDAO.getProdutos()) {
            System.out.println("Produto: " + p.getNome());
        }
    }

    public static void cadastrarNovoClienteComInformacoesInvalidas() {
        ClienteDAO clienteDao = new ClienteDAO();
        Cliente cliente = new Cliente();

        cliente.setNome("");
        cliente.setCpf("123");
        cliente.setEndereco("");
        cliente.setEmail("email@outlook.com");
        cliente.setSenha("zedamanga");

        try {
            clienteDao.saveCliente(cliente);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar cliente com informações inválidas: " + e.getMessage());
        }
    }
}
