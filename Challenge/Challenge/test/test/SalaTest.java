package test;

import dao.SalaDAO;
import java.sql.SQLException;
import model.Sala;
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
public class SalaTest {

    @Test
    public void testAddSala() throws SQLException {

        //Instancia de classe e criação de um novo elemento
        Sala sala = new Sala();
        SalaDAO salaDAO = new SalaDAO();
        sala.setId(1);
        sala.setNome("Sala 34");
        sala.setLotacao(40);

        //Variavel booleana que recebe o resultado da adição
        boolean res = salaDAO.add(sala);

        //Validação do teste
        assertTrue(res);

    }

    @Test
    public void testSearchSala() throws SQLException {

        //Busca por nome
        SalaDAO salaDAO = new SalaDAO();

        //Chamando método de pesquisa
        salaDAO.search("Teste");

        //Validação do teste
        assertEquals("Teste", salaDAO.nameTest);

    }

}
