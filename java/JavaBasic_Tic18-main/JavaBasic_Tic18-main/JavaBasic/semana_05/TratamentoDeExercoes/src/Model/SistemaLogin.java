package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ClienteExcercoes.AutenticacaoFalhouException;
import ClienteExcercoes.CredenciaisInvalidasException;
import ClienteExcercoes.UsuarioBloqueadoException;
import ClienteExcercoes.UsuarioErradoException;

public class SistemaLogin {

    private List<Cliente> usuarios;
    private int tentativasAutenticacao;

    public SistemaLogin() {
        this.usuarios = new ArrayList<>();
        this.tentativasAutenticacao = 3;
    }

    public void cadastrarUsuario(String nomeUsuario, String senha) throws CredenciaisInvalidasException {
        if (nomeUsuario.isEmpty()) {
            throw new CredenciaisInvalidasException();
        } else if (senha.length() < 6) {
            throw new CredenciaisInvalidasException();
        } else {
            this.usuarios.add(new Cliente(nomeUsuario,new Date(), senha));
        }
    }

    public void login(String nomeUsuario, String senha) throws UsuarioErradoException, AutenticacaoFalhouException, UsuarioBloqueadoException {
        if (nomeUsuario.isEmpty()) {
            throw new UsuarioErradoException(nomeUsuario);
        }

        Cliente usuario = this.usuarios.stream().filter(u -> u.getNome().equals(nomeUsuario)).findFirst().orElse(null);
        if (usuario == null) {
            throw new UsuarioErradoException(nomeUsuario);
        } else if (senha.length() < 6) {
            throw new AutenticacaoFalhouException(senha);
        } else if (!usuario.getSenha().equals(senha)) {
            this.tentativasAutenticacao++;
            if (this.tentativasAutenticacao >= 3) {
                usuario.setBloqueado(true);
                throw new UsuarioBloqueadoException();
            } else {
                throw new AutenticacaoFalhouException(senha);
            }
        } else {
            this.tentativasAutenticacao = 0;
        }
    }
    
    public static void main(String[] args) {
		SistemaLogin sistemaLogin = new SistemaLogin();
		
		sistemaLogin.cadastrarUsuario("Joaquim", "123456");
		sistemaLogin.cadastrarUsuario("admin", "1234567");
		
		try {
			sistemaLogin.login("Joaquim", "123456");
			System.out.println("Login efetuado com sucesso.");
		} catch (UsuarioErradoException | AutenticacaoFalhouException | UsuarioBloqueadoException e) {
			System.out.println(e.getMessage());
		}
	}
}

