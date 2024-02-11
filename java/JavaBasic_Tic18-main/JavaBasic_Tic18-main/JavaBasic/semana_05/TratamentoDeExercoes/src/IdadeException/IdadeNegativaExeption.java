package IdadeException;

public class IdadeNegativaExeption extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int idade;
	
	public void IdadeExeption(int idade) {
		this.idade = idade;
	}
	
	public String getMessage() {
		return "Idade não pode ser negativa";
	}

}
