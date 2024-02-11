package Usuario;

import java.util.ArrayList;
import java.util.Scanner;


import RedeSocial.main;

public class Usuario {
	String nome, email, nacionalidade;
	int qtd_Postagem, pontuacao;
	ArrayList<String> postagem;
	
	public Usuario() {
		super();
		this.qtd_Postagem = 0;
		this.postagem = new ArrayList();
	}
	
	public Usuario(String nome, String email, String nacionalidade) {
		super();
		this.nome = nome;
		this.email = email;
		this.nacionalidade = nacionalidade;
		this.qtd_Postagem = 0;
		this.postagem = new ArrayList();
	}
	
	public void alt_Pontuacao(int delta) {
		if(delta > 0) {
			this.pontuacao+=delta;
		}else if(this.pontuacao+delta < 0) {
			this.pontuacao = 0;
		}
	}
	
	public void addPostagem(String p) {
		this.postagem.add(p);
		this.qtd_Postagem++;
	}
	
	public ArrayList<String> getPostagem() {
		return postagem;
	}

	public void imprimePostagem() {
		System.out.println("########## Postagens ##########");
		System.out.println("Autor: " + this.nome);
		for(String s : this.postagem) {
			System.out.println("\n_______________________________________________\n");
			System.out.println(s);
			System.out.println("\n_______________________________________________\n");
		}
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

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", email=" + email + ", nacionalidade=" + nacionalidade + "]";
	}
	
	public static void main(String[] args) {
		String postagem, opc, user;
		Scanner sc = new Scanner(System.in);
		ArrayList <Usuario> us = new ArrayList();
		Usuario u = new Usuario();
		
		do {
			System.out.println("Informe o nome do Usuario: ");
			u.setNome(sc.nextLine());
			System.out.println("Informe o E-mail: ");
			u.setEmail(sc.nextLine());
			System.out.println("Informe a nascionalidade: ");
			u.setNacionalidade(sc.nextLine());
			
			us.add(u);
			
			System.out.println("Deseja continuar Cadastrando Usuarios? (s/n)");
			opc = sc.next();
		}while(!opc.equals("n"));
		
		sc = new Scanner(System.in);
		
		System.out.println("##### Hora da postagem #######");
		System.out.println("Informe o email do usuario: ");
		user = sc.nextLine();
		
		for(Usuario p: us) {
			if(p.getEmail().equals(user)) {
				do {
					sc = new Scanner(System.in);
					System.out.println("Digite sua Postagem: ");
					postagem = sc.nextLine();
					p.addPostagem(postagem);
					System.out.println("Deseja continuar Postando? (s/n)");
					opc = sc.next();
				}while(!opc.equals("n"));
			}
		}
		
		System.out.println("##### Todas as Postagens #####");
		
		for(Usuario p: us) {
			if(p.getPostagem().size() > 0) {
				p.imprimePostagem();
			}
		}
		
		
	}
	
		
}
