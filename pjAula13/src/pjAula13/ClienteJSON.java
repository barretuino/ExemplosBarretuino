package pjAula13;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

/**
 * Dependências de Lib: gson-2.6.2
 * @author Prof. Paulo Barreto
 * @date 18/05/2019
 */

public class ClienteJSON {
	public static void main(String[] args) {
		Cliente isaac = new Cliente();
		Cliente luiz = new Cliente();
		
		isaac.setCodigo(123456);
		isaac.setNome("Isaac Evangelista");
		
		luiz.setCodigo(789456);
		luiz.setNome("Luiz Casteliano");
		
		//Instanciando um objeto da classe gson
		Gson gson = new Gson();
		
		/**
		 * let jsonCliente = {
		 * 		codigo: isaac.getCodigo(),
		 * 		nome: isaac.getNome()
		 * };
		 */
		//String json por meio da geração do gson.toJson()
		String jsonString = gson.toJson(isaac);
		
		System.out.println(jsonString);
		
		//Visualizando as propriedades
		Field field[] = Cliente.class.getDeclaredFields();
		
		for(Field f : field) {
			System.out.println(f);
		}
		
		//Recebendo o JSON e transformando novamente em objeto
		Cliente recebido = gson.fromJson(jsonString, Cliente.class);
		
		System.out.println(recebido.getCodigo()  + " " 
				+ recebido.getNome());
		
		//Criando uma lista de JSON: lista de clientes
		List<Cliente> lista = new ArrayList<Cliente>();
		lista.add(isaac);
		lista.add(luiz);
		
		String listaJSON = gson.toJson(lista);
		System.out.println(listaJSON);
		
		List<Cliente> retornoLista = new ArrayList<Cliente>();
		
		//String manual com dados de um possível Cliente
		String marcelo =
			"{\"codigo\":\"456\",\"nome\":\"Marcelo Tchelo\","
			+ "\"altura\":1.95\"}";
		
		Cliente outroCliente = gson.fromJson(marcelo, Cliente.class);
		System.out.println("JSON -> " + marcelo);
		System.out.println(outroCliente.getCodigo() + " "
				+ outroCliente.getNome());
		
		//Quero saber quantas propriedades há no JSON
	}	
}