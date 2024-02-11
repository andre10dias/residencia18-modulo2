package configuration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestConfiguracao {

	@Test
	void testSteAlfabeto() {
		Configuracao configuracao = new Configuracao();
		
		String senha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		try {
			configuracao.setAlfabeto(senha);
		}catch(IllegalArgumentException e) {
			fail("Gerou uma exceção invalida");
			e.printStackTrace();
		}
		assertEquals(configuracao.getAlfabeto(), senha);
		
		senha = null;
		
		try {
			configuracao.setAlfabeto(senha);
		}catch(Exception e) {
			assertEquals("Alfabeto não pode ser nulo", e.getMessage());
		}
		assertFalse(configuracao.getAlfabeto()==null);
		
		senha = "A";
		
		try {
			configuracao.setAlfabeto(senha);
		}catch(Exception e) {
			assertEquals("Alfabeto deve ter pelo menos 5 caracteres", e.getMessage());
		}
		assertFalse(configuracao.getAlfabeto().length() < 5);
		
		senha = "aabddce";
		
		try {
			configuracao.setAlfabeto(senha);
		}catch(Exception e) {
			assertEquals("Alfabeto não deve conter caracteres repetidos", e.getMessage());
		}
		assertNotEquals(senha, configuracao.getAlfabeto());
		
		senha = "abc9rde";
		
		try {
			configuracao.setAlfabeto(senha);
		}catch(Exception e) {
			assertEquals("Alfabeto não deve conter números", e.getMessage());
		}
		assertNotEquals(senha, configuracao.getAlfabeto());
	}

}
