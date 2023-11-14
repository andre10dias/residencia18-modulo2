package exemploClasses;

import java.util.Scanner;

public class Cliente {
	
	private String nome;
	private int idade;
	private String cpf;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String nome, cpf, idade;
		
		System.out.println("Criando novo cliente:");
		
		System.out.print("\nInforme o nome do cliente: ");
		nome = entrada.nextLine();
		
		System.out.print("Informe o CPF do cliente: ");
		cpf = entrada.nextLine();
		
		Cliente cliente = new Cliente(nome, cpf);
		
		System.out.println("\nDados do cliente: ");
		System.out.println("Nome: "+cliente.getNome());
		System.out.println("CPF: "+cliente.getCpf());
		System.out.println("Idade: "+cliente.getIdade()+" anos");
		
		System.out.println("\nAlterando dados do cliente:");
		
		System.out.print("\nInforme o nome do cliente: ");
		nome = entrada.nextLine();
		
		System.out.print("Informe o CPF do cliente: ");
		cpf = entrada.nextLine();
		
		System.out.print("Informe a idade do cliente: ");
		idade = entrada.nextLine();
		
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setIdade(Integer.parseInt(idade));
		
		System.out.println("\nDados do cliente (Editado): ");
		System.out.println("Nome: "+cliente.getNome());
		System.out.println("CPF: "+cliente.getCpf());
		System.out.println("Idade: "+cliente.getIdade()+" anos");
		
	}

}
