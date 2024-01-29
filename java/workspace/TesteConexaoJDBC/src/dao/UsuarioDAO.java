package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import usuario.Usuario;

public class UsuarioDAO {
	
	public static void getUsuarioDAO() {
		List<Usuario> lista = readAll();
		for (Usuario usuario : lista) {
			System.out.println(usuario.toString());
		}
	}
	
	public static void atualizaUsuario() {
		Usuario u = readAll().get(1);
		u.setEmail("teste@teste.com");
		u.setSenha("123");
		
		if (update(u)) {
			getUsuarioDAO();
		}
	}
	
	private static List<Usuario> readAll() {
		List<Usuario> lista = new ArrayList<Usuario>();
		
		try {
			Connection conn = DAO.conectar();
			String sql = "SELECT login, email, senha FROM Usuario";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Usuario u = new Usuario(
						rs.getString("login"), 
						rs.getString("senha"),
						rs.getString("email")
				);
				
				lista.add(u);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lista;
	}
	
	private static boolean update(Usuario u) {
		try {
			Connection conn = DAO.conectar();
			String sql = "UPDATE Usuario SET (senha=?, email=?) WHERE login=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, u.getSenha());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getLogin());
			
			return ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}

}
