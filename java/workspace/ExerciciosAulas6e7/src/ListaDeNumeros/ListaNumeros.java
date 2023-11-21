package ListaDeNumeros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaNumeros {
	
	public List<Float> listaDeNumeros;

	public ListaNumeros() {
		listaDeNumeros = new ArrayList<>();
	}
	
	public void novoNumero(Float f) {
		this.listaDeNumeros.add(f);
	}
	
	public void listaNumeros() {
		System.out.print("[ ");
		for (Float f : listaDeNumeros) {
			System.out.print(String.format("%.1f", f) + " ");
		}
		System.out.print("]");
	}
	
	public Float media() {
		Float soma = 0f;
		
		for (Float f : listaDeNumeros) {
			soma += f;
		}
		
		return soma / listaDeNumeros.size();
	}
	
	public void ordena() {
		Collections.sort(this.listaDeNumeros);
	}
	
	public Float mediana() {
		Float mediana = 0f;
		int tamanho = this.listaDeNumeros.size();
		this.ordena();
		
		if (tamanho % 2 == 0) {
			Float m1 = this.listaDeNumeros.get(tamanho / 2);
			Float m2 = this.listaDeNumeros.get(tamanho / 2 - 1);
			mediana = (m1 + m2) / 2;
		}
		else {
			mediana = this.listaDeNumeros.get(tamanho / 2);
		}
		
		return mediana;
	}
	
	public Float colocadoEm(int n) {
		this.ordena();
		return this.listaDeNumeros.get(n);
	}

	public List<Float> getListaDeNumeros() {
		return listaDeNumeros;
	}

	public void setListaDeNumeros(List<Float> listaDeNumeros) {
		this.listaDeNumeros = listaDeNumeros;
	}
	
}
