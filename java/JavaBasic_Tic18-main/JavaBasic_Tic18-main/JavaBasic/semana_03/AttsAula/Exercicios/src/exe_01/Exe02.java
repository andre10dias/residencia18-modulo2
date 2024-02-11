package exe_01;

import javax.swing.JOptionPane;

public class Exe02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MediaPonderada();
	}
	
	public static void MediaPonderada() {
		float nota1, nota2, nota3, media = 0;
		float peso1, peso2, peso3;
		
		nota1 = Integer.parseInt(JOptionPane.showInputDialog("Digite a primeira Nota: "));
		peso1 = Integer.parseInt(JOptionPane.showInputDialog("Informe o peso da primeira Nota: "));
		
		nota2 = Integer.parseInt(JOptionPane.showInputDialog("Digite a segunda Nota: "));
		peso2 = Integer.parseInt(JOptionPane.showInputDialog("Informe o peso da segunda Nota: "));
		
		nota3 = Integer.parseInt(JOptionPane.showInputDialog("Digite a terceira Nota: "));
		peso3 = Integer.parseInt(JOptionPane.showInputDialog("Informe o peso da terceira Nota: "));
		
		media = (nota1 * peso1 + nota2 * peso2 + nota3 * peso3) / (peso1 + peso2 + peso3);
		
		JOptionPane.showMessageDialog(null, "A média ponderada é: " + media);
	}
}
