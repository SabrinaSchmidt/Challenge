package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import model.EspacoCafe;

/**
 *
 * @author Sabrina
 * @since 02/2021
 * @version 1.0
 *
 */
public class EspacoCafeDAO {

    //Variável apenas para teste
    public String nameTest;

    /**
     *
     * @deprecated
     * Metodo não utilizado. Método de consulta rápida
     */
    public void query() {
        Connect conexao = new Connect();
        Connection conn = conexao.getConectionMySQL();

        try {
            String consulta = "SELECT * FROM ESPACO_CAFE";

            Statement stm = conn.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);

            while (resultado.next()) {
                System.out.print(resultado.getInt("idespaco_cafe"));
                System.out.print(" - " + resultado.getString("NOME"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            conexao.closeConec();
        }
    }

    /**
     *
     * @param nome
     * @param oldId
     * @throws java.sql.SQLException
     * @deprecated Metodo não utilizado, faria consultas.
     */
    public void update(String nome, int oldId) throws SQLException {
        Connect conexao = new Connect();
        Connection conn = conexao.getConectionMySQL();

        String sql = "UPDATE espaco_cafe SET nome = ? WHERE idespaco_cafe = " + oldId + ";";
        System.out.println("\n");
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nome);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Alterado com sucesso!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            conexao.closeConec();
        }

    }

    /**
     * Metodo responsável pela consulta e retorno de ArrayList de espaco(s) de
     * cafe
     *
     * @return ArrayList de espaco(s) de cafe
     */
    public ArrayList<EspacoCafe> queryByController() {
        ArrayList<EspacoCafe> pr = new ArrayList();

        //Consulta ao método da Classe de conexão
        Connect conexao = new Connect();
        Connection conn = conexao.getConectionMySQL();

        //Consultando e atribuindo valores
        try {
            String consulta = "SELECT * FROM ESPACO_CAFE";
            Statement stm = conn.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);

            while (resultado.next()) {
                EspacoCafe p = new EspacoCafe();
                p.setId(resultado.getInt("idespaco_cafe"));
                p.setNome(resultado.getString("NOME"));
                pr.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            conexao.closeConec();
        }
        return pr;
    }

    /**
     * Classe responsável pela consulta por nome
     *
     * @param nome Pois o método faz a busca nominal
     */
    public void search(String nome) {
        //Consulta ao método da Classe de conexão
        Connect conexao = new Connect();
        Connection conn = conexao.getConectionMySQL();

        int i = 1, j = 0;
        PessoaDAO pd = new PessoaDAO();

        while (queryByController().size() > j) {
            if (queryByController().get(j).getNome().equalsIgnoreCase(nome)) {
                j = queryByController().get(j).getId();
                break;
            } else {
                j++;
            }
        }

        try {
            String consulta = "SELECT id_pessoa, nome,sobrenome, fk_espaco_cafe from pessoa where fk_espaco_cafe=" + j + ";";
            Statement stm = conn.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);

            //Percorre o resultado da consulta e mostra os dados em um JOptionPane
            while (resultado.next()) {

                while (!pd.queryByController().isEmpty()) {
                    this.nameTest = queryByController().get(i).getNome();
                    String msg = "Id: " + resultado.getInt("id_pessoa")
                            + "\nNome Completo: " + resultado.getString("NOME") + " "
                            + resultado.getString("sobrenome")
                            + "\nNome da sala: " + queryByController().get(i).getNome()
                            + "\nNome do espaco de café: " + queryByController().get(i).getNome();;
                    JOptionPane optionPane = new JOptionPane();
                    optionPane.setMessage(msg);
                    JDialog dialog = optionPane.createDialog(null, "Pessoa encontrada!!!");
                    dialog.setVisible(true);
                    break;
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            conexao.closeConec();
        }

    }

    /**
     * Classe responsável pela consulta do maior ID inserido no banco para uma
     * nova inserção
     *
     * @throws SQLException pois chama o método query que faz consultas
     * @return int com o maior valor de ID
     */
    public int maxId() throws SQLException {
        ArrayList<EspacoCafe> sala = new ArrayList(queryByController());
        ArrayList<Integer> maxId = new ArrayList();
        for (int i = 0; i < sala.size(); i++) {
            maxId.add(sala.get(i).getId());

        }

        return Collections.max(maxId) + 1;
    }

    /**
     * Classe responsável pela adição Espaços de cafe, consulta o maior id
     *
     * @throws SQLException pois chama o método query que faz consultas
     * @return boolean confirmando ou não a adição
     * @param ec passa a vrvl espaco cafe
     */
    public boolean add(EspacoCafe ec) throws SQLException {
        //Consulta ao método da Classe de conexão
        Connect conexao = new Connect();
        Connection conn = conexao.getConectionMySQL();

        try {

            String insert = "INSERT INTO espaco_Cafe (idespaco_cafe, nome) VALUES (?, ?);";

            PreparedStatement stmt = conn.prepareStatement(insert);

            stmt.setInt(1, maxId());
            stmt.setString(2, ec.getNome());

            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
