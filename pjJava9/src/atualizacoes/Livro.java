package atualizacoes;

import java.util.*;

public class Livro {

	//Atributos
	private final String nome;
	private final String autor;
	private final List<Categoria> categorias;

	//Métodos

	public Livro(String nome, String autor, Categoria ...categorias) {
		this.nome = nome;
		this.autor = autor;
		this.categorias = List.of(categorias);
	}

	public String getAutor() {
		return autor;
	}

	public String getNome() {
		return nome;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	@Override
	public String toString() {
		return "\nLivro: " + nome
				+  "\nAutor: " + autor 
				+  "\nCategorias: " + categorias;
	}
}