package test;

import dao.PessoaDAO;
import java.sql.SQLException;
import model.Pessoa;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Sabrina
 * @since 02/2021
 * @version 1.0
 *
 */
public class PessoaTest {

    @Test
    public void testAddPessoa() throws SQLException {

        //Instancia de classe e criação de um novo elemento
        Pessoa pessoa = new Pessoa();
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoa.setId(1);
        pessoa.setNome("Teste");
        pessoa.setSobrenome("Teste nome");
        pessoa.setIdEspacoCafe(2);

        //Variavel booleana que recebe o resultado da adição
        boolean res = pessoaDAO.add(pessoa);

        //Validação do teste
        assertTrue(res);

    }

    @Test
    public void testSearchPessoa() throws SQLException {

        //Busca por nome
        PessoaDAO pessoaDAO = new PessoaDAO();

        //Chamando método de pesquisa
        pessoaDAO.search("Teste");

        //Validação do teste
        assertEquals("Teste", pessoaDAO.nameTest);

    }

}
