package Listas;

import java.util.ArrayList;

public class Usuario {
	private String nome;
	private String email;
	ArrayList<Usuario> lista;
	public Usuario(String nome, String email) {
		this.nome = nome;
		this.email = email;
		lista = new ArrayList<>();
	}

	public Usuario() {
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
	
	public void adicionar(Usuario p) {
		this.lista.add(p);
	}
	
	public void Listar() {
		if (lista.size() > 0) {
			for (Usuario p : lista) {
				System.out.println("Nome:" + p.getNome() + "\n Email:" + p.getEmail());
				System.out.println("------------------------------------");
			}
		}else {
			System.out.println("Lista vazia !!");
		}
	}
	
	public void Listar(int x) {
		if (lista.size() > 0) {
			for (int i = x; i < lista.size(); i++) {
				System.out.println("Nome:" + lista.get(i).getNome() + "\n Email:" + lista.get(i).getEmail());
			}
		}else {
			System.out.println("Lista vazia !!");
		}
	}
	
	public void Listar(int x, int y) {
		if (lista.size() > 0) {
			if (y > lista.size() || x > lista.size() || x < 0 || y < 0 || x > y || y == lista.size()) {
				System.out.println("Posição inválida !!");
				return;
			}
			for (int i = x; i <= y; i++) {
				System.out.println("Nome:" + lista.get(i).getNome() + "\n Email:" + lista.get(i).getEmail());
			}
		}else {
			System.out.println("Lista vazia !!");
		}
		
	}
	
	public static void main(String[] args) {
		Usuario p = new Usuario("Juca", "juca@juca");
		
		p.adicionar(new Usuario("Joca", "joca@joca"));
		p.adicionar(new Usuario("Ana", "ana@joca"));
		p.adicionar(new Usuario("Maria", "maria@joca"));
		p.adicionar(new Usuario("Joao", "joao@joca"));
		p.adicionar(new Usuario("Jose", "jose@joca"));
		
		System.out.println("---------------Listando todos os usuários ----------------------");
		p.Listar();
		
		System.out.println("---------------Listando a partir da posição 2 ----------------------");
		p.Listar(2);
		
		System.out.println("---------------Listando a partir da posição 2 ate 3 ----------------------");
		p.Listar(2, 3);
	}
	
	
}
