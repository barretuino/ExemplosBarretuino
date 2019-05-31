package atualizacoes;

import java.util.*;

public class Livros {

	public static List<Livro> todos() {

		return List.of(
				new Livro("Desbravando Java", "Rodrigo Turini", Categoria.PROGRAMMING),
				new Livro("APIs Java", "Rodrigo Turini", Categoria.PROGRAMMING),
				new Livro("Certificações Java", "Guilherme Silveira", Categoria.PROGRAMMING, Categoria.CERTIFICATION),
				new Livro("TDD", "Mauricio Aniche", Categoria.PROGRAMMING, Categoria.AGILE),
				new Livro("SOLID", "Mauricio Aniche", Categoria.PROGRAMMING),
				new Livro("Guia da Startup", "Joaquim Torres", Categoria.BUSINESS)
				);
	}

	public static Optional<Livro> findSimilar(Livro livro) {
		return Livros.todos().stream()
				.filter(b -> b.getCategorias().equals(livro.getCategorias()))
				.filter(b -> !b.getAutor().equals(livro.getAutor()))
				.findAny();
	}
}