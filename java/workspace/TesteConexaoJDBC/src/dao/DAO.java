package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	
	private static final String URL = "JDBC:mysql://ulxk6mmvlglgqefb:auFekaDXaElVngMLQ6VV@bipmbrzaglwxmdvfn104-mysql.services.clever-cloud.com:3306/bipmbrzaglwxmdvfn104";
	private static final String USER = "ulxk6mmvlglgqefb";
	private static final String PASSWD = "auFekaDXaElVngMLQ6VV";
	
	public static Connection conectar() {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("Conexão realizada com sucesso.");
		} catch (SQLException e) {
			System.out.println("Erro de conexão.");
		}
		
		return con;
	}

}
