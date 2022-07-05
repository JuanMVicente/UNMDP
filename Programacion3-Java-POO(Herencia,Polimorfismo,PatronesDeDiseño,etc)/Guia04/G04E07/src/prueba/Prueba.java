package prueba;

import modelo.CafeAmargo;
import modelo.CafeDulce;
import modelo.Mate;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		CafeDulce a = new CafeDulce();
		CafeAmargo b = new CafeAmargo();
		Mate c = new Mate();
		
		
		a.prepararInfusion();
		System.out.println("======");
		b.prepararInfusion();
		System.out.println("======");
		c.prepararInfusion();
	}

}
