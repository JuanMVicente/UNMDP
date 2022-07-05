package prueba;

import java.util.Iterator;

import excepciones.OperacionConjuntoInvalidaException;
import modelo.ConjuntoGenerico;
import modelo.Persona;

public class Prueba {

	public static void main(String[] args) {
		
		Persona a = new Persona("Perez", "Carlos");
		Persona b = new Persona("Perez", "Carlos");
		Persona c = new Persona("Garcia", "Ana");
		Persona d = new Persona("Alvarez", "Ana");
		Persona e = new Persona("Garcia", "Luis");
		
		
		
		ConjuntoGenerico lista = new ConjuntoGenerico();
		
		try {
			lista.agrega(a);
		} catch (OperacionConjuntoInvalidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			lista.agrega(b);
		} catch (OperacionConjuntoInvalidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			lista.agrega(c);
		} catch (OperacionConjuntoInvalidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			lista.agrega(d);
		} catch (OperacionConjuntoInvalidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			lista.agrega(e);
		} catch (OperacionConjuntoInvalidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Iterator<Persona> itr = lista.getIterator();
		while(itr.hasNext())
			System.out.println(itr.next().toString());
		
		
	
	}
}
