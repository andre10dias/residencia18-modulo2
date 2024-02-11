package Model;

import CixaEletronicoException.MutiploExeption;
import CixaEletronicoException.SaldoInsuficienteExeption;

public class CaixaEletronico {
	float saldo;
	
	public CaixaEletronico(float saldo) {
		this.saldo = saldo;
	}
	
	public void sacar(float valor) throws SaldoInsuficienteExeption, MutiploExeption {
		if (valor > saldo) {
			throw new SaldoInsuficienteExeption(saldo);
		}
		if (valor % 10 != 0) {
			throw new MutiploExeption(valor);
		}
		saldo -= valor;
	}
	// versão 2 de sacar Exception Não checada
	public void sacar2(float valor){
		if (valor > saldo) {
			throw new SaldoInsuficienteExeption(saldo);
		}
		if (valor % 10 != 0) {
			throw new MutiploExeption(valor);
		} 
		saldo -= valor;
	}
	
	public static void main(String[] args) {
		CaixaEletronico caixaEletronico = new CaixaEletronico(100);
		
		try {
			caixaEletronico.sacar(1000);
			System.out.println("Saque realizado com sucesso");
		}catch (SaldoInsuficienteExeption | MutiploExeption e) {
			System.out.println(e.getMessage());
		}
	}
}
