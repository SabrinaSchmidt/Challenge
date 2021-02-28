package model;

/**
 *
 * @author Sabrina
 * @since 02/2021
 * @version 1.0
 *
 */
public class EspacoCafe {

    private int id;
    private String nome;

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
     * @return String com valores da classe
     */
    @Override
    public String toString() {
        return "EspacoCafe{" + "id=" + id + ", nome=" + nome + '}';
    }

    //Construtor com parâmetros 
    public EspacoCafe(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    //Construtor sem parâmetros 
    public EspacoCafe() {
    }

}
