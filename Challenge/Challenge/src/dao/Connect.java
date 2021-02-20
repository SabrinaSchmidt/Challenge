/**
 *
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Sabrina
 *
 */
public class Connect {

    public  String status = "Não conectou...";

    public Connect() {
    }

//Método de Conexão//
    public  Connection getConexaoMySQL() {

        Connection connection = null;          //atributo do tipo Connection

        try {

// Carregando o JDBC Driver padrão
            String driverName = "com.mysql.cj.jdbc.Driver";

            Class.forName(driverName);

// Configurando a nossa conexão com um banco de dados//
            String url = "jdbc:mysql://" + "localhost:3306" + "/" + "challenge";
            String username = "root";        //nome de um usuário de seu BD
            String password = "root";      //sua senha de acesso

            connection = DriverManager.getConnection(url, username, password);

            //Testa sua conexão//
            if (connection != null) {
                status = "STATUS--->Conectado com sucesso!";
            } else {
                status = "STATUS--->Não foi possivel realizar conexão";
            }

            return connection;

        } catch (ClassNotFoundException e) {  //Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {

           //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");

            return null;
        }

    }

    //Método que retorna o status da sua conexão//
    public  String statusConection() {
        return status;
    }

    //Método que fecha sua conexão//
    public  boolean FecharConexao() {

        try {
            getConexaoMySQL().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    //Método que reinicia sua conexão//
    public  java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return getConexaoMySQL();
    }


}
