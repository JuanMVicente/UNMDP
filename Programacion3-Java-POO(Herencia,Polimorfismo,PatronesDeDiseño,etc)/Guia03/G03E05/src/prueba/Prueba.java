package prueba;

import modelo.AutomovilAutomatico;
import modelo.AutomovilManual;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AutomovilManual am = new AutomovilManual("6465",180);
		AutomovilAutomatico aa = new AutomovilAutomatico("156");
		
		aa.acelerar(20);
		System.out.println(aa.getVelocidad());
		System.out.println(aa.getMarcha());
		aa.acelerar(20);
		System.out.println(aa.getVelocidad());
		System.out.println(aa.getMarcha());
		aa.acelerar(20);
		System.out.println(aa.getVelocidad());
		System.out.println(aa.getMarcha());
		
		
		am.acelerar(150);
		System.out.println(am.getVelocidad());
		am.acelerar(50);
		System.out.println(am.getVelocidad());
		am.frenar(150);
		System.out.println(am.getVelocidad());
		am.frenar(50);
		System.out.println(am.getVelocidad());
	}

}
