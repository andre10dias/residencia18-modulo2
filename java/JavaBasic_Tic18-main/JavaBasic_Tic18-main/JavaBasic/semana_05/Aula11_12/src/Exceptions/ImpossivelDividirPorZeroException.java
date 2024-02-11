package Exceptions;

public class ImpossivelDividirPorZeroException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int dividendo;

    public ImpossivelDividirPorZeroException(int dividendo) {
        this.dividendo = dividendo;
    }

    public String getMessage() {
	    return "Impossivel dividir por zero. Dividendo = " + dividendo;
    }
}

