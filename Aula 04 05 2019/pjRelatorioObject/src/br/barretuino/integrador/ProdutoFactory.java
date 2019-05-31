package br.barretuino.integrador;

import java.util.Collection;
import java.util.Vector;

public class ProdutoFactory {

	@SuppressWarnings("unchecked")
	public static Collection geraDB()
	{
		Vector vector = new Vector();
		vector.add(new Produto(1,  "Chá com Pêssego",1.7, 100) );
		vector.add(new Produto(2,"Alho Especial Aperitivo",14.59, 150) );
		vector.add(new Produto(3,"Molho à Bolonhesa",14.50, 12) );
		vector.add(new Produto(4,"Aceto Italiano Bâlsâmico",21.35, 15) );
		vector.add(new Produto(5,"Condimento à Base de Óleo para Peixe",16.20, 25) );
		vector.add(new Produto(6,"Francês Baron Darignac",31.00, 17) );
		vector.add(new Produto(7,"Molho de tomate especial",3.50, 222) );
		return vector;		
	}	
}