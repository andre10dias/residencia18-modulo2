package SobrecargaConstrutor;

public class Projeto {
	
	private int codigo;
	private String nome;
	private Double orcamento;
	private Engenheiro engenheiro;
	
	public Projeto(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public Projeto(int codigo, String nome, Double orcamento) {
		this(codigo, nome);
		this.orcamento = orcamento;
	}
	
	public Projeto(int codigo, String nome, Double orcamento, Engenheiro engenheiro) {
		this(codigo, nome, orcamento);
		this.engenheiro = engenheiro;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setEngenheiro(Engenheiro engenheiro) {
		this.engenheiro = engenheiro;
	}
	
	public Engenheiro getEngenheiro() {
		return engenheiro;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setOrcamento(Double orcamento) {
		this.orcamento = orcamento;
	}
	
	public Double getOrcamento() {
		return orcamento;
	}
	
	public void imprimir() {
		System.out.println("Código: " + getCodigo());
		System.out.println("Nome Projeto: " + getNome());
		if (getOrcamento() != null) {
			System.out.println("Orcamento: " + getOrcamento());
		}
		if (getEngenheiro() != null) {
			getEngenheiro().imprimir();
		}
	}
	
	public static void main(String[] args) {
		Projeto p = new Projeto(1, "Projeto 1");
		Engenheiro e = new Engenheiro("Engenheiro 1", "123456");
		p.setEngenheiro(e);
		p.imprimir();
				
	}
}
