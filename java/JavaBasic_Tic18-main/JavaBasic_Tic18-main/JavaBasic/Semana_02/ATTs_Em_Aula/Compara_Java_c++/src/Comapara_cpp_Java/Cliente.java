package Comapara_cpp_Java;

public class Cliente {
	String nome,cpf;
	int idade;
	
	public Cliente() {
		super();
	}
	
	public Cliente(String nome, String cpf, int idade) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
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
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Cliente [Nome=" + nome + ", CPF=" + cpf + ", Idade=" + idade + "]";
	}
	
	
}
