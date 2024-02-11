package Model;

public class Trecho {
	private Parada Origen;
	private Parada Destino;
	private String Duracao;
	
	public Trecho(Parada Origen, Parada Destino, String Duracao) {
		this.Origen = Origen;
		this.Destino = Destino;
		this.Duracao = Duracao;		
	}

	public Parada getOrigen() {
		return Origen;
	}

	public void setOrigen(Parada origen) {
		Origen = origen;
	}

	public Parada getDestino() {
		return Destino;
	}

	public void setDestino(Parada destino) {
		Destino = destino;
	}

	public String getDuracao() {
		return Duracao;
	}

	public void setDuracao(String duracao) {
		Duracao = duracao;
	}
	
	
}
