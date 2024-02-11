package Exceptions;

public class ImpossivelDividirPorZeroException extends RuntimeException {
	
    private static final long serialVersionUID = 1L;
    private Number dividendo;
    

    public ImpossivelDividirPorZeroException(Number dividendo) {
        this.dividendo = dividendo;
    }

    @Override
    public String getMessage() {
        return "Impossível dividir por zero. Dividendo = " + dividendo;
    }
}
