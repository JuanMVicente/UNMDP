package prueba;

import modelo.Biblioteca;
import modelo.Libro;
import modelo.Socio;

public class Prueba {
	public static void main(String[] args) {
		
		Biblioteca b = new Biblioteca();
		
		Libro l1 = new Libro(1,"nombrelibro1");
		Libro l2 = new Libro(2,"nombrelibro2");
		Libro l3 = new Libro(3,"nombrelibro3");
		Libro l4 = new Libro(4,"nombrelibro4");
		
		b.agregar(l1);
		b.agregar(l2);
		b.agregar(l3);
		b.agregar(l4);
		
		Socio s1 = new Socio("cristian",b,1);
		Socio s2 = new Socio("davo",b,3);
		Socio s3 = new Socio("pedro",b,1);
		Socio s4 = new Socio("samuel",b,1);
		
		s1.start();
		s2.start();
		s3.start();
		s4.start();
		

}
}
