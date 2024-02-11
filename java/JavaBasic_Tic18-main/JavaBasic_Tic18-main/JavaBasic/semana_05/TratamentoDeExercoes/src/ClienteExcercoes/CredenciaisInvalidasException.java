package ClienteExcercoes;

public class CredenciaisInvalidasException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CredenciaisInvalidasException() {
		
	}
	
	public CredenciaisInvalidasException(String message) {
		super(message);
	}
	
	public String getMessage() {
		return "Credenciais inválidas.";
	}
	
}
