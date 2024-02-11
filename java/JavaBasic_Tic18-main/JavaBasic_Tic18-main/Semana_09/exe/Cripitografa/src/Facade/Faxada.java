package Facade;

import javax.swing.JOptionPane;

import cripitografa.Cripitografa;

public class Faxada {
	public static void main(String[] args) {
		String img = args[0];
		String img2 = args[1];
		String senha = args[2];
		String img3 = "hgg.txt";
		
		JOptionPane.showMessageDialog(null, "Dados recebidos:\nParametros de entrada: " + img + "\nParametros de saida: " + img2 + "\nSenha: " + senha);
		
		Cripitografa.process(img2, img3, senha);
		
		JOptionPane.showMessageDialog(null, "Fim do programa!");
	}
}
