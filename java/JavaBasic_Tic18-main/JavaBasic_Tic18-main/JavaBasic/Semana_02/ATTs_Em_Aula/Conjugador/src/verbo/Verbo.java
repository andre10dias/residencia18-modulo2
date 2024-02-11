package verbo;

import java.util.Scanner;

public class Verbo {
	private String radical, sufixo;
	
	public Verbo(String radical, String sufixo) {
		this.radical = radical;
		this.sufixo = sufixo;
	}
	
	public Verbo() {
		
	}

	public String getRadical() {
		return radical;
	}

	public void setRadical(String radical) {
		this.radical = radical;
	}

	public String getSufixo() {
		return sufixo;
	}

	public void setSufixo(String sufixo) {
		this.sufixo = sufixo;
	}

	public void conjugar() {
		System.out.println("Eu " + radical + "o");
		System.out.println("Tu " + radical + "as");
		System.out.println("Ele " + radical + "a");
		System.out.println("Nos " + radical + "amos");
		System.out.println("Vos " + radical + "ais");
		System.out.println("Eles " + radical + "am");
		System.out.println("Elas " + radical + "am");
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Verbo verbo = new Verbo();
		
		System.out.println("Informe o Radical do Verbo: ");
		
		verbo.setRadical(scan.nextLine());
		
		System.out.println("Informe o Sufixo do Verbo: ");
		
		verbo.setSufixo(scan.nextLine());
		
		verbo.conjugar();
	}
	
}
