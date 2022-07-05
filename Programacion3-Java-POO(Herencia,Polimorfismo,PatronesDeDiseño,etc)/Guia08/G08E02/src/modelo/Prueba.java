package modelo;


public class Prueba {

	public static void main(String[] args) {
		
		Mostrador m = new Mostrador();
		
		Persona p1 = new Persona("ariel",1,m);
		Persona p2 = new Persona("roman",5,m);
		Persona p3 = new Persona("beto",3,m);
		Persona p4 = new Persona("pato",4,m);
		Persona p5 = new Persona("uri",2,m);
		
		p5.start();
		p4.start();
		p3.start();
		p1.start();
		p2.start();
		
		
	}
}
