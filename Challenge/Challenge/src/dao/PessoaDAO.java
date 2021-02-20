/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sabrina
 */
public class PessoaDAO {
    public void consulta() {
    Connect conexao = new Connect();
    Connection conn = conexao.getConexaoMySQL();
    try {
      String consulta = "SELECT * FROM PESSOA";

      Statement stm = conn.createStatement();
      ResultSet resultado = stm.executeQuery(consulta);

      while(resultado.next()) {
        System.out.print(resultado.getInt("ID"));
        System.out.print(" - " + resultado.getString("NOME"));
        System.out.print(" - " + resultado.getString("sobrenome") + "\n");
      }
      
    } catch (SQLException ex) {
      System.out.println("Não conseguiu consultar os dados de Pessoa.");
    } finally {
      conexao.FecharConexao();
    }
  }
}
