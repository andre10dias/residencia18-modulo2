package Heranca;

public class Veiculo {
	private String modelo;
	private String cor;
	private int ano;
	
	public Veiculo(String modelo, String cor, int ano) {
		this.setModelo(modelo);
		this.setCor(cor);
		this.setAno(ano);
	}
			
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public void imprimir() {
		System.out.println("Modelo: " + getModelo());
		System.out.println("Cor: " + getCor());
		System.out.println("Ano: " + getAno());
	}
	
	public static void main(String[] args) {
		Veiculo v = new Veiculo("Celta", "Laranja", 2020);
		v.imprimir();
	}
}
