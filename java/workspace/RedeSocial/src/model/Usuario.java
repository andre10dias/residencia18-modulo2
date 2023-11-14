package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario {
	
	private String nome;
	private String email;
	private String nacionalidade;
	private ArrayList<String> postagens;
	private int qtdePostagens;
	private int pontuacao;

	public Usuario() {
		postagens = new ArrayList<String>();
		qtdePostagens = 0;
		pontuacao = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public ArrayList<String> getPostagens() {
		return postagens;
	}

	public void setPostagens(ArrayList<String> postagens) {
		this.postagens = postagens;
	}
	
	public int getQtdePostagens() {
		return qtdePostagens;
	}

	public void setQtdePostagens(int qtdePostagens) {
		this.qtdePostagens = qtdePostagens;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public void adicionaPostagens(String postagem) {
		postagens.add(postagem);
		qtdePostagens++;
	}
	
	public void alteraPontuacao(int delta) {
		pontuacao += delta;
	}
	
	@Override
	public String toString() {
		return "\nUsuario cadastrado:\n"
				+ "nome: " + nome
				+ "\nemail: " + email
				+ "\nnacionalidade: " + nacionalidade
				+ "\npostagens: " + postagens;
	}

	public static void main(String[] args) {		
		Scanner entrada = new Scanner(System.in);
		String nome, email, nacionalidade;
		Usuario usuario = new Usuario();
		
		System.out.println("Criando novo usuario:");
		
		System.out.print("\nInforme o nome do usuario: ");
		nome = entrada.nextLine();
		
		System.out.print("Informe o e-mail do cliente: ");
		email = entrada.nextLine();
		
		System.out.print("Informe a nacionalidade do cliente: ");
		nacionalidade = entrada.nextLine();
		
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setNacionalidade(nacionalidade);
		
		System.out.println(usuario.toString());
	}

}
