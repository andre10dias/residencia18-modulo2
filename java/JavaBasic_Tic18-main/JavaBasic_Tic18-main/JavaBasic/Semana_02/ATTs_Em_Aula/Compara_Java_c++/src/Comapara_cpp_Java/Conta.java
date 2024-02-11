package Comapara_cpp_Java;

public class Conta {
	int numero;
	Cliente Cliente;
	float saldo;
	
	public Conta(int numero, String nome, float saldo) {
		this.numero = numero;
		
		this.saldo = saldo;
	}
	
	public Conta() {
		super();
	}

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Cliente getCliente() {
		return Cliente;
	}
	public void setCliente(Cliente nome) {
		this.Cliente = nome;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public void deposita(float valor) {
		this.saldo+= valor;
	}
	
	public void consuta() {
		System.out.println("Nome: " + Cliente.getNome() +
						   "\nSaldo: " + saldo +
						   "\nNumero: " + numero);
	}
	
	public void saque(float valor) {
		if(valor <= saldo) {
			saldo-=valor;
		}else {
			System.out.println("Saldo insuficiente para saque desse valor !");
		}
	}
}
