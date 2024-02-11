package CixaEletronicoException;

public class MutiploExeption extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	float valor;
	
	public MutiploExeption(float valor) {
		this.valor = valor;
	}
	
	public String getMessage() {
		return "O valor deve ser multiplo de 10";
	}
}
