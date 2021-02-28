
package controller;

import dao.SalaDAO;
import java.util.ArrayList;
import model.Sala;

/**
 *
 * @author Sabrina
 * @since 02/2021
 * @version 1.0
 *
 */
public class SalaController {
    //Variavel comum
    SalaDAO sala = new SalaDAO();

     /**
     * Metodo responsável pela consulta e retorno de ArrayList de salas
     *
     * @return ArrayList de sala(s)
     */
    public ArrayList<Sala> daoAcess() {
        return sala.queryByController();
    }

     /**
     * Metodo responsável pela consulta pelo nome
     *
     * @param nome metodo faz a consulta no bd nominal
     */
    public void search(String nome) {
        sala.search(nome);
    }
     
   
    
}
