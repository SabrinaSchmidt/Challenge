/**
 *Classe que faz a conexão com o Banco
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sabrina
 * @since 02/2021
 * @version 1.0
 *
 */
public class Connect {

    public String status = "Não conectou...";

    //Construtor sem parâmetros
    public Connect() {
    }

    //Método de Conexão
    public Connection getConectionMySQL() {

        //atributo do tipo Connection
        Connection connection = null;

        try {
            // Carregando o JDBC Driver padrão
            String driverName = "com.mysql.cj.jdbc.Driver";

            Class.forName(driverName);

            // Configurando a conexão com um banco de dados
            String url = "jdbc:mysql://localhost:3306/challenge";
            //usuario e senha
            String username = "root";
            String password = "root";

            connection = DriverManager.getConnection(url, username, password);

            //Testa a conexão
            if (connection != null) {
                status = "STATUS : Conectado com sucesso!";
            } else {
                status = "STATUS : Não foi possivel realizar conexão";
            }

            return connection;

        } catch (ClassNotFoundException | SQLException e) {
            //Driver não encontrado
            System.out.println(e.getMessage());
            return null;
        }
    }

    //Método que retorna o status da conexão
    public String statusConec() {
        return status;
    }

    //Método que fecha a conexão
    public boolean closeConec() {

        try {
            getConectionMySQL().close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //Método que reinicia a conexão
    public java.sql.Connection rebootConec() {
        closeConec();
        return getConectionMySQL();
    }

}
