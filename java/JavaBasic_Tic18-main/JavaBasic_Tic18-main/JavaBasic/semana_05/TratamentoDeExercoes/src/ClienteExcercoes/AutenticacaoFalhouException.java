package ClienteExcercoes;

public class AutenticacaoFalhouException extends RuntimeException{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String senha;
	 
	 public AutenticacaoFalhouException(String senha) {
		 this.senha = senha;
	 }
	 
	 public String getMessage() {
		 return "A senha não está correta.";
	 }
}
