package cripitografa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Cripitografa {
	public static void process(String img, String img2, String senha) {
		byte c;
		try {
			FileInputStream file = new FileInputStream(img);
			FileOutputStream copia = new FileOutputStream(img2);
			String senhaCriptografada = senha;
			
			boolean eof = false;
			int count = 0;
			int i = 0;
			while (!eof) {
				int input = file.read();
				if(i >= senhaCriptografada.length()) {
					i = 0;
				}
				if (input != -1) {
					c = (byte) (input ^ senhaCriptografada.charAt(i));
					copia.write(c);
					count++;
					i++;
				} else
					eof = true;
			}
			file.close();
			copia.close();
			System.out.println("\nBytes lidos: " + count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
