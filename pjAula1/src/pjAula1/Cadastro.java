package pjAula1;

import java.util.Scanner;

/**
 * Classe de Cadastro de Produtos
 * @author Paulo Barreto
 * @date 27/10/2018
 */
public class Cadastro {
	//Atributos
	int n = 3;
	Produto produtos[] = new Produto[n];
	Scanner digito = new Scanner(System.in);
	
	public void inserir () {
		for(int i=0; i<n; i++) {
			Produto temp = new Produto();
			
			System.out.println("Informe o código: ");
			temp.setCodigo(digito.nextInt());
			
			System.out.println("Informe a descrição: ");
			temp.setDescricao(digito.next());
			
			System.out.println("Informe o valor: ");
			temp.setValor(digito.nextFloat());
			
			System.out.println("Para status [1 - T | 2 - F]");
			temp.setStatus(digito.nextInt() == 1 ? true : false);
			
			produtos[i] = temp;
		}			
	}
	
	public void ler() {
		for(int i=0; i<n; i++) {
			System.out.println(produtos[i].toString());
		}
	}
	
	public static void main(String[] args) {
		Cadastro cad = new Cadastro();
		cad.inserir();
		cad.ler();
		
	}
}
