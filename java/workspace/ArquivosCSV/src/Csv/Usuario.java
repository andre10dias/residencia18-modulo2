package Csv;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private String Nome;
	private String Email;
	private String Senha;
	private List<String> listaPostagens;
	
	public Usuario(String nome, String email) {
		Nome = nome;
		Email = email;
		listaPostagens = new ArrayList<>();
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		this.Senha = senha;
	}

	public List<String> getListaPostagens() {
		return listaPostagens;
	}

	public void setListaPostagens(List<String> listaPostagens) {
		this.listaPostagens = listaPostagens;
	}

}
