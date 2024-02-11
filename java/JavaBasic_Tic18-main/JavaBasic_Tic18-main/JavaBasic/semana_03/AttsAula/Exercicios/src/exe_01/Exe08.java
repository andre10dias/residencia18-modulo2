package exe_01;

import javax.swing.JOptionPane;

public class Exe08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int idade, qtd_dias, qtd_meses;
//		idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a sua idade: "));
//		if (idade >= 18) {
//			JOptionPane.showMessageDialog(null, "Voce e maior de idade!!");
//		}else {
//			JOptionPane.showMessageDialog(null, "Voce e menor de idade!!");
//		}
		
		int dia_nasc = Integer.parseInt(JOptionPane.showInputDialog("Informe a data de nascimento: \nDigite o dia: "));
		int mes_nasc = Integer.parseInt(JOptionPane.showInputDialog("Digite o mes: "));
		int ano_nasc = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano: "));
				
		int ano_atual = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano atual: "));
		
		idade = ano_atual - ano_nasc;
		qtd_dias = (idade * 365);
		qtd_meses = (idade * 12);
				
		JOptionPane.showMessageDialog(null, "Voce tem: " + idade + " anos e " + qtd_dias + " dias e " + qtd_meses + " meses");
		
	}

}
