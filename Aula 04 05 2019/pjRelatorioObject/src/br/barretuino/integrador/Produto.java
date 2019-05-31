package br.barretuino.integrador;

public class Produto {

	private Integer id;

	private String nome;

	private Double preco;
	
	private Integer qtdEstoque;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Produto(Integer id, String nome, Double preco, Integer qtdEstoque) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.qtdEstoque = qtdEstoque;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	
	
}
