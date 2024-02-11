import java.util.ArrayList;
import java.util.Iterator;

import Exceptions.ArraySizeDiferentesException;
import Exceptions.ImpossivelDividirPorZeroException;
import Exceptions.IncompativelTipoListException;

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
	
	public ArrayList<Number> Somar(ArrayList<Number> a, ArrayList<Number> b) {
		ArrayList<Number> result = new ArrayList<>();
		if(a.size() == b.size()) {
			if(a instanceof ArrayList<? extends Number> && b instanceof ArrayList<? extends Number>) {
				Iterator<Number> iterA = a.iterator();
				Iterator<Number> iterB = b.iterator();
				
				while(iterA.hasNext() && iterB.hasNext()) {
					result.add(iterA.next().doubleValue() + iterB.next().doubleValue());
				}
				return result;
			}else {
				throw new IncompativelTipoListException(a, b);
			}
			
		}else {
			throw new ArraySizeDiferentesException(a, b);
		}
	}
	
	public ArrayList<Number> Dividir(ArrayList<Number> a, ArrayList<Number> b) {
		  if (a.size() != b.size()) {
		    throw new ArraySizeDiferentesException(a, b);
		  }

		  if (a instanceof ArrayList<? extends Number> && b instanceof ArrayList<? extends Number>) {
		    ArrayList<Number> result = new ArrayList<>();
		    Iterator<Number> iterA = a.iterator();
		    Iterator<Number> iterB = b.iterator();

		    while (iterA.hasNext() && iterB.hasNext()) {
		      Number divisor = iterB.next();
		      if (divisor.doubleValue() == 0) {
		        throw new ImpossivelDividirPorZeroException(divisor);
		      }

		      for (Number dividendo : a) {
		        result.add(dividendo.doubleValue() / divisor.doubleValue());
		      }
		    }

		    return result;
		  } else {
		    throw new IncompativelTipoListException(a, b);
		  }
		}

	public float Modulo(float a, float b) {
		return a % b;
	}
}
