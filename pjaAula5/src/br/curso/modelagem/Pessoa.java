package br.curso.modelagem;
public class Pessoa {
	//Atributos
	public static int sequencia = 1;
	
	private int codigo;
	private Endereco endereco;
	private String nome;
	private SituacaoCadastral situacaoCadastral;
	private Float peso;
	
	//Métodos Getters and Setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public SituacaoCadastral getSituacaoCadastral() {
		return situacaoCadastral;
	}
	public void setSituacaoCadastral(SituacaoCadastral situacaoCadastral) {
		this.situacaoCadastral = situacaoCadastral;
	}
	public Float getPeso() {
		return peso;
	}
	public void setPeso(Float peso) {
		this.peso = peso;
	}
	
	@Override
	public String toString() {	
		return getCodigo() + ";" + getNome() + ";"
				+ getEndereco() + ";" 
				+ getSituacaoCadastral().getDescricao() + ";"
				+ getPeso();
	}
}