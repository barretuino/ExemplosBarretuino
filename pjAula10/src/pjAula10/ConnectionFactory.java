package pjAula10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection()
						throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/pjExtensao",
				"root", "root");
		}catch(ClassNotFoundException e) {
			throw new SQLException("Não foi possível estabelecer a conexão" + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		try {
			ConnectionFactory.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
