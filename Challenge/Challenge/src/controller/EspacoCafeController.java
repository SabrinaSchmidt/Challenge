package controller;

import dao.EspacoCafeDAO;
import java.util.ArrayList;
import model.EspacoCafe;

/**
 *
 * @author Sabrina
 * @since 02/2021
 * @version 1.0
 *
 */
public class EspacoCafeController {

    //Variavel comum
    EspacoCafeDAO ec = new EspacoCafeDAO();

    /**
     * Metodo responsável pela consulta e retorno de ArrayList de Espacos de
     * café
     *
     * @return ArrayList de Espacos de café
     */
    public ArrayList<EspacoCafe> daoAcess() {
        return ec.queryByController();
    }

    /**
     * Metodo responsável pela consulta pelo nome
     *
     * @param nome metodo faz a consulta no bd nominal
     */
    public void search(String nome) {
        ec.search(nome);
    }
}
