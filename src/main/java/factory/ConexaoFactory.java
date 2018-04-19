package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	private static final String USUARIO ="root";
	private static final String SENHA = "root";
	private static final String URL = "jdbc:mysql://localhost:3306/farmacia";
	
	
	public static Connection conectar() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(URL,USUARIO,SENHA);
		return conexao;
	}

	
	//Verificar a conexão com o banco de dados
	public static void main(String[] args) {
		try {
			Connection conexao = ConexaoFactory.conectar();
			System.out.println("Conexão realizada com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro de conexão");
		}
	}
	
}
