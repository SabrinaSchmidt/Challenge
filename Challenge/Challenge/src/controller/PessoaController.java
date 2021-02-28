package controller;

import dao.EspacoCafeDAO;
import dao.PessoaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Pessoa;

/**
 *
 * @author Sabrina
 * @since 02/2021
 * @version 1.0
 *
 */
public class PessoaController implements IController {

    //Variavel comum
    PessoaDAO pessoa = new PessoaDAO();

    /**
     * Metodo responsável pela consulta e retorno de ArrayList de pessoa(s)
     *
     * @return ArrayList de pessoa(s)
     */
    public ArrayList<Pessoa> daoAcess() {
        EspacoCafeDAO ec = new EspacoCafeDAO();
        if (this.pessoa.queryByController().get(1).getIdEspacoCafe() == ec.queryByController().get(1).getId()) {
        }
        return this.pessoa.queryByController();
    }

    /**
     * Metodo responsável pela adição de pessoas chama a classe Pessoa
     *
     * @param pessoa passa uma variável pessoa como parâmetro
     * @return boolean pois faz a verificação de adição
     */
    public boolean add(Pessoa pessoa) {
        try {
            if (this.pessoa.add(pessoa) == true) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return false;
    }

    /**
     * Metodo responsável pela consulta pelo nome
     *
     * @param nome metodo faz a consulta no bd nominal
     */
    public void search(String nome) {
        pessoa.search(nome);

    }

    /**
     * Metodo responsável Consulta de pessoa(s)
     *
     * @return ArrayList pois faz a consulta pelas pessoas adicionadas no BD
     */
    public ArrayList<Pessoa> queryByController() {
        ArrayList<Pessoa> pessoa = new ArrayList();
        return pessoa;
    }
}
