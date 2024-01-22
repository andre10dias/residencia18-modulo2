package EscritaDeArquivo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Escrita {

	public static void main(String[] args) throws IOException {
		Scanner entrada = new Scanner(System.in);
		FileWriter fw = null;
		BufferedWriter bw = null;
		String texto = null;
		
		try {			
			System.out.print("Informe o nome do arquivo: ");
			String nomeArquivo = entrada.nextLine();
			
			System.out.println("Digite um texto para o arquivo:");
			File file = new File(nomeArquivo+".txt");
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			do {				
				texto = entrada.nextLine();
				bw.write(texto);
				bw.newLine();
			} while (!texto.isEmpty());
		} catch (Exception e) {
			System.out.println("Erro ao criar arquivo " + e);
			e.printStackTrace();
		} finally {
			bw.close();
			fw.close();
			entrada.close();
		}

	}

}
