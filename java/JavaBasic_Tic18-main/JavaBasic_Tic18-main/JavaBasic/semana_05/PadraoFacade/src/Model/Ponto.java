package Model;

import java.util.Scanner;

public class Ponto {
	private float x,y;
	
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
	
	public static Ponto solicitaPonto() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Digite as coordenadas do ponto:");
			System.out.print("X:");
			float x = sc.nextFloat();
			System.out.print("Y:");
			float y = sc.nextFloat();
			return new Ponto(x, y);
		}catch(Exception e) {
			System.out.println("Entrada invalida");
		}
		return null;
	}
	
	public float distancia(Ponto p) {
		return (float) Math.sqrt(Math.pow(x - p.getX(), 2) + Math.pow(y - p.getY(), 2));
	}
	
	public void imprimir() {
		System.out.println("("+x+","+y+")");
	}
}
