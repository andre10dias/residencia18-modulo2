package Interface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class DatasDeNascimento implements DadosEstatisticos {
	
	private List<Date> datas;
	
	public DatasDeNascimento(List<Date> datas) {
        this.datas = datas;
    }

//	@Override
//	public int maximo() {
//		LocalDate maxDate = datas.stream()
//                .map(date -> date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
//                .max(LocalDate::compareTo)
//                .orElse(LocalDate.MIN);
//
//        return maxDate.getDayOfMonth();
//	}
//
//	@Override
//	public int minimo() {
//		LocalDate minDate = datas.stream()
//                .map(date -> date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
//                .min(LocalDate::compareTo)
//                .orElse(LocalDate.MAX);
//
//        return minDate.getDayOfMonth();
//	}
	
	@Override
	public String maximo() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    Date maxDate = Collections.max(datas);
	    
	    return sdf.format(maxDate);
	}

	@Override
	public String minimo() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    Date minDate = Collections.min(datas);
	    
	    return sdf.format(minDate);
	}

//	@Override
//	public List<Integer> ordenar() {
//		List<Integer> ordenado = new ArrayList<>();
//		
//        datas.stream()
//                .map(date -> date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfMonth())
//                .forEach(ordenado::add);
//        
//        Collections.sort(ordenado);
//        return ordenado;
//	}
	
	@Override
	public List<String> ordenar() {
		List<String> listaOrdenada = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        datas.stream()
                .sorted()
                .forEach(date -> listaOrdenada.add(sdf.format(date)));

        return listaOrdenada;
	}

//	@Override
//    public boolean buscar(int valor) {
//        return datas.stream()
//                .anyMatch(date -> date.toInstant().atZone(ZoneId.systemDefault())
//                        .toLocalDate().getDayOfMonth() == valor);
//    }

    public boolean buscar(String valor) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            Date dataParaBuscar = sdf.parse(valor);
            return datas.contains(dataParaBuscar);
        } catch (ParseException e) {
            // Tratar exceção de formato de data inválido
            e.printStackTrace();
            return false;
        }
    }

}
