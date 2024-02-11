package Exceptions;

import java.util.ArrayList;

public class IncompativelTipoListException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Number> a;
	private ArrayList<Number> b;
	
	public IncompativelTipoListException(ArrayList<Number> a, ArrayList<Number> b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public String getMessage() {
		return "Os arrays tem tipos de dados diferentes. A = " + (a instanceof ArrayList<? extends Number>) + " e B = " + (b instanceof ArrayList<? extends Number>);
	}

}
