/**
 * 
 */
package main;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.Connect;
import dao.PessoaDAO;
import model.Pessoa;

/**
* 
* @author Sabrina
*  @since 02/2021
*  @version 1.0
*  
**/

public class principal {

	/**
	 * @param args 
	 * @throws SQLException 
	*/
	public static void main(String[] args) throws SQLException {
		
		ArrayList <Pessoa> pes = new ArrayList<Pessoa>();
		Pessoa p = new Pessoa();
		p.setNome("Sabrina");
		p.setSobrenome("Schmidt");
		
		pes.add(p);
		
		System.out.println();
		
		Connect c = new Connect();
		c.getConexaoMySQL();
                
                
                PessoaDAO pr = new PessoaDAO();
                pr.consulta();

	}

}
