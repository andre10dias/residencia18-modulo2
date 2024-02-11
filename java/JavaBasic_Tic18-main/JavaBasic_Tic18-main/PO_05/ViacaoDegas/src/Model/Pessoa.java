package Model;

public class Pessoa {
//	ESSA E UM MODELO DE PESSOA QUE VAI SER ERDADA POR MOTORISTA E PASSAGEIRO
	private String nome;
	private String cpf;
	
	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	@Override
	public String toString() {
		return "Parada [nome=" + nome + ", cpf=" + cpf + "]";
	}
}
