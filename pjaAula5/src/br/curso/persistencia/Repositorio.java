package br.curso.persistencia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import br.curso.modelagem.Pessoa;

public class Repositorio {	
	File arquivo;
	public Repositorio(String url) {
		File arquivo = new File(url);
		
		if(!arquivo.exists()){
			//Criar o arquivo
			try {
				arquivo.createNewFile();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}		
		this.arquivo = arquivo;
	}
	
	public static void escrever(String url, List<Pessoa> lista)
										throws IOException{
		FileWriter escrita = new FileWriter(url);
		PrintWriter grava = new PrintWriter(escrita);
		
		for(Pessoa p : lista){
			grava.println(p);
		}
		escrita.close();
	}
}