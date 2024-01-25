package jogo;

import configuracao.Configuracao;

public class Jogo {
	
	private Configuracao configuracao;
	private String senha;
	private Integer qtdTentativas;
	
	public Jogo(Configuracao configuracao) {
		super();
		this.configuracao = configuracao;
	}

	public Jogo(Configuracao configuracao, String senha, Integer qtdTentativas) {
		this.configuracao = configuracao;
		this.senha = senha;
		this.qtdTentativas = qtdTentativas;
	}

	public Configuracao getConfiguracao() {
		return configuracao;
	}

	public void setConfiguracao(Configuracao configuracao) {
		this.configuracao = configuracao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getQtdTentativas() {
		return qtdTentativas;
	}

	public void setQtdTentativas(Integer qtdTentativas) {
		this.qtdTentativas = qtdTentativas;
	}
	

}
