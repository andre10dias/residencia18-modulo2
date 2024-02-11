package exe_01;

import javax.swing.JOptionPane;

public class Exe06 {
	public static void main(String[] args) {
//		Calcular area de um retangulo
		int altura = Integer.parseInt(JOptionPane.showInputDialog("Digite a Altura: "));
		int largura = Integer.parseInt(JOptionPane.showInputDialog("Digite a Largura: "));
		int area = CalcularAreaRetangulo(altura, largura);
		JOptionPane.showMessageDialog(null, "A area do retangulo e: " + area);
	}

//	Função calcular area de um retangulo
	public static int CalcularAreaRetangulo(int altura, int largura) {
		return altura * largura;
	}

}
