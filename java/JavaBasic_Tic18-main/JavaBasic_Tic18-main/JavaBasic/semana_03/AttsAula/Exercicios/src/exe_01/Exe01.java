package exe_01;

import javax.swing.JOptionPane;

public class Exe01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1, num2;
		num1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número"));
		num2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo número"));
		
		JOptionPane.showMessageDialog(null, "A soma dos números é: \n" + num1 + " + " + num2 + " = " + (num1 + num2));
		
	}
	
}
