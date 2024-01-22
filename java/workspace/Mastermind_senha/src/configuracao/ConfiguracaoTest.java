package configuracao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConfiguracaoTest {

	@Test
	void testSetAlfabeto() {
		Configuracao configuracao = new Configuracao();
		String alfabeto = "ABCDEFG";
		configuracao.setAlfabeto(alfabeto);
		assertEquals(alfabeto, configuracao.getAlfabeto());
		
		// ************** Caso 1: Tentar inserir uma senha null
		
//		alfabeto = null;
//		try {
//			configuracao.setAlfabeto(alfabeto);
//		} catch (Exception e) {
//			fail("Gerou exceção indevida");
//			e.printStackTrace();
//		}
//		
//		assertFalse(configuracao.getAlfabeto() == null);
		
		// ************** Caso 1: Tentar inserir uma senha com um único caracter
		
		alfabeto = "A";
		configuracao.setAlfabeto(alfabeto);
		assertBoolean(configuracao.getAlfabeto().length() > 1);
	}

	private void assertBoolean(boolean b) {
		if (!b) {
			fail("Falhou.");
		}
	}

}
