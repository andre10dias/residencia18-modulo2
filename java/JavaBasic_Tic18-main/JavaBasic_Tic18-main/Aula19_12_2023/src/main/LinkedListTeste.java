package main;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTeste {
	List list = new LinkedList();
	
	public void add(String nome) {
		this.list.add(nome);
	}
	
	public void imprime() {
		this.list.forEach((nome) -> System.out.println(nome));
	}
	
	public void imprimeInverso() {
		ListIterator it = list.listIterator(list.size());
		while(it.hasPrevious()) {
			System.out.println(it.previous());
		}
	}
	
	public static void main(String[] args) {
		LinkedListTeste teste = new LinkedListTeste();
		teste.add("João");
		teste.add("Maria");
		teste.add("Pedro");
		teste.add("Joaquim");
		System.out.println("Conteudo da lista:");
		teste.imprime();
		System.out.println("Conteudo da lista invertida:");
		teste.imprimeInverso();
	}
}
