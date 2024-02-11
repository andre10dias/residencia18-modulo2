package Model;

public class Generos {
	static int ids = 0;
	
	String nome;
	int id;
	
	public Generos(String nome) {
		this.nome = nome;
		this.id = ids++;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getId() {
		return id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
