package Model;

import java.io.File;

import ArquivoException.ArquivoNaoEncontradoException;

public class ManipulaArquivo {
	String nomeArquivo;
	
	public ManipulaArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	
	public File AbrirArquivo(String nomeArquivo) {
		File file = new File(nomeArquivo);
		if (!file.exists()) {
			throw new ArquivoNaoEncontradoException(nomeArquivo);
		}else {
			return file;
		}
	}
	
	public static void main(String[] args) {
		ManipulaArquivo manipulaArquivo = new ManipulaArquivo("teste.txt");
		try {
			manipulaArquivo.AbrirArquivo("teste.txt");
			System.out.println("Arquivo encontrado");
		}catch (ArquivoNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
