package exe_01_10;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Pergunta {
	String Texto;
	ArrayList<String> alternativas;
	int resposta;

	public Pergunta() {
		alternativas = new ArrayList<String>();
	}

	public Pergunta(String texto, ArrayList<String> alternativas, int resposta) {
		Texto = texto;
		this.alternativas = alternativas;
		this.resposta = resposta;
	}

	public String getTexto() {
		return Texto;
	}

	public void setTexto(String texto) {
		Texto = texto;
	}

	public ArrayList<String> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(ArrayList<String> alternativas) {
		this.alternativas = alternativas;
	}

	public int getResposta() {
		return resposta;
	}

	public void setResposta(int resposta) {
		this.resposta = resposta;
	}

	public Pergunta GerarPerguntas() {
		Pergunta pergunta = new Pergunta();
		ArrayList<String> alternativas = new ArrayList<String>();
		pergunta.setTexto(JOptionPane.showInputDialog("###### Gerando pergunta ######\nPergunta: "));
		for (int i = 0; i < 4; i++) {
			alternativas.add(JOptionPane.showInputDialog("Alternativa " + (i + 1) + ": "));
		}
		pergunta.setAlternativas(alternativas);
		pergunta.setResposta(Integer.parseInt(JOptionPane.showInputDialog("Qual a Resposta: (Entre 1 e 4)")));
		return pergunta;
	}

	public static ArrayList<int[]> Quiz(ArrayList<Pergunta> perguntas) {
		int qtd_questoes = perguntas.size();
		int resposta;
		ArrayList<int[]> respostas = new ArrayList<>();
		String str = "";
		JOptionPane.showMessageDialog(null, "Bem vindo ao Quiz JavaDev!!\n" + "Qual o seu nome?");
		String nome = JOptionPane.showInputDialog("Informe seu nome?");
		JOptionPane.showMessageDialog(null, "Ola " + nome + "!!");
		JOptionPane.showMessageDialog(null,
				"Voce tem " + qtd_questoes + " questões para responder!!\n Voce esta preparado!!");
		for (Pergunta pergunta : perguntas) {
			for (int i = 0; i < pergunta.getAlternativas().size(); i++) {
				str += (i + 1) + ": " + pergunta.getAlternativas().get(i) + "\n";
			}
			System.out.println(str);
			resposta = Integer.parseInt(JOptionPane.showInputDialog("Vamos responder a pergunta "
					+ (perguntas.indexOf(pergunta) + 1) + ": \n" + pergunta.getTexto() + ":\n" + str));
			respostas.add(new int[] { perguntas.indexOf(pergunta), resposta });
		}
		return respostas;
	}
	
	public static int MenuPrincipal() {
		return Integer.parseInt(JOptionPane.showInputDialog("######### MENU PRINCIPAL #######\n"
				+ "1 - Gerar Pergunta\n2 - Iniciar Quiz\n0 - Sair\n"));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pergunta pergunta = new Pergunta();
		ArrayList<Pergunta> perguntas = new ArrayList<Pergunta>();
		ArrayList<int[]> respostas = new ArrayList<>();
		int opcao;
		do {
			opcao = MenuPrincipal();
			switch (opcao) {
			case 1:
				perguntas.add(pergunta.GerarPerguntas());
				break;
			case 2:
				respostas = Quiz(perguntas);
				break;
			default:
				break;
				
			}
			
		}while (opcao != 0);
		
	}

}
