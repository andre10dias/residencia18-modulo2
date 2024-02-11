package exe_01;

import javax.swing.JOptionPane;

public class Exe05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int op;
		op = Integer.parseInt(JOptionPane.showInputDialog("------Conversão de Temperatura------\n"
				+ "0 - Celsius para Fahrenheit\n" + "1 - Fahrenheit para Celsius"
				+ "obs: Qualquer outro valor vai retornar uma mensagem de erro" + "\nDigite a opção desejada: "));

		ConversaoTemperatura(op);

	}

//	Conversão de Temperatura Fahrenheit para Celsius
	public static void ConversaoFahrenheitCelsius() {
		float fahrenheit, celsius;
		fahrenheit = Float.parseFloat(JOptionPane.showInputDialog("Digite a temperatura em Fahrenheit: "));
		celsius = (fahrenheit - 32) * 5 / 9;
		JOptionPane.showMessageDialog(null, "A temperatura em Celsius é: " + celsius);
	}

//	Conversão de Temperatura Celsius para Fahrenheit
	public static void ConversaoCelsiusFahrenheit() {
		float celsius, fahrenheit;
		celsius = Float.parseFloat(JOptionPane.showInputDialog("Digite a temperatura em Celsius: "));
		fahrenheit = (celsius * 9 / 5) + 32;
		JOptionPane.showMessageDialog(null, "A temperatura em Fahrenheit é: " + fahrenheit);
	}

//	Conversão de Temperatura
	public static void ConversaoTemperatura(int op) {
		float celsius, fahrenheit;
		if (op == 0) {
			celsius = Float.parseFloat(JOptionPane.showInputDialog("Digite a temperatura em Celsius: "));
			fahrenheit = (celsius * 9 / 5) + 32;
			JOptionPane.showMessageDialog(null, "A temperatura em Fahrenheit é: " + fahrenheit);
		} else if (op == 1) {
			fahrenheit = Float.parseFloat(JOptionPane.showInputDialog("Digite a temperatura em Fahrenheit: "));
			celsius = (fahrenheit - 32) * 5 / 9;
			JOptionPane.showMessageDialog(null, "A temperatura em Celsius é: " + celsius);
		} else {
			JOptionPane.showMessageDialog(null, "Opção inválida!");
		}
	}

}
