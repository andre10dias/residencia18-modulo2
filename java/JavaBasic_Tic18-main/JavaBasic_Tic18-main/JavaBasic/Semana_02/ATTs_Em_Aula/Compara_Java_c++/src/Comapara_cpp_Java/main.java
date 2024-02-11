package Comapara_cpp_Java;

import java.util.ArrayList;
import java.util.Scanner;

import Classes.Cliente;

public class main {
	static Scanner scan;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scan = new Scanner(System.in);
		
		Conta conta = new Conta();
		
		ArrayList <Conta> contas = new ArrayList();;
		
		String opc;
		
		do {
			contas = addConta(contas);
			System.out.println("Deseja cadastrar mais contas?(s/n)");
			opc = scan.next();
		}while(!opc.equals("n"));
		
		for(Conta c: contas) {
			System.out.println("--------------- Clientes -------------");
			c.consuta();
			System.out.println("----------------------------");
		}
			
	}
	
	public static ArrayList<Conta> addConta(ArrayList<Conta> cs) {
		Conta c = new Conta();
		Cliente cli = new Cliente();
		scan = new Scanner(System.in);
		
		System.out.println("Informe o nome do portador: ");
		cli.setNome(scan.nextLine());
		System.out.println("Informe o CPF do portador: ");
		cli.setCpf(scan.nextLine());
		System.out.println("Informe a Idade do portador: ");
		cli.setIdade(scan.nextInt());
		c.setCliente(cli);
		System.out.println("Informe o numero da Conta: ");
		c.setNumero(scan.nextInt());
		System.out.println("Informe o saldo inicial: ");
		c.setSaldo(scan.nextFloat());
		cs.add(c);
		return cs;
	}
}
