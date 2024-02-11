package poligonos;

import java.util.Scanner;

public class Facade {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Poligono poli = new Poligono();
		System.out.println("Quantos pontos?");
		int n = sc.nextInt();
		for (int i=0;i<n;i++) {
			Ponto p = Ponto.solicitaPonto(sc);
			p.mostra();
			poli.inserePonto(p);
		}
		System.out.println("Poligono criado:");
		poli.mostraPontos();
		System.out.println("Perimetro calculado: "+poli.perimetro());
		sc.close();
	}

}
