package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Empregado;

public class EmpregadoDAO {
	
	public void insertUsuario(Empregado emp) throws SQLException {
		DAO dao = new DAO();
		Connection con = dao.conectar();
		String query = "INSERT INTO Empregado (CPF, Nome, Salario, Genero) VALUES (?, ?, ?, ?)";
		try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
			preparedStatement.setString(1, emp.getCpf());
			preparedStatement.setString(2, emp.getNome());
			preparedStatement.setDouble(3, emp.getSalario());
			preparedStatement.setString(4, emp.getGenero());
			preparedStatement.executeUpdate();	
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dao.closeConnection(con);
		}
	}
	
	public static void main(String[] args) {
		EmpregadoDAO dao = new EmpregadoDAO();
		Empregado emp = new Empregado("Jubileu", "546987457", 620300, "M");
		Empregado emp2 = new Empregado("ana", "466987457", 612200, "F");
		Empregado emp3 = new Empregado("João", "316586458", 402600, "M");
		Empregado emp4 = new Empregado("Maria", "226586456", 684600, "F");
		Empregado emp5 = new Empregado("Pedro", "136586457", 478200, "M");
		Empregado emp6 = new Empregado("Paulo", "94658645", 595600, "M");
		Empregado emp7 = new Empregado("Sui", "756586459", 220800, "F");
		
		try {
			dao.insertUsuario(emp);
			dao.insertUsuario(emp2);
			dao.insertUsuario(emp3);
			dao.insertUsuario(emp4);
			dao.insertUsuario(emp5);
			dao.insertUsuario(emp6);
			dao.insertUsuario(emp7);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
