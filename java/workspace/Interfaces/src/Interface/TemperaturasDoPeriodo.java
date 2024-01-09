package Interface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TemperaturasDoPeriodo implements DadosEstatisticos {
	
	private List<Integer> temperaturas;

    public TemperaturasDoPeriodo(List<Integer> temperaturas) {
        this.temperaturas = temperaturas;
    }

	@Override
	public String maximo() {
		return Collections.max(temperaturas).toString();
	}

	@Override
	public String minimo() {
		return Collections.min(temperaturas).toString();
	}

//	@Override
//	public List<Integer> ordenar() {
//		List<Integer> ordenado = new ArrayList<>(temperaturas);
//        Collections.sort(ordenado);
//        
//        return ordenado;
//	}
	
	@Override
    public List<String> ordenar() {
        List<String> ordenado = new ArrayList<>();
        
        for (Integer temperatura : temperaturas) {
            ordenado.add(temperatura.toString());
        }
        
        Collections.sort(ordenado);
        return ordenado;
    }

	@Override
	public boolean buscar(String valor) {
		try {
            int temperaturaParaBuscar = Integer.parseInt(valor);
            return temperaturas.contains(temperaturaParaBuscar);
        } catch (NumberFormatException e) {
            // Tratar exceção se o valor não for um número válido
            e.printStackTrace();
            return false;
        }
	}

}
