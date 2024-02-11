package main;

import Controller.RedeSocial;
import Model.GerenciarUsuario;
import Model.Sessao;
import Model.Usuario;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GerenciarUsuario user = new GerenciarUsuario();
		int opcao;
		while (true) {
			opcao = RedeSocial.MenuPrincipal();
			switch (opcao) {
			case 1:
				user.criar_Usuarios();
				break;
			case 2:
				Usuario usuario_logado = Sessao.autenticar(user.getUsuarios());
				if(usuario_logado != null) {
					while (true) {
						switch (RedeSocial.MenuLogado()) {
							case 1:
								RedeSocial.postar(usuario_logado);
								break;
							case 2:
								RedeSocial.verPostagens(usuario_logado);
								break;
							case 3:
								
								break;
								
							
						}
					}
					
				}
				break;
			case 3:
				user.remover_Usuario();
				break;
			case 0:
				System.exit(0);
				break;
			default:
				break;
				
			}
		}
	}

}
