package gerenciarCompras;

public class Compra {
	private String nome;
	private double valor;
	
	public Compra(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public static Compra gerarCompra() {
		System.out.println("Nome: ");
		String nome = System.console().readLine();
		System.out.println("Valor: ");
		double valor = Double.parseDouble(System.console().readLine());
		return new Compra(nome, valor);
	}
	
	public void imprimir() {
		System.out.println("Nome: " + this.getNome());
		System.out.println("Valor: " + this.getValor());
	}
}
