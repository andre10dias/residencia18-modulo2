package Model;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class Sessao {
	Date data_Inicial;
	Date data_Final;

	public Sessao() {
		this.data_Inicial = new Date();
	}

	public Date getData_Inicial() {
		return data_Inicial;
	}

	public Date getData_Final() {
		return data_Final;
	}

	public void setData_Final() {
		this.data_Final = new Date();
	}
	

	public static Usuario autenticar(ArrayList<Usuario> usuarios) {
		try {
			String nome = JOptionPane.showInputDialog("Nome:");
			String senha = JOptionPane.showInputDialog("Senha:");

			for (Usuario u : usuarios) {
				if (u.getNome_Usuario().equals(nome) && u.getSenha().equals(senha)) {
					u.addSessoes(logar());
					return u;
				}
			}
		} catch (Exception e) {
			System.out.println("Erro ao tentar logar: " + e.getMessage());
		}
		return null;
	}
	public static Sessao logar() {
		Sessao sessao = new Sessao();
		return sessao;
	}
	public static void deslogar(Sessao sessao) {
		sessao.setData_Final();
	}

}
