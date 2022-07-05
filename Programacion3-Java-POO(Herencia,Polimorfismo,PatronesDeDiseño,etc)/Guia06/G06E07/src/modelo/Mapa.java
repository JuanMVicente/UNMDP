package modelo;

import java.util.ArrayList;
import java.util.Iterator;

import excepciones.AtaqueImposibleException;
import excepciones.IncrementoImposibleException;

public class Mapa implements Cloneable
{

	private ArrayList<Personaje> personajes = new ArrayList<Personaje>();

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

	void mueve (Personaje personaje, double valorX, double valorY) {
		try {
			personaje.incrementaPos(valorX, valorY);
		} catch (IncrementoImposibleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//procedimiento para que mueva a posmax
		}
	}
	
	void ataca(Personaje atacante, Personaje atacado) throws AtaqueImposibleException
	{
		try {
			atacante.ataca(atacado);
		} catch (AtaqueImposibleException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.toString());
				throw e;
		}
		
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		Mapa mapaClonado = null;
		mapaClonado =(Mapa) super.clone();
		
		for (int i=0; i<personajes.size();i++) {
			mapaClonado.agregarPersonaje((Personaje) this.personaje.clone());
		}
		
		return mapaClonado;
		
	
	}
}
