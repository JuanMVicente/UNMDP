package modelo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author guille
 *<br>
 *Clase que representa un mapa dentro de un juego de estrategia. COntiene la totalidad de los personajes.
 */
public class Mapa
{

	private ArrayList<Personaje> personajes = new ArrayList<Personaje>();

	/**
	 * Agrega un Personaje al mapa<br>
	 * <b>Pre: </b> El parametro Personaje debe ser distinto de null<br>
	 * <b>Post: </b> Se agrega un personaje mas a la lista<br>
	 * @param personaje : Parametro que sera agregado a nuestro mapa
	 */
	public void agregarPersonaje(Personaje personaje)
	{
		
		this.personajes.add(personaje);
	}

	public void eliminarPersonaje(Personaje personaje)
	{
		this.personajes.remove(personaje);
	}

	public ArrayList<Personaje> getPersonajes()
	{
		return personajes;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		Iterator it=this.personajes.iterator();
		while(it.hasNext())
		{
			sb.append(it.next().toString());
			sb.append("\n");
			}
		return sb.toString();

	}

}
