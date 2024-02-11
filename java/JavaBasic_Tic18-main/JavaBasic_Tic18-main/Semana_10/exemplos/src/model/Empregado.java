package model;

public class Empregado {
	private int id; 
	private String nome;
	private String cpf;
	private double salario;
	private String genero;
	
	public Empregado(String nome, String cpf, double salario, String genero) {
		setNome(nome);
		setCpf(cpf);
		setSalario(salario);
		setGenero(genero);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
