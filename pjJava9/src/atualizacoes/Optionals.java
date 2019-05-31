package atualizacoes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Optionals {

	public static void main(String[] args) {
		
		Livro book = new Livro(
					"Desbravando Java", 
					"Rodrigo Turini", 
					Categoria.PROGRAMMING
				);
		
		Optional<Livro> similar = Livros.findSimilar(book);

		if (similar.isPresent()) {
			System.out.println(similar);
		} else {
			System.out.println("N�o existem similares");
		}

		//ifPresent
		Livros.findSimilar(book)
			.ifPresent(System.out::println);

		//ifPresentOrElse
		Livros.findSimilar(book)
		.ifPresentOrElse(
			System.out::println,
			() -> System.out.println("Não existem similares")
		);

		List<Livro> books = List.of(
			new Livro(
				"Desbravando Java", 
				"Rodrigo Turini", 
				Categoria.PROGRAMMING
			),
			new Livro(
				"Java 8 Prático", 
				"Paulo Silveira", 
				Categoria.PROGRAMMING
			),
			new Livro(
				"SOLID", 
				"Mauricio Aniche", 
				Categoria.PROGRAMMING
			),
			new Livro(
				"Guia da Startup", 
				"Joaquim Torres", 
				Categoria.BUSINESS
			)
		);

		// map
		List<Optional<Livro>> similars = 
		books.stream()
			.map(Livros::findSimilar)
			.collect(Collectors.toList());

		// map e filter
		List<Livro> similars2 = 
		books.stream()
			.map(Livros::findSimilar)
			.filter(Optional::isPresent)
			.map(Optional::get)
			.collect(Collectors.toList());

		// map e flatMap
		List<Livro> similars3 = 
		books.stream()
			.map(Livros::findSimilar)
			.flatMap(Optional::stream)
			.collect(Collectors.toList());

		// flatMap direto
		List<Livro> similars4 = 
		books.stream()
			.flatMap(b -> Livros.findSimilar(b).stream())
			.collect(Collectors.toList());

		// encadeando ORs
		Livros.findSimilar(book)
			.or(() -> Livros.findSimilar(book)) // 2
			.or(() -> Livros.findSimilar(book)); // 3
	}
}