package Model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GerenciarUsuario {
	ArrayList<Usuario> usuarios = new ArrayList<>();

	public GerenciarUsuario() {

	}
	

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public Boolean criar_Amizade(Usuario user1, Usuario user2) {
		if(user1.getAmigos().contains(user2)) {
			return false;
		}else if(user2.equals(user1)) {
			return false;
		}
		user2.getAmigos().add(user1);
		user1.getAmigos().add(user2);
		return true;
	}


	public Usuario criar_Usuarios() {

		try {

			String nome = JOptionPane.showInputDialog("######### Criar Usuário #########\nNome:");
			String email = JOptionPane.showInputDialog("Email:");
			String senha = JOptionPane.showInputDialog("Senha:");

			for (Usuario u : usuarios) {
				if (u.getNome_Usuario().equals(nome) || u.getEmail().equals(email)) {
					javax.swing.JOptionPane.showMessageDialog(null, "Nome ou Email já existente.");
					return null;
				}
			}

			Usuario user = new Usuario(nome, email, senha);
			usuarios.add(user);
			javax.swing.JOptionPane.showMessageDialog(null, "Conta criada com sucesso !!!");
			
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	public void remover_Usuario() {
		String nome = JOptionPane.showInputDialog("Nome:");
		String senha = JOptionPane.showInputDialog("Senha:");
		for (Usuario u : usuarios) {
			if (u.getNome_Usuario().equals(nome) && u.getSenha().equals(senha)) {
				usuarios.remove(u);
			}
		}
	}
}
