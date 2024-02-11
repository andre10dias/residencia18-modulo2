
import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		int op;
		do {
			op = MenuPrincipal();
			if (op == 1) {
				CelsiusAFahrenheit();
			}else if (op == 2) {
				FahrenheitACelsius();
			}else if (op == 0) {
				
			}else {
				JOptionPane.showMessageDialog(null, "Opção Invalida");
			}
		} while (op != 0);
	}
	
	public static int MenuPrincipal(){
		int op;
		String str = "############ Conversor de Temperaturas ############\n";
		str +=	"1. Celsius a Fahrenheit\n";
		str +=	"2. Fahrenheit a Celsius\n";
		str +=	"0. Sair\n";
		str +=	"###############################################\n";
		str += 	"Escolha uma das opções:";
		try {
			op = Integer.parseInt(JOptionPane.showInputDialog(str));
		}catch (NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Você não inseriu um número válido !!!");
			op = MenuPrincipal();
		}
		
		return op;
	}
	
	public static void CelsiusAFahrenheit(){
		float celsius, fahrenheit;
		String str;
		try {
			celsius = Float.parseFloat(JOptionPane.showInputDialog("Insira a temperatura em Celsius: "));
			fahrenheit = (celsius * 9 / 5) + 32;
			str = "######### Conversor de Celsius para Fahrenheit #########\n\n";
			str += "Temperatura informada em Celsius: " + celsius + "°\n\n";
			str += "Temperatura convertida em Fahrenheit: " + fahrenheit + "°\n\n";
			str += "#######################################################\n";
			JOptionPane.showMessageDialog(null, str);
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Você não inseriu um valor válido !!!");
			CelsiusAFahrenheit();
		}
		
	}
	
	public static void FahrenheitACelsius(){
		float fahrenheit, celsius;
		String str;
		try {
			fahrenheit = Float.parseFloat(JOptionPane.showInputDialog("Insira a temperatura em Fahrenheit: "));
			celsius = (fahrenheit - 32) * 5 / 9;
			str = "######### Conversor de Fahrenheit para Celsius #########\n\n";
			str += "Temperatura informada em Fahrenheit: " + fahrenheit + "°\n\n";
			str += "Temperatura convertida em Celsius: " + celsius + "°\n\n";
			str += "#######################################################\n";
			JOptionPane.showMessageDialog(null, str);
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Você não inseriu um valor válido !!!");
			FahrenheitACelsius();
		}
	}

}
