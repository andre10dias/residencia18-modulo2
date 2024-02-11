package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class manipulaArquivo {
	
			
	public static void abrirArScrita(String nomeArquivo, String texto) throws IOException {
		// TODO Auto-generated method stub
		FileWriter fw = new FileWriter(nomeArquivo, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(texto);
		bw.newLine();
		bw.close();
		fw.close();
	}
		
	public static List<String> lerArquivo(String nomeArquivo) throws FileNotFoundException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader(nomeArquivo);
		BufferedReader br = new BufferedReader(fr);
		List<String> texto = new ArrayList<>();
		try {
			while (br.ready()) {
				texto.add(br.readLine());
			}
			br.close();
			fr.close();			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return texto;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String texto,nomeArquivo = "src\\main\\";
		List<String> result;
		
		try {
			System.out.println("digite o nome do arquivo: ");
			nomeArquivo += sc.nextLine();
			do{
				System.out.println("Digite o texto: ");
				texto = sc.nextLine();
				if(!texto.isEmpty()) {
					abrirArScrita(nomeArquivo, texto);
				}
			} while(!texto.isEmpty());
									
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			result = lerArquivo(nomeArquivo);
			
			for (String t : result) {
				System.out.println(t);
			}
		} catch (IOException e) {
			
		}
		
	}
}
