package Model;

public class Motorista extends Pessoa {
//	ESSA E UM MODELO DE MOTORISTA QUE VAI SER USADA POR JORNADA E ERDA CARACTERISTICAS DE PESSOA
	private String CNH;
	
	public Motorista(String nome, String cpf , String CNH) {
		super(nome, cpf);
		this.CNH = CNH;
	}
	
	public String getCNH() {
		return CNH;
	}
	
	public void setCNH(String CNH) {
		this.CNH = CNH;
	}

	@Override
	public String toString() {
		return "Motorista [CNH=" + CNH + "]";
	}
	
	
}
