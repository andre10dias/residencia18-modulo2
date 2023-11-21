package ListaDeNumeros;

import java.util.Random;
import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) {
		final int TAM_MAX = 4;
		Random random = new Random();
		Scanner entrada = new Scanner(System.in);
		ListaNumeros lista = new ListaNumeros();
		
		System.out.println("Inserindo elementos na lista: ");
		for (int i = 0; i < TAM_MAX; i++) {	
			Float num = random.nextFloat(50);
			lista.novoNumero(num);
		}
		
		System.out.print("Números inseridos: ");
		lista.listaNumeros();
		
		System.out.println("\n\nMédia: " + String.format("%.1f", lista.media()));
		
		System.out.print("\nNúmeros orenados: ");
		lista.ordena();
		lista.listaNumeros();
		
		System.out.println("\n\nMediana: " + String.format("%.1f", lista.mediana()));
		
		int pos = random.nextInt(TAM_MAX);
		System.out.print("\nElemento na posição " + pos + ": "  + String.format("%.1f", lista.colocadoEm(pos)));
		
	}

}
