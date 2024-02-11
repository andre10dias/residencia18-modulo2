package Facade;

import javax.swing.JOptionPane;

public class Utilites {
	public static int Menu1() {
		int opc = -1;
		do {
			try {
				opc = Integer.parseInt(JOptionPane.showInputDialog("1- Gerincia \n2- Motorista\n0- Sair"));
				if (opc<0 || opc>2) {
					JOptionPane.showMessageDialog(null, "Opção Inválida");
				}
			}catch(Exception e) {
				
			}
		} while (opc!=0);
		return opc;
	}
}
