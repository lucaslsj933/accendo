package dbTools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public ConnectionFactory() {
		try {
			//Carrega o driver especificado
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver não encontrado!"+e);
		}
	}
	
	public static Connection createConnection() throws SQLException {
		String url="jdbc:mysql://localhost:3306/accendoDBNEW"; //Nome do DB
		String user="root";
		String password="12345";
		
		Connection conexao=null;
		conexao=DriverManager.getConnection(url,user,password);
		return conexao;
	}
}
