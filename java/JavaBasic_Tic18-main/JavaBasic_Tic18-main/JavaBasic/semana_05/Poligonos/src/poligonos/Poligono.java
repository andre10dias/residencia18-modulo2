package poligonos;

import java.util.ArrayList;

public class Poligono {
	
	private ArrayList<Ponto> pontos;
	
	Poligono() {
		pontos = new ArrayList<Ponto>();
	}

	public void inserePonto(Ponto p) {
		pontos.add(p);
	}

	public void mostraPontos() {
		for (Ponto p: pontos)
			p.mostra();
	}

	public float perimetro() {
		float per = 0;
		Ponto p1, p2=pontos.get(1);
		for (int i=0; i< pontos.size()-1; i++) {
			p1 = pontos.get(i);
			p2 = pontos.get(i+1);
			per += p1.distancia(p2);
		}
		p1 = pontos.get(0);
		per += (float) p1.distancia(p2);
		return per;
	}

}
