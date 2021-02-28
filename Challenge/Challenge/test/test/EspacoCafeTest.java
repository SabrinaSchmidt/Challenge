package test;

import dao.EspacoCafeDAO;
import java.sql.SQLException;
import model.EspacoCafe;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sabrina
 * @since 02/2021
 * @version 1.0
 *
 */
public class EspacoCafeTest {

    @Test
    public void testAddEspacoCafe() throws SQLException {

        //Instancia de classe e criação de um novo elemento
        EspacoCafe ec = new EspacoCafe();
        EspacoCafeDAO ecdDAO = new EspacoCafeDAO();
        ec.setId(1);
        ec.setNome("Espaço 56");

        //Variavel booleana que recebe o resultado da adição
        boolean res = ecdDAO.add(ec);

        //Validação do teste
        assertTrue(res);

    }

    @Test
    public void testSearchEspacoCafe() throws SQLException {

        //Busca por nome
        EspacoCafeDAO ecDAO = new EspacoCafeDAO();

        //Chamando método de pesquisa
        ecDAO.search("Teste");

        //Validação do teste
        assertEquals("Teste", ecDAO.nameTest);

    }
}
