package br.santalucia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.santalucia.banco.ConexaoBD;
import br.santalucia.beans.Usuario;

public class UsuarioDAO {

	public void adicionaUsuario(Usuario u) {
		String sql = "INSERT INTO usuario(marca,modelo,ano) VALUES(?,?,?)";
		Connection con = ConexaoBD.pegaConexao();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getMarca());
			ps.setString(2, u.getModelo());
			ps.setString(3, u.getAno());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Usuario> listarUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "SELECT * FROM usuario";
		Connection con = ConexaoBD.pegaConexao();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setMarca(rs.getString("marca"));
				u.setModelo(rs.getString("modelo"));
				u.setAno(rs.getString("ano"));
				usuarios.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	
	public void excluirUsuario(int id) {
		String sql = "DELETE FROM usuario WHERE id = ?";
		Connection con = ConexaoBD.pegaConexao();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Usuario pegaUsuario(int id) {
		Connection con = ConexaoBD.pegaConexao();
		String sql = "SELECT * FROM usuario where id = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Usuario u = new Usuario();
				u.setId(id);
				u.setMarca(rs.getString("marca"));
				u.setModelo(rs.getString("modelo"));
				u.setAno(rs.getString("ano"));
				return u;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void alterarUsuario(Usuario u) {
		Connection con = ConexaoBD.pegaConexao();
		String sql = "UPDATE usuario SET nome = ?, login = ?, senha = ? where id = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getMarca());
			ps.setString(2, u.getModelo());
			ps.setString(3, u.getAno());
			ps.setInt(4, u.getId());
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//alterarUsuario
	//excluirUsuario
	
	
}
