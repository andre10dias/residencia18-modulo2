package configuration;

import utilit.Utilit;

public class Configuracao {
	private String nome;
	private String alfabeto;
	private int tamanhoSenha;
	private int maxTentativas;

	public Configuracao(String nome, String alfabeto, int tamanhoSenha, int maxTentativas) {
		super();
		setNome(nome);
		setAlfabeto(alfabeto);
		setTamanhoSenha(tamanhoSenha);
		setMaxTentativas(maxTentativas);
	}

	public Configuracao() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAlfabeto() {
		return alfabeto;
	}

	public void setAlfabeto(String alfabeto) {
		if (alfabeto == null) {
			throw new IllegalArgumentException("Alfabeto não pode ser nulo");
		}
		if (alfabeto.length() < 5) {
			throw new IllegalArgumentException("Alfabeto deve ter pelo menos 5 caracteres");
		}
		if (Utilit.verificarRepeticaoCaracteres(alfabeto)) {
			throw new IllegalArgumentException("Alfabeto não deve conter caracteres repetidos");
		}
		if (Utilit.verificarTemNumero(alfabeto)) {
			throw new IllegalArgumentException("Alfabeto não deve conter números");
		}
		this.alfabeto = alfabeto;
	}

	public int getTamanhoSenha() {
		return tamanhoSenha;
	}

	public void setTamanhoSenha(int tamanhoSenha) {
		this.tamanhoSenha = tamanhoSenha;
	}

	public int getMaxTentativas() {
		return maxTentativas;
	}

	public void setMaxTentativas(int maxTentativas) {
		this.maxTentativas = maxTentativas;
	}

	@Override
	public String toString() {
		return "Configuracao [nome=" + nome + ", alfabeto=" + alfabeto + ", tamanhoSenha=" + tamanhoSenha
				+ ", maxTentativas=" + maxTentativas + "]";
	}

}
