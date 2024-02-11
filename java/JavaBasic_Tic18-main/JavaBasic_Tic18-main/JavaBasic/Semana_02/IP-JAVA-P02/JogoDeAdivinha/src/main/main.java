package main;

import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		// Jogo de adivinhacao
		int tentativas = 0, chance = 5;
		int num = GerarNumerosAleatorios();
		
		while (tentativas < chance) {
			int numsolicitado = solicitaNumero();
			if (verificaNumero(num, numsolicitado)) {
				break;
			}else {
				tentativas++;
			}
		}
		
		JOptionPane.showMessageDialog(null, " Voce perdeu !!!\n O numero era: " + num + "\nFim de Jogo !!!");
		
	}
	
	public static int GerarNumerosAleatorios() {
		// Metodo para gerar numeros aleatorios de 1 a 100
		int num = (int) Math.floor(Math.random() *(100 - 1 + 1) + 1);
		return num;
	}
	
	public static int solicitaNumero() {
		// Metodo para solicitar um numero
		try {
			return Integer.parseInt(JOptionPane.showInputDialog("##### JOGO DE ADIVINHACAO #####\nVamos ver se vc consegue adivinhar o numero\nVoce tem 5 tentativas\nDigite um numero entre 1 e 100: "));
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Numero invalido");
			return solicitaNumero();
		}
	}
	
	public static boolean verificaNumero(int num, int numSolicitado) {
		// Metodo para verificar se o numero digitado e igual ao numero gerado
		if (num == numSolicitado) {
			JOptionPane.showMessageDialog(null, "Parabens, voce acertou!\nO numero era: " + num + "\nFim de Jogo !!");
			System.exit(0);
			return true;
		}else if (num > numSolicitado) {
			JOptionPane.showMessageDialog(null, "Vamos Ver Se Com Essa Dica Voce Acerta !!\nDica: O numero e maior");
		}else {
			JOptionPane.showMessageDialog(null, "Vamos Ver Se Com Essa Dica Voce Acerta !!\\nO numero e menor");
		}
		return false;
	}

}
