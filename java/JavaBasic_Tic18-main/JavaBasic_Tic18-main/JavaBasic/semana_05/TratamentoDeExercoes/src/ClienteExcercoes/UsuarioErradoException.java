package ClienteExcercoes;

public class UsuarioErradoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String usuario;
	
	public UsuarioErradoException(String usuario) {
		this.usuario = usuario;
	}
	
	public String getMessage() {
		return "O usuário não pode ser vazio.";
	}
}
