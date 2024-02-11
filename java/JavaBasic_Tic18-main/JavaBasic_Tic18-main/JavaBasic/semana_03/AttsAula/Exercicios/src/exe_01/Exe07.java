package exe_01;

import javax.swing.JOptionPane;

public class Exe07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Troca de dados de variaveis
		int va1, va2, aux;
		
//		va1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor 1"));
//		va2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor 2"));
//		JOptionPane.showMessageDialog(null, "O valor 1 e: " + va1 + "\nO valor 2 e: " + va2);
//		if (va1 == va2) {
//			JOptionPane.showMessageDialog(null, "Os valores sao iguais !! \n Nao houve troca de valores !!");
//		}else {
//			aux = va1;
//			va1 = va2;
//			va2 = aux;
//			JOptionPane.showMessageDialog(null, "Trocando os valores !!");
//			JOptionPane.showMessageDialog(null, "O valor 1 e: " + va1 + "\nO valor 2 e: " + va2);
//		}
		
		//		Mesma opcao de troca de valores mas utilizando o XOR
		
		va1 = Integer.parseInt(JOptionPane.showInputDialog("Trocando os valores utilizando o XOR \n Digite o valor 1"));
		va2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor 2"));
		JOptionPane.showMessageDialog(null, "O valor 1 e: " + va1 + "\nO valor 2 e: " + va2);
		if (va1 == va2) {
			JOptionPane.showMessageDialog(null, "Os valores sao iguais!!\n Nao houve troca de valores!!");
		}else {
			va1 = va1 ^ va2;
			va2 = va2 ^ va1;
			va1 = va1 ^ va2;
			JOptionPane.showMessageDialog(null, "Trocando os valores");
			JOptionPane.showMessageDialog(null, "O valor 1 e: " + va1 + "\nO valor 2 e: " + va2);
		}

	}

}
