package comparandoRecursos;
import java.time.LocalDateTime;
import java.util.*;

public class Snippets {

	public static void main(String[] args) {

		//Voltando Datas com Calendar
		Calendar ontem = Calendar.getInstance();
		ontem.add(Calendar.DATE, -1);
		System.out.println("Ontem: " + ontem);

		System.out.println("Ontem: " + LocalDateTime.now().minusDays(1));

		//Exemplo de Filter do Optional
		Optional<String> autor = Optional.ofNullable("Rodrigo Turini, Paulo Silveira");

		boolean contemAutor = autor
				.filter(s -> s.contains("Turini"))
				.isPresent();

		System.out.println(contemAutor);
	}
}
