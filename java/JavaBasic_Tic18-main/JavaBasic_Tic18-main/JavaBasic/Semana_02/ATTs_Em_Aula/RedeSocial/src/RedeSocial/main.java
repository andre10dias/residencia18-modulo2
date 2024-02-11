package RedeSocial;

import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float x,y;
		x = 2;
		
		do{
			y = x;
			x = x / 2;
		}while(x>0);
		JOptionPane.showMessageDialog(null,("Presisão em float: " + y));
		
		double a,b;
		a = 2;
		do{
			b = a;
			a = a / 2;
		}while(a>0);
		JOptionPane.showMessageDialog(null,("Presisão em double: "+b));
	}

}
