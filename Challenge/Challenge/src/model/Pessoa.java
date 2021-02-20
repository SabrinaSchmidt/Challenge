package model;

/**
* 
* @author Sabrina
*  @since 02/2021
*  @version 1.0
*  
**/

public class Pessoa implements IModel{

	private String sobrenome;
	private String nome;
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
	@Override
	public String toString() {
		return "Pessoa [sobrenome=" + sobrenome + ", nome=" + nome + "]";
	}
	
	
}
