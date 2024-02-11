package poligonos;

import java.util.ArrayList;

public class Poligono {
	private ArrayList<Ponto> pontos;
	
	Poligono() {
		pontos = new ArrayList<Ponto>();
	}

	public void inserePonto(float x, float y , float z) {
		Ponto p = new Ponto(x, y, z);
		pontos.add(p);
		
	}

	public void mostraPontos() {
		for (int i=0; i< pontos.size(); i++) {
			System.out.println("("+pontos.get(i).getX()+","+pontos.get(i).getY()+ ","+pontos.get(i).getZ()+")");
		}
	}

	double perimetro() {
		Ponto p1, p2=pontos.get(1);
		double per = 0;
		for (int i=0; i< pontos.size()-1; i++) {
			p1 = pontos.get(i);
			p2 = pontos.get(i+1);
			per += Math.sqrt( Math.pow(p1.getX()-p2.getX(), 2) + Math.pow(p1.getY()-p2.getY(),2) + Math.pow(p1.getZ()-p2.getZ(),2));
		}
		p1 = pontos.get(0);
		per += Math.sqrt( Math.pow(p1.getX()-p2.getX(), 2) + Math.pow(p1.getY()-p2.getY(),2) + Math.pow(p1.getZ()-p2.getZ(),2));
		return per;
	}
}
