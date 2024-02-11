package configuracao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestConfiguracao {

	@Test
	void testSetAlfabeto() {
		Configuracao configuracao = new Configuracao();
		String alfabeto = "ABCDEFGHIJ";
		configuracao.setAlfabeto(alfabeto);
		assertEquals(alfabeto, configuracao.getAlfabeto());
	}

}
