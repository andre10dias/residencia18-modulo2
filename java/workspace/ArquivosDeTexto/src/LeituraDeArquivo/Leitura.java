package LeituraDeArquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Leitura {

	public static void main(String[] args) throws IOException {
		Scanner entrada = new Scanner(System.in);
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			System.out.print("Informe o nome do arquivo: ");
			String nomeArquivo = entrada.nextLine();
			
			fr = new FileReader(nomeArquivo+".txt");
			br = new BufferedReader(fr);
			
			System.out.println("Lendo arquivo...\n");
			while(br.ready()){
				String linha = br.readLine();
				System.out.println(linha);
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao ler arquivo " + e);
			e.printStackTrace();
		} finally {
			br.close();
			fr.close();
			entrada.close();
		}

	}

}
