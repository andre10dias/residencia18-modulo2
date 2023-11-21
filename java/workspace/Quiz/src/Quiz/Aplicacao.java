package Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String ehAlternativaCorreta, opcao;
		String textoPergunta, resposta;
		String alternativa;
		int alternativaCorreta = -1;
		List<Pergunta> listaPerguntas;
		
		do {
			List<String> listaAlternativas = new ArrayList<>();
			listaPerguntas = new ArrayList<>();
			
			System.out.println("Criar perguntas:");
			
			System.out.println("\nDigite a pergunta: ");
			textoPergunta = entrada.nextLine();
			
			System.out.println("\nDigite 4 alternativas:");
			for (int i = 0; i < 4; i++) {			
				System.out.print("\nAlternativa " + i + ": ");
				alternativa = entrada.nextLine();
				
				listaAlternativas.add(alternativa);
				
				System.out.println("\nEsta é a alternativa correta? ");
				System.out.print("\n[ 1 ] Sim\t[ 2 ] Não");
				ehAlternativaCorreta = entrada.nextLine();
				
				if (ehAlternativaCorreta == "1") {
					alternativaCorreta = i;
				}
			}
			
			Pergunta pergunta = Pergunta.criarPergunta(textoPergunta, listaAlternativas, alternativaCorreta);
			listaPerguntas.add(pergunta);
			
			System.out.println("\nDeseja criar uma nova pergunta? ");
			System.out.print("\n[ 1 ] Sim\t[ 2 ] Não");
			opcao = entrada.nextLine();
		} while (!opcao.equals(2));
		
		int respostasCorretas = 0;
		for (Pergunta pergunta : listaPerguntas) {			
			Pergunta p = Pergunta.executaPergunta(listaPerguntas);
			respostasCorretas = 0;
			
			p.getTextoPergunta();
			resposta = entrada.nextLine();
			
			if (Integer.parseInt(resposta) == p.getAlternativaCorreta()) {
				respostasCorretas++;
			}
		}
		
		System.out.println("\nResultado final: ");
		System.out.println(respostasCorretas + " corretas de " + listaPerguntas.size() + "questões.");

	}

}
