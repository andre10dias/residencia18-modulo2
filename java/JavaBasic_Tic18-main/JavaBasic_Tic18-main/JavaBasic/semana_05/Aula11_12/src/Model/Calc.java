package Model;

import Exceptions.ImpossivelDividirPorZeroException;

public class Calc {
	
	public static Float Soma(Float a, Float b) {
		return a + b;
	}
	
	public static int Soma(int a, int b) {
		return a + b;
	}
	
	public static float Subitrai(float a, float b) {
		return a - b;
	}
	
	public static int Subitrai(int a, int b) {
		return a - b;
	}
	
	public static float Produto(float a, float b) {
		return a * b;
	}
	
	public static int Produto(int a, int b) {
		return a * b;
	}
	
	public static <T extends Number> T dividir(T a, T b) throws ImpossivelDividirPorZeroException {
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

	public static int Modulo(int a, int b) {
		return a % b;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(dividir(10.5f, 2.5f));
		} catch (ImpossivelDividirPorZeroException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
