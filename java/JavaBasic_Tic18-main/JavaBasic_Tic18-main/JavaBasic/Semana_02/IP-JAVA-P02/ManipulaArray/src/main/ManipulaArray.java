package main;

import javax.swing.JOptionPane;

public class ManipulaArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int op, tam, resu;
		int[] numAleatorios = null;
		int[] num = null;
		
		while (true) {
			switch (menu()) {
				case 1:
					try {
						tam = Integer.parseInt(JOptionPane.showInputDialog("Quantos elementos deseja?"));
						numAleatorios = GerarNumerosAleatorios(tam);
					}catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Tamanho invalido");
					}
					break;
				case 2:
					num = solicitaNumero();
					break;
				case 3:
					if (num != null) {
						resu = somaElementosDeArray(num);
						JOptionPane.showMessageDialog(null, "### Array gerado pelo usuario ###\nA soma dos elementos do Array é: " + resu);
					}else {JOptionPane.showMessageDialog(null, "### Array gerado pelo usuario ###\nA soma dos elementos do Array é: Lista vazia !!");}
					if (numAleatorios != null) {
						resu = somaElementosDeArray(numAleatorios);
						JOptionPane.showMessageDialog(null, "### Array gerado aleatoriamente ###\nA soma dos elementos do Array é: " + resu);
					}else {JOptionPane.showMessageDialog(null, "### Array gerado aleatoriamente ###\nA soma dos elementos do Array é: Lista vazia !!");}
					break;
				case 4:
					if (num != null) {
						JOptionPane.showMessageDialog(null, "### Array gerado pelo usuario ###\nO maior valor do Array é: " + maiorNumeroArray(num));
					}else {JOptionPane.showMessageDialog(null, "### Array gerado pelo usuario ###\nO maior valor do Array é: Lista vazia !!");}
					
					if (numAleatorios != null) {
						JOptionPane.showMessageDialog(null, "### Array gerado aleatoriamente ###\nO maior valor do Array é: " + maiorNumeroArray(numAleatorios));
					}else {JOptionPane.showMessageDialog(null, "### Array gerado aleatoriamente ###\nO maior valor do Array é: Lista vazia !!");}
					break;
				case 5:
					if (num != null) {
						JOptionPane.showMessageDialog(null, "### Array gerado pelo usuario ###\nO menor valor do Array é: " + menorNumeroArray(num));
					}else {JOptionPane.showMessageDialog(null, "### Array gerado pelo usuario ###\nO menor valor do Array é: Lista vazia !!");}
										
					if (numAleatorios != null) {
						JOptionPane.showMessageDialog(null, "### Array gerado aleatoriamente ###\nO menor valor do Array é: " + menorNumeroArray(numAleatorios));
					}else {JOptionPane.showMessageDialog(null, "### Array gerado aleatoriamente ###\nO menor valor do Array é: Lista vazia !!");}
					
					break;
				case 6:
					if (num != null) {
						JOptionPane.showMessageDialog(null, "### Array gerado pelo usuario ###\nElementos do Array é: \n" + ListarArray(num));
					}else {JOptionPane.showMessageDialog(null, "### Array gerado aleatoriamente ###\nElementos do Array é: Lista vazia !!");}
					if (numAleatorios != null) {
						JOptionPane.showMessageDialog(null, "### Array gerado aleatoriamente ###\nElementos do Array é: \n" + ListarArray(numAleatorios));
					}else {
						JOptionPane.showMessageDialog(null, "### Array gerado pelo usuario ###\nElementos do Array é: Lista vazia !!!");
					}
					break;
				case 0:
					System.exit(0);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção invalida");
					break;
			}
		}
		
	}
	
	public static int menu() {
		int op;
		try {
			op = Integer.parseInt(JOptionPane.showInputDialog("##### My Array #####\n 1 - Gerar Array de Numeros inteiros aleatorios\n 2 - Solicitar Array do usuario\n 3 - Somar os Elementos do Array\n 4 - Verificar maior valor do Array\n 5 - Verificar menor valor do Array\n 6 - Listar Array\n 0 - Sair"));
			return op;
		}catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, "Valor invalido");
			return menu();
		}
	}
	
	public static String ListarArray(int[] num) {
		String str = "";
		for (int i = 0; i < num.length; i++) {
			if (i == num.length - 1) {
				str += num[i];
			}else {
				str += num[i] + ", ";
			}
		}
		return str;
		
	}
	
	public static int[] GerarNumerosAleatorios(int tam) {
		// Metodo para gerar numeros aleatorios de 1 a 100
		int[] num = new int[tam];
		for (int i = 0; i < tam; i++) {
			num[i] = (int) Math.floor(Math.random() *(100 - 1 + 1) + 1);
		}
		 
		return num;
	}
	
	public static int[] solicitaNumero() {
		int tam;
		int[] num;
		try {
			tam = Integer.parseInt(JOptionPane.showInputDialog("##### Gerar Array de Numeros inteiros #####\n Primeiro informe o tamanho do array\n Exemplo: 10\n"));
			num = new int[tam];
			for (int i = 0; i < tam; i++) {
				num[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o " + (i+1) + "ª numero: "));
			}
			return num;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Tamanho invalido ou valor invalido");
		}
		
		return null;
	}
	
	public static int somaElementosDeArray(int[] num) {
		int soma = 0;
		for (int i = 0; i < num.length; i++) {
			soma += num[i];
		}
		return soma;
	}
	
	public static int maiorNumeroArray(int[] num) {
		int maior = num[0];
		for (int i = 0; i < num.length; i++) {
			if (num[i] > maior) {
				maior = num[i];
			}
		}
		return maior;
	}
	
	public static int menorNumeroArray(int[] num) {
		int menor = num[0];
		for (int i = 0; i < num.length; i++) {
			if (num[i] < menor) {
				menor = num[i];
			}
		}
		return menor;
	}
}
