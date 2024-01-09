package Interface;

import java.util.List;

public interface DadosEstatisticos {
	
	public String maximo();
	public String minimo();
	public List<String> ordenar();
	public boolean buscar(String valor);

}
