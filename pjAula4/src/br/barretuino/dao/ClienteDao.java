package br.barretuino.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.barretuino.modelagem.Cliente;

public class ClienteDao {
	//instancia de conexão com o banco de dados
	private Connection con;
	public ClienteDao() throws SQLException {
		this.con = ConnectionFactory.getConnection();
	}
	
	//Método de Inclusão
	public void adicionar(Cliente cliente) throws SQLException {
		//Preparar a Statement para inserção
		PreparedStatement stmt = this.con.prepareStatement(
				"insert into clientes " +
				"(cpf,nome,endRua,endNum,endBairro,endCidade,"
				+ "endUF, endComplemento,sexo) values " 
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?)");
		try {
			//seta valores
			stmt.setDouble(1, cliente.getCpf());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getEndRua());
			stmt.setInt(4, cliente.getEndNum());
			stmt.setString(5, cliente.getEndBairro());
			stmt.setString(6, cliente.getEndCidade());
			stmt.setString(7, cliente.getEndUF());
			stmt.setString(8, cliente.getEndComplemento());
			stmt.setString(9, cliente.getSexo());
			
			//execução da stmt (query)
			stmt.execute();
			System.out.println("Incluído " +
						cliente.getCpf());
			stmt.close();
		}catch(SQLException e) {
			System.out.println("Erro ao Incluir " + e.getMessage());
		}
	}
	
	//Método de Alteração
	
	//Método de Exclusão
	
	//Método de Pesquisa Unitária
	
	//Método de Pesquisa em List
}
