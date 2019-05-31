package comparandoRecursos;
import java.util.*;

public class Java7 {

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

		//List de entidades filtradas de Livro
		List<Livro> filtroLivro = new ArrayList<>();

		//Looping sob a Lista de Livros para aplicar Filtro
		for (Livro livro: lista) {
			if (livro.hasAuthor("Rodrigo Turini")) {
				filtroLivro.add(livro);
			}
		}

		//Ordenação da Lista de Livros
		Collections.sort(filtroLivro, new Comparator<Livro>() {
			public int compare(Livro b1, Livro b2) {
				return b1.getNome().compareTo(b2.getNome());
			}
		});

		//Looping sob a Lista de Livros
		for (Livro livro: filtroLivro) {
			System.out.println(livro);
		}
	}
}