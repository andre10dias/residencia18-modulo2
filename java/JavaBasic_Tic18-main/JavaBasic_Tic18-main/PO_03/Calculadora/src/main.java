
import javax.swing.JOptionPane;

public class main {
	public static void main(String[] args) {
		Calculadora calculadora = new Calculadora();
		int opcao, opc, num1, num2;
		float num3, num4;

		do {
			opcao = MenuPrincipal();
			switch (opcao) {
			case 1:
				do {
					opc = MenuOperacoes();
					switch (opc) {
					case 1:
						num1 = Integer.parseInt(JOptionPane.showInputDialog("Primeiro valor: "));
						num2 = Integer.parseInt(JOptionPane.showInputDialog("Segundo valor: "));
						JOptionPane.showMessageDialog(null,
								"Resultado da soma: \n" + num1 + " + " + num2 + " = " + calculadora.Soma(num1, num2));
						break;
					case 2:
						num1 = Integer.parseInt(JOptionPane.showInputDialog("Primeiro valor: "));
						num2 = Integer.parseInt(JOptionPane.showInputDialog("Segundo valor: "));
						JOptionPane.showMessageDialog(null, "Resultado da subtração: \n" + num1 + " - " + num2 + " = "
								+ calculadora.Subtrair(num1, num2));
						break;
					case 3:
						num1 = Integer.parseInt(JOptionPane.showInputDialog("Primeiro valor: "));
						num2 = Integer.parseInt(JOptionPane.showInputDialog("Segundo valor: "));
						JOptionPane.showMessageDialog(null, "Resultado da multiplicação: \n" + num1 + " * " + num2 + " = "
								+ calculadora.Multiplicar(num1, num2));
						break;
					case 4:
						num1 = Integer.parseInt(JOptionPane.showInputDialog("Primeiro valor: "));
						num2 = Integer.parseInt(JOptionPane.showInputDialog("Segundo valor: "));
						try {
							JOptionPane.showMessageDialog(null, "Resultado da divisão: \n" + num1 + " / " + num2 + " = "
									+ calculadora.Dividir(num1, num2));
						}catch(Exception e){
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						break;
					case 5:
						num1 = Integer.parseInt(JOptionPane.showInputDialog("Primeiro valor: "));
						num2 = Integer.parseInt(JOptionPane.showInputDialog("Segundo valor: "));
						if (num2 == 0) {
							JOptionPane.showMessageDialog(null, "Nao é possível dividir por zero !!");
						} else {
							JOptionPane.showMessageDialog(null, "Resultado do moédulo da divisão: \n" + num1 + " % "
									+ num2 + " = " + calculadora.Modulo(num1, num2));
						}
						break;
					case 0:
						break;
					default:
						JOptionPane.showMessageDialog(null, "Opção inválida !!");
					}
				} while (opc != 0);
				break;
			case 2:
				do {
					opc = MenuOperacoes();
					switch (opc) {
					case 1:
						num3 = Float.parseFloat(JOptionPane.showInputDialog("Primeiro valor: "));
						num4 = Float.parseFloat(JOptionPane.showInputDialog("Segundo valor: "));
						JOptionPane.showMessageDialog(null, "Resultado da soma: \n" + num3 + " + " + num4 + " = "
								+ calculadora.Soma(num3, num4));
						break;
					case 2:
						num3 = Float.parseFloat(JOptionPane.showInputDialog("Primeiro valor: "));
						num4 = Float.parseFloat(JOptionPane.showInputDialog("Segundo valor: "));
						JOptionPane.showMessageDialog(null, "Resultado da subtração: \n" + num3 + " - " + num4 + " = "
								+ calculadora.Subtrair(num3, num4));
						break;
					case 3:
						num3 = Float.parseFloat(JOptionPane.showInputDialog("Primeiro valor: "));
						num4 = Float.parseFloat(JOptionPane.showInputDialog("Segundo valor: "));
						JOptionPane.showMessageDialog(null, "Resultado da multiplicação: \n" + num3 + " * " + num4 + " = "
								+ calculadora.Multiplicar(num3, num4));
						break;
					case 4:
						num3 = Float.parseFloat(JOptionPane.showInputDialog("Primeiro valor: "));
						num4 = Float.parseFloat(JOptionPane.showInputDialog("Segundo valor: "));
						try {
							JOptionPane.showMessageDialog(null, "Resultado da divisão: \n" + num3 + " / " + num4 + " = "
									+ calculadora.Dividir(num3, num4));
						}catch(Exception e){
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						break;
					case 5:
						num3 = Float.parseFloat(JOptionPane.showInputDialog("Primeiro valor: "));
						num4 = Float.parseFloat(JOptionPane.showInputDialog("Segundo valor: "));
						if (num4 == 0) {
							JOptionPane.showMessageDialog(null, "Nao é possível dividir por zero !!");
						} else {
							JOptionPane.showMessageDialog(null, "Resultado do moédulo da divisão: \n" + num3 + " % "
									+ num4 + " = " + calculadora.Modulo(num3, num4));
						}
						break;
					case 0:
						break;
					default:
						JOptionPane.showMessageDialog(null, "Opção inválida !!");
					}
				} while (opc != 0);
			}
		} while (opcao != 0);

	}

	public static int MenuPrincipal() {
		int opcao = 0;
		String str;
		str = "################# CALCULADORA ####################\n";
		str += "\n Qual tipo de dado deseja realizar a operacao?\n";
		str += "1 - Inteiros\n2 - Flutuantes\n0 - Sair\n";
		try {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(str));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, " Erro !!!\nValor informado não é um número !!");
			return MenuPrincipal();
		}
		return opcao;
	}

	public static int MenuOperacoes() {
		int opcao = 0;
		String str;
		str = "################# CALCULADORA ####################\n";
		str += "\n Qual operação deseja realizar?\n";
		str += "1 - Soma\n2 - Subtração\n3 - Multiplicação\n4 - Divisão\n5 - Modulo\n0 - voltar\n";
		try {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(str));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, " Erro !!!\nValor informado não é um número válido!!");
			return MenuOperacoes();
		}
		return opcao;

	}

}
