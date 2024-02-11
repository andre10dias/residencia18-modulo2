package Model;

import java.util.ArrayList;

public class Poligono {
	private ArrayList<Ponto> pontos;
	
	public Poligono() {
		pontos = new ArrayList<>();
	}
	
	public ArrayList<Ponto> getPontos() {
		return pontos;
	}
	
	public void inserePonto(Ponto p) {
		this.pontos.add(p);
	}
	
	public void adicionarPonto(float x, float y) {
		pontos.add(new Ponto(x, y));
	}
	
	public void imprimir() {
		if (pontos.size() > 0) {
			for (Ponto p : pontos) {
				p.imprimir();
			}
		}else {
			System.out.println("Poligono vazio");
		}
		
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
