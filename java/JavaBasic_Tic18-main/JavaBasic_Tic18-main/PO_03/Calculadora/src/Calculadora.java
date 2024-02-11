import Exceptions.ImpossivelDividirPorZeroException;

public class Calculadora {
	public int Soma(int a, int b) {
		return a + b;
	}

	public int Subtrair(int a, int b) {
		return a - b;
	}

	public int Multiplicar(int a, int b) {
		return a * b;
	}

	public int Modulo(int a, int b) {
		return a % b;
	}

	public float Soma(float a, float b) {
		return a + b;
	}

	public float Subtrair(float a, float b) {
		return a - b;
	}

	public float Multiplicar(float a, float b) {
		return a * b;
	}

	public <T extends Number> T Dividir(T a, T b){
	    if (b.doubleValue() == 0){
	        throw new ImpossivelDividirPorZeroException(b.intValue());
	    } else {
	        if (a instanceof Float || b instanceof Float) {
	            return (T) Float.valueOf(a.floatValue() / b.floatValue());
	        } else if (a instanceof Integer || b instanceof Integer) {
	            return (T) Integer.valueOf(a.intValue() / b.intValue());
	        }else {
	        	System.out.println("Você deve informar v");
		        return null;
	        }
	    }
	}

	public float Modulo(float a, float b) {
		return a % b;
	}
}
