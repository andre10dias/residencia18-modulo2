package CixaEletronicoException;

public class SaldoInsuficienteExeption extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	float valor;
	
	public SaldoInsuficienteExeption( float valor) {
		this.valor = valor;
	}
	
	public String getMessage() {
		return "Saldo insuficiente";
	}
}
