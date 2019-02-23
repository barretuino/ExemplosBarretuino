import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.List;

public class TesteStream {
	public static void main(String[] args) {

		//List de entidades Livro 
		List<Livro> lista = new ArrayList<>();

		lista.add(new Livro("Desbravando Java", "Rodrigo Turini"));
		lista.add(new Livro("Java Como Programar", "Deitel & Deitel"));
		lista.add(new Livro("Livro de Java", "Paulo Silveira"));
		lista.add(new Livro("TDD", "Mauricio Aniche"));
		lista.add(new Livro("Certificação Java", "Guilherme Silveira"));
		lista.add(new Livro("APIs Java", "Rodrigo Turini"));
		lista.add(new Livro("Java 8 Prático", "Rodrigo Turini, Paulo Silveira"));

		//Otimizando o Filtro, a Ordenação e o Looping
		lista.stream()
			.filter(book -> book.hasAuthor("Rodrigo Turini"))
			.sorted(comparing(Livro::getNome))
			.forEach(System.out::println);
	}
}