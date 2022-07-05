package modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona a = new Persona("Perez", "Carlos");
		Persona b = new Persona("Perez", "Carlos");
		Persona c = new Persona("Garcia", "Ana");
		Persona d = new Persona("Alvarez", "Ana");
		Persona e = new Persona("Garcia", "Luis");
		
		Persona[] personas = {a,b,c,d,e};
		System.out.println(personas.length);
		for (int i=0; i<personas.length;i++) {
			System.out.println(personas[i].toString());
		}
		/*System.out.println(personas.length);
		Ordenadora.ordenar(personas);
		System.out.println(personas.length);
		for (int i=0; i<personas.length;i++) {
			System.out.println(personas[i].toString());
		}*/
		HashSet<Persona> p1 = new HashSet<Persona>();
		LinkedHashSet<Persona> p2 = new LinkedHashSet<Persona>();
		TreeSet<Persona> p3 = new TreeSet<Persona>();
		ArrayList<Persona> p4 = new ArrayList<Persona>();
		LinkedList<Persona> p5 = new LinkedList<Persona>();
		PriorityQueue<Persona> p6  = new PriorityQueue<Persona>();
		
		for (int i=0; i<personas.length;i++) {
			p1.add(personas[i]);
			p2.add(personas[i]);
			p3.add(personas[i]);
			p4.add(personas[i]);
			p5.add(personas[i]);
			p6.add(personas[i]);
			
		}
		
		System.out.println("=============P1================");
		Iterator<Persona> itr = p1.iterator();
		while(itr.hasNext())
			System.out.println(itr.next().toString());
		System.out.println("==============P2===============");
		itr = p2.iterator();
		while(itr.hasNext())
			System.out.println(itr.next().toString());
		System.out.println("==============P3===============");
		itr = p3.iterator();
		while(itr.hasNext())
			System.out.println(itr.next().toString());	
		System.out.println("==============P4===============");
		itr = p4.iterator();
		while(itr.hasNext())
			System.out.println(itr.next().toString());
		System.out.println("==============P5===============");
		itr = p5.iterator();
		while(itr.hasNext())
			System.out.println(itr.next().toString());
		System.out.println("==============P6===============");
		itr = p6.iterator();
		while(itr.hasNext())
			System.out.println(itr.next().toString());
		
	}

}
