package utilit;

public class Utilit {
	public static boolean verificarRepeticaoCaracteres(String alfabeto) {
		for (int i = 0; i < alfabeto.length(); i++) {
			for (int j = i + 1; j < alfabeto.length(); j++) {
				if (alfabeto.charAt(i) == alfabeto.charAt(j)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean verificarTemNumero(String alfabeto) {
		for (int i = 0; i < alfabeto.length(); i++) {
			if (Character.isDigit(alfabeto.charAt(i))) {
				return true;
			}
		}
		return false;
	}
}
