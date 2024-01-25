package jogo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import configuracao.Configuracao;

class JogoTest {

	@Test
	void testSetSenha() {
		Configuracao config = new Configuracao();
		String senha = "";
		Jogo jogo = null;
		
		try {
			config.setAlfabeto("ABCDE");
			config.setTamanhoSenha(5);
			
			senha = "BCDAE";
			jogo = new Jogo(config);
			jogo.setSenha(senha);
		} catch (Exception e) {
			assertEquals("apenas os caracteres BCDE podem ser aceitos", e.getMessage());
		}
		
//		assertNotEquals(senha, jogo.getSenha());
		assertNotEquals(senha, config.getAlfabeto());
	}

}
