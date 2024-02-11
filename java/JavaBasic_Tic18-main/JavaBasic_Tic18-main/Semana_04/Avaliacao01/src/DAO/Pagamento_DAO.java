package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MODEL.Pagamento;

public class Pagamento_DAO {
	private DAO dao = new DAO();
	
	// Método para inserir um novo pagamento
    public void inserirPagamento(Pagamento pagamento) {
        Connection con = dao.conectar();
        String query = "INSERT INTO Pagamento (data, id_imovel, valor) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setDate(1, new java.sql.Date(pagamento.getData().getTime()));
            preparedStatement.setInt(2, pagamento.getId());
            preparedStatement.setDouble(3, pagamento.getValor());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.closeConnection(con);
        }
    }

    // Método para atualizar um pagamento existente
    public void atualizarPagamento(Pagamento pagamento) {
        Connection con = dao.conectar();
        String query = "UPDATE Pagamento SET data = ?, id_imovel = ?, valor = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setDate(1, new java.sql.Date(pagamento.getData().getTime()));
            preparedStatement.setInt(2, pagamento.getId());
            preparedStatement.setDouble(3, pagamento.getValor());
            preparedStatement.setInt(4, pagamento.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.closeConnection(con);
        }
    }

    // Método para excluir um pagamento
    public void excluirPagamento(int id) {
        Connection con = dao.conectar();
        String query = "DELETE FROM Pagamento WHERE id = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.closeConnection(con);
        }
    }

    // Método para obter um pagamento por ID
    public Pagamento obterPagamentoPorId(int id) {
        Connection con = dao.conectar();
        Pagamento pagamento = null;
        String query = "SELECT * FROM Pagamento WHERE id = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                pagamento = new Pagamento();
                pagamento.setId(resultSet.getInt("id"));
                pagamento.setData(resultSet.getDate("data"));
                pagamento.setId(resultSet.getInt("id_imovel"));
                pagamento.setValor(resultSet.getDouble("valor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.closeConnection(con);
        }

        return pagamento;
    }

    // Método para obter todos os pagamentos
    public List<Pagamento> obterTodosPagamentos() {
        Connection con = dao.conectar();
        List<Pagamento> pagamentos = new ArrayList<>();
        String query = "SELECT * FROM Pagamento";

        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Pagamento pagamento = new Pagamento();
                pagamento.setId(resultSet.getInt("id"));
                pagamento.setData(resultSet.getDate("data"));
                pagamento.setId(resultSet.getInt("id_imovel"));
                pagamento.setValor(resultSet.getDouble("valor"));
                pagamentos.add(pagamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.closeConnection(con);
        }

        return pagamentos;
    }
}
