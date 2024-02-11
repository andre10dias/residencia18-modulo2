package Model;

import java.util.ArrayList;

public class Poligono {
	ArrayList<Ponto> pontos;
	
	public Poligono() {
		pontos = new ArrayList<>();
	}
	
	public void adicionarPonto(float x, float y) {
		pontos.add(new Ponto(x, y));
	}
	
	public float Perimetro() {
		float perimetro = 0;
		Ponto p1,p2;
		for (int i = 0; i < pontos.size() - 1; i++) {
			p1 = pontos.get(i);
			p2 = pontos.get(i+1);
			perimetro += Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
		}
		p1 = pontos.get(pontos.size() - 1);
		p2 = pontos.get(0);
		perimetro += Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
		return perimetro;
	}
}
