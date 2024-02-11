package Model;
import java.util.Scanner;
public class Facade {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Poligono de quantos pontos?");
		int n = sc.nextInt();
		Poligono poligono = new Poligono();
		for (int i = 0; i < n; i++) {
			System.out.println("Digite as coordenadas do ponto "+(i+1)+":");
			System.out.println("X:");
			float x = sc.nextFloat();
			System.out.println("Y:");
			float y = sc.nextFloat();
			
			poligono.adicionarPonto(x, y);
		}
		System.out.println("Perimetro: "+poligono.Perimetro());
	}
}
