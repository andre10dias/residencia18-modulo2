package model;

import java.io.IOException;
import java.util.ArrayList;

import persistencia.ClienteJson;

public class Cliente {
	String nome;
	String cpf;
	String cnh;
	
	public Cliente(String nome, String cpf, String cnh) {
		this.nome = nome;
		this.cpf = cpf;
		this.cnh = cnh;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getCnh() {
		return cnh;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	
	public String toString() {
		return nome + " - " + cpf + " - " + cnh;
	}
	
	public static void main(String[] args) {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		clientes.add(new Cliente("João", "123.456.789-00", "123456789"));
		clientes.add(new Cliente("Maria", "987.654.321-00", "987654321"));
		clientes.add(new Cliente("Pedro", "456.789.123-00", "456789123"));
		clientes.add(new Cliente("Ana", "321.654.987-00", "321654987"));
		clientes.add(new Cliente("Lucas", "789.123.456-00", "789123456"));
		
		try {
			ClienteJson.SalvarCliente(clientes, "clientes");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
