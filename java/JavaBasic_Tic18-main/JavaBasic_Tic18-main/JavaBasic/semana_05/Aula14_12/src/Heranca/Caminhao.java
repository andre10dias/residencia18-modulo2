package Heranca;

public class Caminhao extends Veiculo {
	private int numeroEixos;
	private int capacidadeMaxima;
	
	public Caminhao(String modelo, String cor, int ano, int numeroEixos, int capacidadeMaxima) {
		super(modelo, cor, ano);
		this.setNumeroEixos(numeroEixos);
		this.capacidadeMaxima = capacidadeMaxima;
	}
	
	public Caminhao(String modelo, String cor, int ano, int capacidadeMaxima) {
		super(modelo, cor, ano);
	}
	
	public Caminhao(String modelo, String cor, int ano) {
		super(modelo, cor, ano);
	}
	
	public int getNumeroEixos() {
		return numeroEixos;
	}
	
	public void setNumeroEixos(int numeroEixos) {
		this.numeroEixos = numeroEixos;
	}
	
	public int getCapacidadeMaxima() {
		return capacidadeMaxima;
	}
	
	public void setCapacidadeMaxima(int capacidadeMaxima) {
		this.capacidadeMaxima = capacidadeMaxima;
	}
	
	public void imprimir() {
		super.imprimir();
		if (getNumeroEixos() > 0) {
			System.out.println("Número de Eixos: " + getNumeroEixos());
		}else {
			System.out.println("Número de Eixos: Não Possui Eixos ou Não Informado !!");
		}
		if (getCapacidadeMaxima() > 0) {
			System.out.println("Capacidade Máxima: " + getCapacidadeMaxima());
		}else {
			System.out.println("Capacidade Máxima: Não Possui Capacidade Máxima ou Não Informado !!");
		}
		System.out.println("------------------------------------");
	}
	
	public static void main(String[] args) {
		Caminhao caminhao = new Caminhao("Caminhao", "Vermelho", 2010, 2, 1000);
		caminhao.imprimir(); 
	}
}
