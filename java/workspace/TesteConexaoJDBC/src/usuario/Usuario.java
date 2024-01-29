package usuario;

public class Usuario {
	
	private String login;
	private String senha;
	private String email;
	
	public Usuario(String login, String senha, String email) {
		this.login = login;
		this.senha = senha;
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [login=" + login + ", senha=" + senha + ", email=" + email + "]";
	}

}
