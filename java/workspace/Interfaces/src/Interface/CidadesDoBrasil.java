package Interface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CidadesDoBrasil implements DadosEstatisticos {
	
	private List<String> cidades;

    public CidadesDoBrasil(List<String> cidades) {
        this.cidades = cidades;
    }

//	@Override
//	public int maximo() {
//		return Collections.max(cidades, (s1, s2) -> 
//			Integer.compare(s1.length(), s2.length())
//		).length();
//	}
//
//	@Override
//	public int minimo() {
//		return Collections.min(cidades, (s1, s2) -> 
//			Integer.compare(s1.length(), s2.length())
//		).length();
//	}
    
    @Override
    public String maximo() {
        String maxCidade = Collections.max(cidades, (s1, s2) -> 
        	Integer.compare(s1.length(), s2.length())
    	);
        
        return maxCidade;
    }

    @Override
    public String minimo() {
        String minCidade = Collections.min(cidades, (s1, s2) -> 
        	Integer.compare(s1.length(), s2.length())
    	);
        
        return minCidade;
    }

//	@Override
//	public List<Integer> ordenar() {
//		List<Integer> ordenado = new ArrayList<>();
//		
//        for (String cidade : cidades) {
//            ordenado.add(cidade.length());
//        }
//        
//        Collections.sort(ordenado);
//        return ordenado;
//	}
    
    @Override
    public List<String> ordenar() {
        List<String> ordenado = new ArrayList<>(cidades);
        
        Collections.sort(ordenado, (s1, s2) -> 
        	Integer.compare(s1.length(), s2.length())
        );
        
        return ordenado;
    }

//	@Override
//    public boolean buscar(int valor) {
//        // Implementação original do método buscar(int valor)
//        for (String cidade : cidades) {
//            if (cidade.length() == valor) {
//                return true;
//            }
//        }
//        return false;
//    }
	
	@Override
    public boolean buscar(String valor) {
        return cidades.contains(valor);
    }

}
