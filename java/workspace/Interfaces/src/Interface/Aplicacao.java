package Interface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Aplicacao {

	public static void main(String[] args) {

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        List<Date> datas = new ArrayList<>();
        
		try {
			datas = List.of(
					format.parse("01/01/1980"),
					format.parse("15/12/1995"),
					format.parse("20/04/2003"),
					format.parse("30/11/1978")
			);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DatasDeNascimento dadosNascimento = new DatasDeNascimento(datas);
		
		System.out.println("Datas: ");
        System.out.println("Máximo: " + dadosNascimento.maximo());
        System.out.println("Mínimo: " + dadosNascimento.minimo());
        System.out.println("Ordenado: " + dadosNascimento.ordenar());
        System.out.println("Buscar \"20/04/2003\": " + dadosNascimento.buscar("20/04/2003"));
        
        System.out.println("-------------------------------------------------------------------------");
        
        CidadesDoBrasil cidades = new CidadesDoBrasil(List.of("São Paulo", "Rio de Janeiro", "Brasília", "Salvador"));
        
        System.out.println("Cidades: ");
        System.out.println("Máximo: " + cidades.maximo());
        System.out.println("Mínimo: " + cidades.minimo());
        System.out.println("Ordenado: " + cidades.ordenar());
        System.out.println("Buscar \"Rio de Jameiro\": " + cidades.buscar("Rio de Janeiro"));
        
        System.out.println("-------------------------------------------------------------------------");
        
        TemperaturasDoPeriodo temperaturas = new TemperaturasDoPeriodo(List.of(25, 30, 20, 35));
        
        System.out.println("Temperaturas: ");
        System.out.println("Máximo: " + temperaturas.maximo());
        System.out.println("Mínimo: " + temperaturas.minimo());
        System.out.println("Ordenado: " + temperaturas.ordenar());
        System.out.println("Buscar \"30\": " + temperaturas.buscar("30"));

	}

}
