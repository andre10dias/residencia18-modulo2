package exe_01;

import javax.swing.JOptionPane;

public class Exe03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Concatenar Strings
		String nome = JOptionPane.showInputDialog("Digite seu nome: ");
		String sobrenome = JOptionPane.showInputDialog("Digite seu sobrenome: ");
		String nomeCompleto = nome + " " + sobrenome;
		JOptionPane.showMessageDialog(null, "Seu nome completo é: " + nomeCompleto);
		
		SolicitaString();
	}
	
	public static void SolicitaString() {
		String str = JOptionPane.showInputDialog("------Solicitando Strings ------\n Digite uma string: ");
		JOptionPane.showMessageDialog(null, "A string digitada foi: " + str);
	}
}
