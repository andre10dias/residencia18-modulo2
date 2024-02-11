package exe_01;

import javax.swing.JOptionPane;

public class Exe04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (VerificaParImpar()) {
			JOptionPane.showMessageDialog(null, "O número digitado é par!");
		} else {
			JOptionPane.showMessageDialog(null, "O número digitado é impar!");
		}
	}

//	Função para verificar se e par ou impar
	public static boolean VerificaParImpar() {
		int num = Integer.parseInt(JOptionPane.showInputDialog("Digite um número: "));
		if (num % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
}
