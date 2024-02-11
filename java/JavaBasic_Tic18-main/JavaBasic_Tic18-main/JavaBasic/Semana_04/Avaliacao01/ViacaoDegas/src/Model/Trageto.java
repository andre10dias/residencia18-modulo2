package Model;

import java.util.ArrayList;
import java.util.Date;

public class Trageto {
	private ArrayList<Trecho> Trechos;
	private Parada Origen;
	private Date dataHoraInicio;
	
	public Trageto(Parada Origen, ArrayList<Trecho> Trechos) {
		this.Origen = Origen;
		this.Trechos = Trechos;
	}
	
	public void IniciarTrageto() {
		this.dataHoraInicio = new Date();
	}
	
	public Date getdataHoraInicio() {
		return dataHoraInicio;
	}
	
	public Parada getOrigen() {
		return Origen;
	}

	public void setOrigen(Parada origen) {
		Origen = origen;
	}

	public ArrayList<Trecho> getTrechos() {
		return Trechos;
	}
	
	public void addTrecho(Trecho trecho) {
		this.Trechos.add(trecho);
	}
}
