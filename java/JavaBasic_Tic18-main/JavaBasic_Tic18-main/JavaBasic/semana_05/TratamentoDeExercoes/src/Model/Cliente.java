package Model;

import java.util.Date;

import IdadeException.IdadeMaiorExeption;
import IdadeException.IdadeNegativaExeption;

public class Cliente {
	String nome;
	Date dataNascimento;
	String senha;
	boolean bloqueado;
	
	ValidadorIdade validadorIdade;
	public Cliente(String nome, Date dataNascimento, String senha) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.senha = senha;
		try {
			validadorIdade = new ValidadorIdade(CalculaIdade(dataNascimento));
		}catch (IdadeMaiorExeption | IdadeNegativaExeption e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int CalculaIdade(Date dataNascimento) {
		Date dataAtual = new Date();
		int idade = dataAtual.getYear() - dataNascimento.getYear();
		return idade;
	}
	
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public static void main(String[] args) {
		Cliente cliente = new Cliente("Joaquim", new Date("12/12/2023"), "123");
	}
}
