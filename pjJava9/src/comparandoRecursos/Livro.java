package comparandoRecursos;
public class Livro {
	//Atributos
	private final String nome;
	private final String autor;

	//Método Construtor
	public Livro (String nome, String autor) {
		this.nome = nome;
		this.autor = autor;
	}

	//Métodos
	public String getNome() {
		return nome;
	}

	public String getAutor() {
		return autor;
	}

	public boolean hasAuthor(String name) {
		return autor.contains(name);
	}
	
	@Override
	public String toString() {
		return "\nLivro: " + getNome()
			+  "\nAutor: " + getAutor();
	}
}