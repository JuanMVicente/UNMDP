package prueba;

import java.util.ArrayList;

import modelo.Arquero;
import modelo.Caballero;
import modelo.Guerrero;
import modelo.Mapa;
import modelo.Personaje;
import modelo.PersonajeFactory;
import modelo.Posicion;

public class Prueba
{

	public static void main(String[] args)
	{
		Mapa mapa = new Mapa();
		
		//Se agregaran personajes al mapa, para la creacion se aprovecha la clase PersonajeFactory
		//Se podría omitir el uso de la variable p y utilizar el factory dentro de la misma linea,
		// pero creo que de esta forma es mas claro el codigo
		Personaje p;
		
		p= PersonajeFactory.getPersonaje("Guerrero","Jon Snow", new Posicion(30, 40));
		mapa.agregarPersonaje(p);
		
		p= PersonajeFactory.getPersonaje("Guerrero","Arya", new Posicion(10, 50));
		mapa.agregarPersonaje(p);
		
		p= PersonajeFactory.getPersonaje("Arquero","Legolas", new Posicion(7, 1));
		mapa.agregarPersonaje(p);
		
		p= PersonajeFactory.getPersonaje("Caballero","Aragorn", new Posicion(12, 51));
		mapa.agregarPersonaje(p);
		
		ArrayList<Personaje> personajes = mapa.getPersonajes();
		
		System.out.println(mapa);
		System.out.println(personajes.get(0).ataca(personajes.get(3)));
		System.out.println(mapa);
		
		System.out.println(personajes.get(1).ataca(personajes.get(3)));
		System.out.println(mapa);
		
		System.out.println(personajes.get(2).ataca(personajes.get(0)));
		System.out.println(mapa);
		
		
		p= PersonajeFactory.getPersonaje("Arquero","Green Arrow", new Posicion(4,5));
		mapa.agregarPersonaje(p);
						
		Arquero a=(Arquero) p;
		a.agregarFechas(5);
		System.out.println(p);
		
	}

}
