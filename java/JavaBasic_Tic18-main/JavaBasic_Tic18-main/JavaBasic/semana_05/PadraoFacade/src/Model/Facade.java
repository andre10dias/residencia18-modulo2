package Model;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;
public class Facade {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Poligono de quantos pontos?");
		int n = sc.nextInt();
		Poligono poligono = new Poligono();
		for (int i = 0; i < n; i++) {
			Ponto p = Ponto.solicitaPonto();
			if (p != null) {
				poligono.inserePonto(p);
			}
		}
		if (poligono.getPontos().size() > 0) {
			System.out.println("Poligono:");
			poligono.imprimir();
			System.out.println("Perimetro: "+poligono.Perimetro());
		}else {
			System.out.println("Poligono vazio");
		}
		
	}
}
