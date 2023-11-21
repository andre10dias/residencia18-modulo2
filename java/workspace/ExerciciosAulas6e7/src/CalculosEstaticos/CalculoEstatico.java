package CalculosEstaticos;

public abstract class CalculoEstatico {

	public CalculoEstatico() {
		// TODO Auto-generated constructor stub
	}
	
	public static int fatorial(int x) {
		int fatorial = x;
		
		if (x == 0) {
			fatorial = 1;
		}
		else {			
			for (int i = x-1; i > 0; i--) {
				fatorial *= i;
			}
		}
		
		return fatorial;
	}

}
