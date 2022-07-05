package prueba;

import modelo.Animal;
import modelo.Domicilio;
import modelo.Gato;
import modelo.Perro;
import modelo.Persona;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Domicilio d = new Domicilio("Matheu", 23);
		Animal m=new Gato(15, "Tom");
		
		Persona p = new Persona(123456789,"Carlos", d,m);
		
		Persona q = null;

		try
		{
			q = (Persona) p.clone();
		} catch (CloneNotSupportedException e1)
		{
			// TODO Auto-generated catch block
		System.out.println("Error al clonar");
		}
		System.out.println(p);
		System.out.println(q);
		p.getAnimal().setNombre("Jerry");
		System.out.println(p);
		System.out.println(q);
		
		Animal perro = new Perro(14,"Perro");
		p.setAnimal(perro);
		
		
		try
		{
			q = (Persona) p.clone();
		} catch (CloneNotSupportedException e1)
		{
			// TODO Auto-generated catch block
		System.out.println("Error al clonar");
		}		
		System.out.println(p);
		System.out.println(q);
		p.getAnimal().setNombre("Perro 2");
		System.out.println(p);
		System.out.println(q);
	}

}
