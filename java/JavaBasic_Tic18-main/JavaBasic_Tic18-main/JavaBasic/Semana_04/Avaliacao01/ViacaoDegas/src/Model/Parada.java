package Model;

public abstract class Parada {

	private String descricao;
	private String CEP;
	private String Cidade;
	private String UF;
	
	public Parada(String descricao, String CEP, String Cidade, String UF) {
		this.descricao = descricao;
		this.CEP = CEP;
		this.Cidade = Cidade;
		this.UF = UF;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String nome) {
		this.descricao = nome;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getCidade() {
		return Cidade;
	}

	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}
	

}
