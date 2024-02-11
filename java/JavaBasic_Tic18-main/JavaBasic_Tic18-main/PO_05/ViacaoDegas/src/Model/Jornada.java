package Model;

import java.util.ArrayList;
import java.util.Date;

public class Jornada {
	
	private ArrayList<Embarque> embarques;
	private Date dataHoraInicio;
	private Date dataHoraFim;
	private Motorista motorista;
	private Motorista cobrador;
	private Veiculo veiculo;
	private Trageto trageto;
	
	public Jornada(Motorista motorista, Veiculo veiculo, Trageto trageto) {
		this.motorista = motorista;
		this.veiculo = veiculo;
		this.trageto = trageto;
		this.embarques = new ArrayList<Embarque>();
	}

	public Date getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void IniciarJornada() {
		this.dataHoraInicio = new Date();
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Motorista getCobrador() {
		return cobrador;
	}

	public void setCobrador(Motorista cobrador) {
		this.cobrador = cobrador;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Date getDataHoraFim() {
		return dataHoraFim;
	}

	public Trageto getTrageto() {
		return trageto;
	}
	
	public void addEmbarque(Embarque embarque) {
		this.embarques.add(embarque);
	}
	
	public void checkpoint() {
		this.dataHoraFim = new Date();
	}
}
