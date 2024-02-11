package main;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		//#Conversor de Moedas
		double valor, cotacao;
		
		while(true) {
			switch (Menu()) {
				case 1:
					try {
						valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor em Dolar"));
						cotacao = Double.parseDouble(JOptionPane.showInputDialog("Digite a cotacao"));
						JOptionPane.showMessageDialog(null, "Valor em Real: " + Dola_e_Real(valor, cotacao));
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Valor Invalido");
					}
					break;
				case 2:
					try {
						valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor em Euro"));
						cotacao = Double.parseDouble(JOptionPane.showInputDialog("Digite a cotacao"));
						JOptionPane.showMessageDialog(null, "Valor em Real: " + Euro_e_Real(valor, cotacao));
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Valor Invalido");
					}
					break;
				case 0:
					System.exit(0);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção Invalida");
					break;
			}
		}
	}
	
	public static double Dola_e_Real(double valor, double cotacao) {
		//Conversor de Dolar para Real
		return valor * cotacao;
	}
	
	public static double Euro_e_Real(double valor, double cotacao) {
		//Conversor de Euro para Real
		return valor * cotacao;		
	}
	
	public static int Menu() {
		int opcao;
		try {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção: \n" + "1 - Dolar para Real \n" + "2 - Euro para Real \n" + "0 - Sair"));
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Opção Invalida");
			opcao = Menu();
		}
		return opcao;
	}
	
}
