package quadrado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuadradoTest {

	@Test
	void testInverte() {
		Quadrado qd = new Quadrado("XXOXOXOXX");
		qd.inverte(0);
		assertEquals("OXOXOXOXX", qd.getEstado());
	}
	@Test
	void testEstados() {
		Quadrado qd = new Quadrado("XXOXOXOXX");
		// estado 1: clicar(1)
		qd.clicar(1);
		assertEquals("OOOOOXOXX", qd.getEstado());
		// estado 2: clicar(2)
		qd.setEstado("XXOXOXOXX");
		qd.clicar(2);
		assertEquals("OOXXOXOXX", qd.getEstado());
		// estado 3: clicar(3)
		qd.setEstado("XXOXOXOXX");
		qd.clicar(3);
		assertEquals("XOXXOOOXX", qd.getEstado());
		// estado 4: clicar(4)
		qd.setEstado("XXOXOXOXX");
		qd.clicar(4);
		assertEquals("OXOOOXXXX", qd.getEstado());
		// estado 5: clicar(5)
		qd.setEstado("XXOXOXOXX");
		qd.clicar(5);
		assertEquals("XOOOXOOOX", qd.getEstado());
		// estado 6: clicar(6)
		qd.setEstado("XXOXOXOXX");
		qd.clicar(6);
		assertEquals("XXXXOOOXO", qd.getEstado());
		// estado 7: clicar(7)
		qd.setEstado("XXOXOXOXX");
		qd.clicar(7);
		assertEquals("XXOOOXXOX", qd.getEstado());
		// estado 8: clicar(8)
		qd.setEstado("XXOXOXOXX");
		qd.clicar(8);
		assertEquals("XXOXOXXOO", qd.getEstado());
		// estado 9: clicar(9)
		qd.setEstado("XXOXOXOXX");
		qd.clicar(9);
		assertEquals("XXOXOOOOO", qd.getEstado());
	}
	
	@Test
	void testPosicaoValida() {
		Quadrado qd = new Quadrado("XXOXOXOXX");
		try {
			qd.clicar(10);
		}catch(IllegalArgumentException e) {
			assertEquals("Posição inválida! 10", e.getMessage());
		}
	}
}
