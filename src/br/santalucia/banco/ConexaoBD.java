package br.santalucia.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

	static Connection con = null;
	static String user = "root";
	static String pass = "root";
	static String url = "jdbc:mysql://localhost:3306/moto?useTimezone=true&serverTimezone=UTC";
	
	public static Connection pegaConexao() {
		try {
			if(con == null) {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, pass);
			}
			return con;
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(SQLException e) {
			System.out.println("SQL: " + e.getMessage());
		}
		
		return con;
	}
}
