package atualizacoes;

import java.util.*;
import java.util.stream.*;

public class Collectorss {

	public static void main(String[] args) {
		
		Livros.todos().forEach(System.out::println);

		//filter
		Livros.todos().stream()
		  .filter(b -> b.getCategorias().contains(Categoria.PROGRAMMING))
		  .collect(Collectors.groupingBy(Livro::getAutor));

		//Collectors.filtering
		Livros.todos().stream()
		  .collect(Collectors.groupingBy(Livro::getAutor, 
		  Collectors.filtering(
			b -> b.getCategorias().contains(Categoria.PROGRAMMING), 
		Collectors.toList())));

		//Collectors.mapping
		Livros.todos().stream()
		  .collect(Collectors.groupingBy(Livro::getAutor, 
		  Collectors.mapping(Livro::getCategorias, 
		Collectors.toList())));

		//Collectors.mapping sem duplicacao, com toSet
		Livros.todos().stream()
		  .collect(Collectors.groupingBy(Livro::getAutor, 
		  Collectors.mapping(Livro::getCategorias, 
		Collectors.toSet())));

		//Map de set de list
		Map<String,Set<List<Categoria>>> map = 
		  Livros.todos().stream()
		  .collect(Collectors.groupingBy(Livro::getAutor, 
		  Collectors.mapping(Livro::getCategorias, 
		Collectors.toSet())));

		//Collectors.flatMapping
		Livros.todos().stream()
		  .collect(Collectors.groupingBy(Livro::getAutor, 
		  Collectors.flatMapping(
			b -> b.getCategorias().stream(), 
		Collectors.toSet())));
	}
}