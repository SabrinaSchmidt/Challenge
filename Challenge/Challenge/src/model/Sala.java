package model;

/**
 *
 * @author Sabrina
 * @since 02/2021
 * @version 1.0
 *
 */
public class Sala {

    private String nome;
    private int id;
    private int lotacao;

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
     * @return the lotacao
     */
    public int getLotacao() {
        return lotacao;
    }

    /**
     * @param lotacao the lotacao to set
     */
    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }

    /**
     * @return String com valores da classe
     */
    @Override
    public String toString() {
        return "Sala{" + "nome=" + nome + ", id=" + id + ", lotacao=" + lotacao + '}';
    }

    //Construtor com parâmetros 
    public Sala(String nome, int id, int lotacao) {
        this.nome = nome;
        this.id = id;
        this.lotacao = lotacao;
    }

    //Construtor sem parâmetros 
    public Sala() {
    }

}
