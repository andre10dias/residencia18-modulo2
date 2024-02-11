package Exceptions;

import java.util.ArrayList;

public class ArraySizeDiferentesException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Number> a;
	private ArrayList<Number> b;
	
	public ArraySizeDiferentesException(ArrayList<Number> a, ArrayList<Number> b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public String getMessage() {
		return "Os arrays tem tamanhos diferentes. A = " + a.size() + " e B = " + b.size();
	}

}
