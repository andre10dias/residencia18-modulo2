package SobrecargaConstrutor;

public class Engenheiro {
	private String nome;
	private String crea;
	
	public Engenheiro(String nome, String crea) {
		this.nome = nome;
		this.crea = crea;
	}
	
	public Engenheiro() {
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCrea() {
		return crea;
	}

	public void setCrea(String crea) {
		this.crea = crea;
	}
	
	public void imprimir() {
		System.out.println("Nome Engenheiro: " + nome);
		System.out.println("Crea: " + crea);
	}
}
