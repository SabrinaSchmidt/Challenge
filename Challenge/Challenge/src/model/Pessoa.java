package model;

/**
 *
 * @author Sabrina
 * @since 02/2021
 * @version 1.0
 *
 */
public class Pessoa implements IModel {

    private String sobrenome;
    private String nome;
    private int id;
    private int idSala;
    private int idEspacoCafe;

    /**
     * @return the sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * @param sobrenome the sobrenome to set
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the idSala
     */
    public int getIdSala() {
        return idSala;
    }

    /**
     * @param idSala the idSala to set
     */
    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    /**
     * @return the idEspacoCafe
     */
    public int getIdEspacoCafe() {
        return idEspacoCafe;
    }

    /**
     * @param idEspacoCafe the idEspacoCafe to set
     */
    public void setIdEspacoCafe(int idEspacoCafe) {
        this.idEspacoCafe = idEspacoCafe;
    }

    /**
     * @return String com valores da classe
     */
    @Override
    public String toString() {
        return "Pessoa{" + "sobrenome=" + sobrenome + ", nome=" + nome + ", id=" + id + ", idSala=" + idSala + ", idEspacoCafe=" + idEspacoCafe + '}';
    }

    //Construtor com parâmetros 
    public Pessoa(String sobrenome, String nome, int id, int idSala, int idEspacoCafe) {
        this.sobrenome = sobrenome;
        this.nome = nome;
        this.id = id;
        this.idSala = idSala;
        this.idEspacoCafe = idEspacoCafe;
    }

    //Construtor sem parâmetros 
    public Pessoa() {
    }

}
