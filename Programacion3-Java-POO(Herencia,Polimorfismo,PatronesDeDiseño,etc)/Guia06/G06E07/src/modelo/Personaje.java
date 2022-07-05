package modelo;

import excepciones.AtaqueImposibleException;
import excepciones.IncrementoImposibleException;

public abstract class Personaje implements Movible,Hechizable,Comparable,Cloneable
{
	private String nombre;
	protected int vitalidad;
	private Movible movible;

	private double distianciaMaximaDeDesplazamiento;
	
	
	public Personaje(String nombre, int vitalidad, Posicion posicion, double distianciaMaximaDeDesplazamiento)
	{
		this.nombre = nombre;
		this.vitalidad = vitalidad;
		this.movible = posicion;
		this.distianciaMaximaDeDesplazamiento = distianciaMaximaDeDesplazamiento;
	}

	public String getNombre()
	{
		return nombre;
	}

	public int getVitalidad()
	{
		return vitalidad;
	}

	public Movible getPosicion()
	{
		return movible;
	}

	@Override
	public String toString()
	{
		return "[nombre=" + nombre + ", vitalidad=" + vitalidad + ", posicion=" + movible + "]";
	}

	public void mueve(double x, double y)
	{
		this.movible.mueve(x, y);
	}

	public double distancia(Movible otro)
	{
		return this.movible.distancia(otro);
	}
	
	
	
	
	
	@Override
	public double getX()
	{
		// TODO Auto-generated method stub
		return this.movible.getX();
	}

	/*@Override
	public void setX(double x)
	{
		this.setX(x);
		
	}*/
	
	@Override
	public void incrementaPos(double valorX, double valorY) throws IncrementoImposibleException 
	{
		// TODO Auto-generated method stub
		double movimiento = (valorX - this.getX()) * (valorX - this.getX()) + (valorY - this.getY()) * (valorY - this.getY());
		movimiento = Math.sqrt(movimiento);
		if(valorX>movimiento)
			throw new IncrementoImposibleException(this.distianciaMaximaDeDesplazamiento, movimiento);
		else {
			this.mueve(valorX, valorY);
		}
			
	}

	@Override
	public double getY()
	{
		// TODO Auto-generated method stub
		return this.movible.getY();
	}

	/*@Override
	public void setY(double y)
	{
	this.movible.setY(y);	
	}*/

	//El metodo ataca devuelve un String par informar 
	//sobre su xito o fracaso, esto NO ES CORRECTO pero
	// por ahora lo vamos a dejar pasar
	// Este ejemplo lo retomaremos en la clase de Excepciones
	public abstract void ataca(Personaje adversario) throws AtaqueImposibleException;
	
	public abstract void recibeDano(int cantidad);
	

	public int compareTo(Object o) {
		Personaje personajeComparado = (Personaje) o;
		if(this.nombre.compareTo(personajeComparado.getNombre()) !=0 )
			return this.nombre.compareTo(personajeComparado.getNombre());	
		else
			return this.vitalidad - personajeComparado.getVitalidad();
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		Personaje personajeClonado = null;
		personajeClonado =(Personaje) super.clone();
		
		if(movible!=null) personajeClonado.movible = (Movible) this.movible.clone();
		
		return personajeClonado;
	}
}
