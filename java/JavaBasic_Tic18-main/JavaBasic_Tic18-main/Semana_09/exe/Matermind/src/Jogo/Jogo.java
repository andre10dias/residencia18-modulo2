package Jogo;

import configuration.Configuracao;

public class Jogo {
	Configuracao configuracao;
	String senha;
	int qtdTentativas;
	
	public Jogo(Configuracao configuracao) {
		this.configuracao = configuracao;
		this.qtdTentativas = 0;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {		
		this.senha = senha;
	}

	public int getQtdTentativas() {
		return qtdTentativas;
	}

	public void setQtdTentativas(int qtdTentativas) {
		this.qtdTentativas = qtdTentativas;
	}
	
	

}
