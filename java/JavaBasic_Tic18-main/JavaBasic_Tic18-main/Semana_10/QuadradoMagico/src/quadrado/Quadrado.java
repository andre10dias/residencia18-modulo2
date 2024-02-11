package quadrado;

public class Quadrado {
	String estado;
	
	public Quadrado(String estado) {
		this.estado = estado;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void jogar() {
		
	}
	
	public void clicar(int x) {
		if(x < 1 || x > 9) {
			throw new IllegalArgumentException("Posição inválida! " + x);
		}
		
		switch(x) {
			case 1:
				inverte(0);
				inverte(1);
				inverte(3);
				break;
			case 2:
				inverte(0);
				inverte(1);
				inverte(2);
				break;
			case 3:
				inverte(1);
				inverte(2);
				inverte(5);
				break;
			case 4:
				inverte(0);
				inverte(3);
				inverte(6);
				break;
			case 5:
				inverte(1);
				inverte(3);
				inverte(4);
				inverte(5);
				inverte(7);
				break;
			case 6:
				inverte(2);
				inverte(5);
				inverte(8);
				break;
			case 7:
				inverte(3);
				inverte(6);
				inverte(7);
				break;
			case 8:
				inverte(6);
				inverte(7);
				inverte(8);
				break;
			case 9:
				inverte(7);
				inverte(5);
				inverte(8);
				break;
		}
	}
	
	protected void inverte(int x) {
		char c = estado.charAt(x);
		if(c == 'X') {
			c = 'O';
		}else {
			c = 'X';
		}
		StringBuilder sb = new StringBuilder(estado);
		sb.setCharAt(x, c);
		estado = sb.toString();
	}
}
