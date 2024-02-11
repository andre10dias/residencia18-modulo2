package main;

import java.util.Arrays;
import java.util.List;

public class ArrayS {
	String array[];
	List<String> lista;
	
	public ArrayS(int tam) {
		this.array =  new String[tam];
	}
	
	public int Busca(String nome){
		for (int i = 0; i < array.length; i++) {
			if(array[i].equals(nome)){
				return i;
			}
		}
		return -1;
	}
	
	public void Add(String nome, int pos){
		try {
			this.array[pos] = nome;
		}catch (Exception e) {
			System.out.println("Posição inválida");
		}
		
	}
	
	public void atualiza(String nome, int pos){
		try {
			this.array[pos] = nome;
		}catch (Exception e) {
			System.out.println("Posição inválida");
		}
	}
	
	public void imprimeElemento(int pos){
		try {
			System.out.println(this.array[pos]);
		}catch (Exception e) {
			System.out.println("Posição inválida");
		}
	}
	
	public void imprime(){
		for (int i = 0; i < array.length; i++) {
			System.out.println(this.array[i]);
		}
	}
	
	public void ConverteArrayEmLista(){
		List<String> lista = Arrays.asList(this.array);
	}
	
	public int bucar(String nome){
		this.lista.sort(null);
		
		return this.lista.indexOf(nome);
	}
	public void Add(String nome){
		this.lista.add(nome);
	}
	
	public void atualiza(String nome, String novonome){
		try {
			this.lista.set(this.bucar(nome), novonome);
		}catch (Exception e) {
			System.out.println("Posição inválida");
		}
	}
	
	
	public static void main(String[] args) {
		ArrayS array = new ArrayS(5);
		array.Add("João", 0);
		array.Add("Maria", 1);
		array.Add("Pedro", 2);
		array.Add("juana", 3);
		array.Add("Lucas", 4);
		
		System.out.println("Litano todo o array: ");
		
		array.imprime();
		
		System.out.println("Lucas esta na posição: " + array.Busca("Lucas"));
		
		System.out.println("Atualizando Lucas: ");
		
		array.atualiza("Lucas Santos", 4);
		
		array.imprimeElemento(4);
		
		
		
	}
	
}
