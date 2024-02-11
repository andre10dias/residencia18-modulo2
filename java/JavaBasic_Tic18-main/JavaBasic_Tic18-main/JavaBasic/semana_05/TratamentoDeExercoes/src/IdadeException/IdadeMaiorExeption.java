package IdadeException;

public class IdadeMaiorExeption extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int idade;
	
	public IdadeMaiorExeption(int idade) {
		super();
		this.idade = idade;
	}
	
	public String getMessage() {
		return "Idade não pode ser maior que 150";
	}
}
