package poligonos;

import java.util.Scanner;

public class Ponto {
	
	private float x, y, z;

	public float getX() {
		return x;
	};

	public float getY() {
		return y;
	};
	
	public float getZ() {
		return z;
	}

	public Ponto(float x, float y, float z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	};
	
	public static Ponto solicitaPonto(Scanner sc) {
		System.out.println("Digite as coordenadas do ponto");
		System.out.println("X: ");
		float x = sc.nextFloat();
		System.out.println("Y: ");
		float y = sc.nextFloat();
		System.out.println("Z: ");
		float z = sc.nextFloat();
		
		return new Ponto(x, y, z);
	}

	public void mostra() {
		System.out.println("("+x+","+y+","+z+")");
	}

	public double distancia(Ponto p) {
		return Math.sqrt( Math.pow(x-p.getX(), 2)+ Math.pow(y-p.getY(),2)+ Math.pow(z-p.getZ(),2));
	}

}
