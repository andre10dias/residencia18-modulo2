package Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pergunta {
	private String textoPergunta;
	private List<String> listaAlternativas;
	private int alternativaCorreta;
	
	public Pergunta() {
		// TODO Auto-generated constructor stub
	}

	public Pergunta(String textoPergunta, List<String> listaAlternativas, int alternativaCorreta) {
		super();
		this.textoPergunta = textoPergunta;
		this.listaAlternativas = listaAlternativas;
		this.alternativaCorreta = alternativaCorreta;
	}
	
	public static Pergunta criarPergunta(String textoPergunta, List<String> listaAlternativas, int alternativaCorreta) {
		return new Pergunta(textoPergunta, listaAlternativas, alternativaCorreta);
	}
	
	public static Pergunta executaPergunta(List<Pergunta> listaPerguntas) {
		Random random = new Random();
		int index = random.nextInt(listaPerguntas.size()-1);
		
		return listaPerguntas.get(index);
	}
	
	public boolean verificaRespostaCorreta(Pergunta pergunta, int resposta) {
		if (pergunta.alternativaCorreta == resposta) {
			return true;
		}
		
		return false;
	}

	public String getTextoPergunta() {
		return textoPergunta;
	}

	public void setTextoPergunta(String textoPergunta) {
		this.textoPergunta = textoPergunta;
	}

	public List<String> getListaAlternativas() {
		if (this.listaAlternativas == null) {
			listaAlternativas = new ArrayList<>();
		}
		
		return listaAlternativas;
	}

	public void setListaAlternativas(List<String> listaAlternativas) {
		this.listaAlternativas = listaAlternativas;
	}

	public int getAlternativaCorreta() {
		return alternativaCorreta;
	}

	public void setAlternativaCorreta(int alternativaCorreta) {
		this.alternativaCorreta = alternativaCorreta;
	}
	
}
