package Heranca;

public class Carro extends Veiculo {
	private int numeroPortas;
	
	public Carro(String modelo, String cor, int ano, int numeroPortas) {
		super(modelo, cor, ano);
		this.setNumeroPortas(numeroPortas);
	}
	
	public Carro(String modelo, String cor, int ano) {
		super(modelo, cor, ano);
	}
	
	public int getNumeroPortas() {
		return numeroPortas;
	}
	
	public void setNumeroPortas(int numeroPortas) {
		this.numeroPortas = numeroPortas;
	}
	
	public void imprimir() {
		super.imprimir();
		if (getNumeroPortas() != 0) {
			System.out.println("Número de Portas: " + getNumeroPortas());
		}
		System.out.println("------------------------------------");
	}
	
	public void imprimir(boolean x) {
		super.imprimir();
		if (x) {
			if (getNumeroPortas() > 0) {
				System.out.println("Número de Portas: " + getNumeroPortas());
			}else {
				System.out.println("Número de Portas: Não Possui Portas ou Não Informado !!");
			}	
		}
		System.out.println("------------------------------------");
	}
	
	public static void main(String[] args) {
		Carro c = new Carro("Celta", "Laranja", 2020, 4);
		System.out.println("---------------- Todas informações do Carro --------------------");
		c.imprimir(true);
		System.out.println("---------------- Informações do Carro Sem Número de Portas --------------------");
		c.imprimir(false);
	}
}
