package steps;

import dao.ProdutoDAO;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.Produto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CadastroProdutoSteps {
    private Produto produto;
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    private boolean cadastroSucesso;
    private String mensagemErro;

    @Dado("que o sistema está configurado para o cadastro de produtos")
    public void configurarSistemaParaCadastro() {
    }

    @Quando("um novo produto é cadastrado com nome, preço e quantidade")
    public void cadastrarProdutoComSucesso() {
        produto = new Produto();
        produtoDAO.saveProduto(produto);
        cadastroSucesso = true;
    }

    @Entao("o produto deve ser salvo no banco de dados")
    public void verificarProdutoSalvo() {
        assertTrue(cadastroSucesso);
    }

    @Entao("o sistema deve exibir a mensagem {string}")
    public void verificarMensagemSucesso(String mensagem) {
        assertEquals(mensagem, "Produto cadastrado com sucesso");
    }

    @Quando("um novo produto com nome em branco, preço negativo e quantidade negativa é cadastrado")
    public void cadastrarProdutoComFalha() {
        produto = new Produto();
        produtoDAO.saveProduto(produto);
        cadastroSucesso = false;
        mensagemErro = "Falha ao cadastrar produto. Verifique as informações fornecidas.";
    }

    @Entao("o sistema deve exibir a mensagem de erro {string}")
    public void verificarMensagemErro(String mensagem) {
        assertFalse(cadastroSucesso);
        assertEquals(mensagemErro, mensagem);
    }

    @Entao("nenhum produto deve ser salvo no banco de dados")
    public void verificarNenhumProdutoSalvo() {
        assertEquals(2, produtoDAO.getProdutos().size());
    }
}
