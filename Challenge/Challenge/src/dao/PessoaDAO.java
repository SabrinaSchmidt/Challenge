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
import model.Pessoa;

/**
 *
 * @author Sabrina
 * @since 02/2021
 * @version 1.0
 *
 */
public class PessoaDAO {

    //Variável apenas para teste
    public String nameTest;

    /**
     * Método de consulta rápida de pessoa
     */
    public void query() {
        //Consulta ao método da Classe de conexão
        Connect conexao = new Connect();
        Connection conn = conexao.getConectionMySQL();

        //Acessando e pegando valores
        try {
            String consulta = "SELECT * FROM PESSOA";

            Statement stm = conn.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);

            while (resultado.next()) {
                System.out.print(resultado.getInt("id_pessoa"));
                System.out.print(" - " + resultado.getString("NOME"));
                System.out.print(" - " + resultado.getString("sobrenome") + "\n");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            conexao.closeConec();
        }
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

        //Percorrendo consulta ao banco e mostrando em JOptionPane
        try {

            String consulta = "SELECT id_pessoa, nome, sobrenome, fk_sala, fk_espaco_cafe from pessoa where nome='" + nome + "';";
            Statement stm = conn.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);
            int i = 0;
            int j = 0;
            SalaDAO sala = new SalaDAO();
            EspacoCafeDAO ecd = new EspacoCafeDAO();

            while (resultado.next()) {
                while (!queryByController().isEmpty()) {
                    if (sala.queryByController().get(i).getId() == resultado.getInt("fk_sala")) {
                        this.nameTest = queryByController().get(i).getNome();
                        String msg = "Id: " + resultado.getInt("id_pessoa")
                                + "\nNome Completo: " + resultado.getString("NOME") + " "
                                + resultado.getString("sobrenome")
                                + "\nNome da sala: " + sala.queryByController().get(i).getNome()
                                + "\nNome do espaco de café: " + ecd.queryByController().get(j).getNome();
                        JOptionPane optionPane = new JOptionPane();
                        optionPane.setMessage(msg);
                        JDialog dialog = optionPane.createDialog(null, "Pessoa encontrada!!!");
                        dialog.setVisible(true);
                        break;

                    } else {
                        i++;
                    }
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            conexao.closeConec();
        }
    }

    /**
     * Metodo responsável pela consulta e retorno de ArrayList de pessoa(s)
     *
     * @return ArrayList de pessoa(s)
     */
    public ArrayList<Pessoa> queryByController() {
        ArrayList<Pessoa> pr = new ArrayList();

        //Consulta ao método da Classe de conexão
        Connect conexao = new Connect();
        Connection conn = conexao.getConectionMySQL();

        //Consultando e atribuindo valores
        try {
            String consulta = "SELECT * FROM PESSOA";

            Statement stm = conn.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);

            while (resultado.next()) {
                Pessoa p = new Pessoa();
                p.setId(resultado.getInt("id_pessoa"));
                p.setNome(resultado.getString("NOME"));
                p.setSobrenome(resultado.getString("sobrenome"));
                p.setIdSala(resultado.getInt("fk_sala"));
                p.setIdEspacoCafe(resultado.getInt("fk_espaco_cafe"));
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
     * Classe responsável pela consulta do maior ID inserido no banco para uma
     * nova inserção
     *
     * @throws SQLException pois chama o método query que faz consultas
     * @return int com o maior valor de ID
     */
    public int maxId() throws SQLException {
        ArrayList<Pessoa> p = new ArrayList(queryByController());
        ArrayList<Integer> maxId = new ArrayList();
        for (int i = 0; i < p.size(); i++) {
            maxId.add(p.get(i).getId());

        }

        return Collections.max(maxId);
    }

    /**
     * Classe responsável pela adição de salas, consulta o maior id
     *
     * @throws SQLException pois chama o método query que faz consultas
     * @return int com o maior valor de ID
     */
    public int addSala() throws SQLException {
        int size;
        SalaDAO sd = new SalaDAO();
        int sizeMaxId = maxId() + 1;
        int sizeSala = sd.queryByController().size();
        int id = 0;
        for (int i = 0; i < sizeSala; i++) {
            size = sizeMaxId % sizeSala;
            if (size == 0) {
                id = 1;
                break;
            } else {
                id = 2;
                break;
            }

        }
        return id;
    }

    /**
     * Classe responsável pela adição de espaços de café, consulta o maior id e
     * query..
     *
     * @throws SQLException pois chama o método query que faz consultas
     * @return int definindo que as salas não terão mais que um aluno de
     * diferença
     */
    public int addEspacoCafe() throws SQLException {
        int size;
        EspacoCafeDAO cd = new EspacoCafeDAO();
        int sizeMaxId = maxId() + 1;
        int sizeEspacoCafe = cd.queryByController().size();
        int id = 0;

        for (int i = 0; i < sizeEspacoCafe; i++) {
            size = sizeMaxId % sizeEspacoCafe;
            if (size == 0) {
                id = 1;
                break;
            } else {
                id = 2;
                break;
            }

        }
        return id;
    }

    /**
     * Classe responsável pela adição pessoas, consulta o maior id
     *
     * @throws SQLException pois chama o método query que faz consultas
     * @return boolean declarando se houve ou não sucesso na inserção
     * @param pessoa faz a atribuição através de um valor da classe
     */
    public boolean add(Pessoa pessoa) throws SQLException {
        //Consulta ao método da Classe de conexão
        Connect conexao = new Connect();
        Connection conn = conexao.getConectionMySQL();
        try {

            String insert = "iNSERT INTO pessoa (id_pessoa, nome, sobrenome, fk_sala, fk_espaco_cafe) VALUES (?, ?, ?, ?, ?);";

            PreparedStatement stmt = conn.prepareStatement(insert);

            stmt.setInt(1, maxId() + 1);
            stmt.setString(2, pessoa.getNome());
            stmt.setString(3, pessoa.getSobrenome());
            stmt.setInt(4, addSala());
            stmt.setInt(5, addEspacoCafe());

            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

}
