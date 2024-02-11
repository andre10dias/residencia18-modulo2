package src;

public class TemperaturaDoPeriodo implements DadosEstatisticos {
	
	float temperatura;
	
	public TemperaturaDoPeriodo(float temperatura) {
		this.temperatura = temperatura;
	}
	
	public float getTemperatura() {
		return temperatura;
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
		return "TemperaturaDoPeriodo = " + temperatura;
	}
}
