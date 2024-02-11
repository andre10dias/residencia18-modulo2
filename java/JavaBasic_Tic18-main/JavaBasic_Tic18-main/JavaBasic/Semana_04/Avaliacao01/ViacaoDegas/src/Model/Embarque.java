package Model;
import java.util.*;
public class Embarque {
	private Date dataHora;
	private Passageiro passageiro;
	private Parada parada;
	
	public Embarque(Date dataHora, Passageiro passageiro, Parada parada) {
		this.dataHora = dataHora;
		this.passageiro = passageiro;
		this.parada = parada;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	public Parada getParada() {
		return parada;
	}

	public void setParada(Parada parada) {
		this.parada = parada;
	}
	
	
}
