package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {
	
	static final String DRIVER = "com.mysql.jdbc.Driver";
	static final String URL = "jdbc:mysql://ulvqicajnzf0m3xa:VorBiomqmPV9HiQgpYFb@biahyo39abtiorvkxjeq-mysql.services.clever-cloud.com:3306/biahyo39abtiorvkxjeq?autoReconnect=true&useSSL=false";
	static final String USER = "ulvqicajnzf0m3xa";
	static final String PASSWORD = "VorBiomqmPV9HiQgpYFb";
	
	public Connection conectar() {
		Connection con = null;
		try {
			
			con = DriverManager.getConnection(URL);
			System.out.println("Conexão Feita com Sucesso !!!! ");
		} catch (SQLException ex) {
			throw new RuntimeException("Erro na conexão com o Banco de dados: ", ex);
		}
		return con;
	}
	
	public void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
				System.out.println("Conexão fechada !!!");
			}
		} catch (SQLException ex) {
			Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void testeConnexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			closeConnection(con);
		} catch (Exception e) {
			System.out.println("Jubileu: " + e);
		}

	}
	
	public static void main(String[] args) {
		DAO dao = new DAO();
		dao.testeConnexao();
		
	}
}
