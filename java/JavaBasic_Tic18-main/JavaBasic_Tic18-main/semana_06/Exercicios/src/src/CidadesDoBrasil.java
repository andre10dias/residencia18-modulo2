package src;

public class CidadesDoBrasil implements DadosEstatisticos {
	
	String nome;
	
	public CidadesDoBrasil(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Object maximo() {
		return null;
	}
	public Object minimo() {
		return null;
	}
	public void ordenar() {
		
	}
	public Object buscar() {
		return null;
	}
	
	@Override
	public String toString() {
		return "CidadesDoBrasil = " + nome;
	}
}
