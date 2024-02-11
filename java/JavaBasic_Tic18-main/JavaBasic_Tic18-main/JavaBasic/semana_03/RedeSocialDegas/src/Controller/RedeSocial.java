package Controller;

import javax.swing.JOptionPane;

import Model.GerenciarUsuario;
import Model.Postagem;
import Model.Usuario;

public class RedeSocial {
	
	public static void postar(Usuario usuario) {
		String texto = JOptionPane.showInputDialog("######### Crie sua Postagem ########\nTexto:");
		usuario.addPostagens(new Postagem(usuario, texto));
	}
	public static void verPostagens(Usuario usuario) {
		
		for (Postagem p : usuario.getPostagens()) {
			javax.swing.JOptionPane.showMessageDialog(null, p.toString());
		}
	}
	
	public static void criarAmizade(GerenciarUsuario user, Usuario usuario) {
		String nome = JOptionPane.showInputDialog("Nome do usuario que deseja amizade:");
		for (Usuario u : user.getUsuarios()) {
			if (u.getNome_Usuario().equals(nome)){
				RedeSocial.criar_Amizade(u, usuario);
			}
			
		}
	}
	
	public static int MenuPrincipal() {
		int opcao;
		try {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("############ Menu Principal ############\n"
					+ "1 - Criar Conta\n"
					+ "2 - Logar\n"
					+ "3 - Remover Conta\n"
					+ "0 - Sair"));
			return opcao;
		} catch (Exception e) {
			opcao = MenuPrincipal();
		}
		return -1;
	}
	public static int MenuLogado() {
		int opcao;
		try {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("############ Menu Logado ############\n"
					+ "1 - Postar\n"
					+ "2 - Ver Postagens\n"
					+ "3 - Criar Amizade\n"
					+ "4 - Ver Amizades\n"
					+ "5 - Remover Amizade\n"
					+ "0 - Deslogar\n"
					));
			return opcao;
		}catch (Exception e) {
			opcao = MenuLogado();
		}
		return -1;
	}
}
