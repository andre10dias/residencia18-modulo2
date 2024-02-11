package Model;

public class Ponto {
	float x,y;
	
	public Ponto(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public void imprimir() {
		System.out.println("("+x+","+y+")");
	}
}
