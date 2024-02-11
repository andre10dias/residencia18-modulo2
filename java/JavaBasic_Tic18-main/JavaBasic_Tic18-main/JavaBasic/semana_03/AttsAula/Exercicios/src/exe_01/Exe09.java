package exe_01;

import javax.swing.JOptionPane;

public class Exe09 {
	public int SomaInt(int a, int b) {
		return a + b;
	}

	public int SubtrairInt(int a, int b) {
		return a - b;
	}

	public int MultiplicarInt(int a, int b) {
		return a * b;
	}

	public int DividirInt(int a, int b) {
		return a / b;
	}

	public int ModuloFloat(int a, int b) {
		return a % b;
	}

	public float SomaFloat(float a, float b) {
		return a + b;
	}

	public float SubtrairFloat(float a, float b) {
		return a - b;
	}

	public float MultiplicarFloat(float a, float b) {
		return a * b;
	}

	public float DividirFloat(float a, float b) {
		return a / b;
	}

	public float ModuloFloat(float a, float b) {
		return a % b;
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
	
	public static void main(String[] args) {
		Exe09 calculadora = new Exe09();
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
								"Resultado da soma: \n" + num1 + " + " + num2 + " = " + calculadora.SomaInt(num1, num2));
						break;
					case 2:
						num1 = Integer.parseInt(JOptionPane.showInputDialog("Primeiro valor: "));
						num2 = Integer.parseInt(JOptionPane.showInputDialog("Segundo valor: "));
						JOptionPane.showMessageDialog(null, "Resultado da subtração: \n" + num1 + " - " + num2 + " = "
								+ calculadora.SubtrairInt(num1, num2));
						break;
					case 3:
						num1 = Integer.parseInt(JOptionPane.showInputDialog("Primeiro valor: "));
						num2 = Integer.parseInt(JOptionPane.showInputDialog("Segundo valor: "));
						JOptionPane.showMessageDialog(null, "Resultado da multiplicação: \n" + num1 + " * " + num2 + " = "
								+ calculadora.MultiplicarInt(num1, num2));
						break;
					case 4:
						num1 = Integer.parseInt(JOptionPane.showInputDialog("Primeiro valor: "));
						num2 = Integer.parseInt(JOptionPane.showInputDialog("Segundo valor: "));
						if (num2 == 0) {
							JOptionPane.showMessageDialog(null, "Nao é possível dividir por zero !!");
						} else {
							JOptionPane.showMessageDialog(null, "Resultado da divisão: \n" + num1 + " / " + num2 + " = "
									+ calculadora.DividirInt(num1, num2));
						}
						break;
					case 5:
						num1 = Integer.parseInt(JOptionPane.showInputDialog("Primeiro valor: "));
						num2 = Integer.parseInt(JOptionPane.showInputDialog("Segundo valor: "));
						if (num2 == 0) {
							JOptionPane.showMessageDialog(null, "Nao é possível dividir por zero !!");
						} else {
							JOptionPane.showMessageDialog(null, "Resultado do moédulo da divisão: \n" + num1 + " % "
									+ num2 + " = " + calculadora.ModuloFloat(num1, num2));
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
								+ calculadora.SomaFloat(num3, num4));
						break;
					case 2:
						num3 = Float.parseFloat(JOptionPane.showInputDialog("Primeiro valor: "));
						num4 = Float.parseFloat(JOptionPane.showInputDialog("Segundo valor: "));
						JOptionPane.showMessageDialog(null, "Resultado da subtração: \n" + num3 + " - " + num4 + " = "
								+ calculadora.SubtrairFloat(num3, num4));
						break;
					case 3:
						num3 = Float.parseFloat(JOptionPane.showInputDialog("Primeiro valor: "));
						num4 = Float.parseFloat(JOptionPane.showInputDialog("Segundo valor: "));
						JOptionPane.showMessageDialog(null, "Resultado da multiplicação: \n" + num3 + " * " + num4 + " = "
								+ calculadora.MultiplicarFloat(num3, num4));
						break;
					case 4:
						num3 = Float.parseFloat(JOptionPane.showInputDialog("Primeiro valor: "));
						num4 = Float.parseFloat(JOptionPane.showInputDialog("Segundo valor: "));
						if (num4 == 0) {
							JOptionPane.showMessageDialog(null, "Nao é possível dividir por zero !!");
						} else {
							JOptionPane.showMessageDialog(null, "Resultado da divisão: \n" + num3 + " / " + num4 + " = "
									+ calculadora.DividirFloat(num3, num4));
						}
						break;
					case 5:
						num3 = Float.parseFloat(JOptionPane.showInputDialog("Primeiro valor: "));
						num4 = Float.parseFloat(JOptionPane.showInputDialog("Segundo valor: "));
						if (num4 == 0) {
							JOptionPane.showMessageDialog(null, "Nao é possível dividir por zero !!");
						} else {
							JOptionPane.showMessageDialog(null, "Resultado do moédulo da divisão: \n" + num3 + " % "
									+ num4 + " = " + calculadora.ModuloFloat(num3, num4));
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
}
