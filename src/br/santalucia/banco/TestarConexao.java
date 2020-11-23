package br.santalucia.banco;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.PreparableStatement;

/**
 * Servlet implementation class TestarConexao
 */
@WebServlet("/testarConexao")
public class TestarConexao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestarConexao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			Connection con = ConexaoBD.pegaConexao();
			String sql = "INSERT INTO usuario (marca, modelo, ano) values (?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "Honda");
			ps.setString(2, "Shadow");
			ps.setString(3, "2004");
			ps.execute();
			
			System.out.println(con.isClosed());
			
		} catch(SQLException e) {
			System.out.println("SQL: " + e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
