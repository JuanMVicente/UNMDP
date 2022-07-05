package Prueba;

import modelo.Bicicleta;
import modelo.Coche;
import modelo.Vehiculo;

public class prueba {

	public static void main(String[] args) {
		Vehiculo v = new Coche();
		Coche c = (Coche) v;
		//Bicicleta b = (Bicicleta) v;
		Object o = v;
		Vehiculo v2= (Vehiculo) o;
		Vehiculo b2 = new Bicicleta();
		//Bicicleta b3 = b2;
		
		v.detalle () ;
		System.out.println(" v ");
		c.detalle ();
		System.out.println(" c ");
		//b.detalle () ;
		//o.detalle () ;
		v2.detalle (); 
		System.out.println(" v2 ");
		b2.detalle (); 
		System.out.println(" b2 ");
		//b3.detalle ();
		
		System.out.println("v " + v.a);
		System.out.println("c " + c.a);
		//System.out.println(b.a);
		//System.out.println(o.a);
		System.out.println("v2 " + v2.a);
		System.out.println("b2 " + b2.a);
		//System.out.println(b3.a);
		System.out.println("v " + v.getA());
		System.out.println("c " + c.getA());
		//System.out.println(b.getA());
		//System.out.println(o.getA());
		System.out.println("v2 " + v2.getA());
		System.out.println("b2 " + b2.getA());
		//System.out.println(b3.getA());
		
	}

}
