package aplicacao;

import java.util.Date;

import dao.ContatoDAO;
import model.Contato;

//MVC
/*
 * Model
 * View
 * Controller
 */

public class Main {

    public static void main(String[] args) {

        ContatoDAO contatoDao = new ContatoDAO();

        Contato contato = new Contato();
        contato.setNome("Maria Gabriela Dias");
        contato.setIdade(35);
        contato.setDataCadastro(new Date());

        contatoDao.save(contato);

        for (Contato c : contatoDao.getContatos()) {
            System.out.println("Contato: " + c.getNome());
        }
    }

}