package Model;

import IdadeException.IdadeMaiorExeption;
import IdadeException.IdadeNegativaExeption;

public class ValidadorIdade {
	int idade;
	
	public ValidadorIdade(int idade) throws IdadeMaiorExeption, IdadeNegativaExeption{
		if (idade < 0) {
			throw new IdadeNegativaExeption();
		}else if (idade > 150) {
			throw new IdadeMaiorExeption(idade);
		}
		this.idade = idade;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public static void main(String[] args) {
		try {
			ValidadorIdade validadorIdade = new ValidadorIdade(200);
		} catch (IdadeMaiorExeption e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IdadeNegativaExeption e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
}
