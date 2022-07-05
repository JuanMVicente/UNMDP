package prueba;

import excepsiones.ExcepsionesLogIn;
import modelo.Usuario;

public class Prueba {

	public static void main(String[] args) throws ExcepsionesLogIn {
		// TODO Auto-generated method stub
		
		Usuario a = new Usuario("Ion123", "SosCra");
		Usuario b = new Usuario("", "SosCra");
		Usuario c = new Usuario("Ion123", "Sos");
	}

}
