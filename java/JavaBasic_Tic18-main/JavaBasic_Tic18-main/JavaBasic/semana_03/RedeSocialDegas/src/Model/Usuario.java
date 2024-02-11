package Model;

import java.util.ArrayList;

public class Usuario {
	static int numero_Usuarios = 0;
	String nome_Usuario, email, senha;
	int id;
	
	ArrayList<Usuario> Amigos;
	ArrayList<Sessao> sessoes;
	ArrayList<Postagem> postagens;
	
	public Usuario(String nome_Usuario, String email, String senha) {
		this.nome_Usuario = nome_Usuario;
		this.email = email;
		this.senha = senha;
		this.id = ++numero_Usuarios;
		
		this.Amigos = new ArrayList<>();
		this.sessoes = new ArrayList<>();
		this.postagens = new ArrayList<>();
	}
	
	public Usuario() {
		
		this.Amigos = new ArrayList<>();
		this.sessoes = new ArrayList<>();
		this.postagens = new ArrayList<>();
	}

	public String getNome_Usuario() {
		return nome_Usuario;
	}
	public void setNome_Usuario(String nome_Usuario) {
		this.nome_Usuario = nome_Usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
		
	public ArrayList<Usuario> getAmigos() {
		return Amigos;
	}

	public void setAmigos(ArrayList<Usuario> amigos) {
		Amigos = amigos;
	}

	public ArrayList<Sessao> getSessoes() {
		return sessoes;
	}

	public void addSessoes(Sessao sessao) {
		this.sessoes.add(sessao);
	}

	public ArrayList<Postagem> getPostagens() {
		return postagens;
	}

	public void addPostagens(Postagem postagens) {
		this.postagens.add(postagens);
	}

	@Override
	public String toString() {
		return "\nid = " + id + "\nnome_Usuario = " + nome_Usuario + "\nemail = " + email + "\nsenha = " + senha;
	}
	
	
	
	
}
