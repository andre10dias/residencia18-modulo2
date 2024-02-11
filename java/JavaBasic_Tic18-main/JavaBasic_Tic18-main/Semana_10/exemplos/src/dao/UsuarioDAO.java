package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDAO {
	public void insertUsuario(Usuario user) throws SQLException {
		DAO dao = new DAO();
		Connection con = dao.conectar();
		String query = "INSERT INTO Usuario (Login, Senha, Email) VALUES (?, ?, ?)";
		try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
			preparedStatement.setString(1, user.getNome());
			preparedStatement.setString(2, user.getSenha());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.executeUpdate();	
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dao.closeConnection(con);
		}
	}
	
	public static void main(String[] args) {
		Usuario user = new Usuario("Jubileu", "123", "Jubileu@tutu.com");
		UsuarioDAO dao = new UsuarioDAO();
		try {
			dao.insertUsuario(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
