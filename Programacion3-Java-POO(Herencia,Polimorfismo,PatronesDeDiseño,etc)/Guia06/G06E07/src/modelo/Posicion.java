package modelo;

import excepciones.IncrementoImposibleException;

public class Posicion implements Movible, Cloneable
{
	private double x;
	private double y;

	public Posicion(double x, double y)
	{

		this.x = x;
		this.y = y;
	}

	public double getX()
	{
		return x;
	}

	public void setX(double x)
	{
		this.x = x;
	}

	public double getY()
	{
		return y;
	}

	public void setY(double y)
	{
		this.y = y;
	}

	@Override
	public String toString()
	{
		return "[x=" + x + ", y=" + y + "]";
	}
	
	public double distancia(Movible otro)
	{
		double respuesta;
		respuesta = (otro.getX() - this.getX()) * (otro.getX() - this.getX()) + (otro.getY() - this.getY()) * (otro.getY() - this.getY());
		respuesta = Math.sqrt(respuesta);
		return respuesta;
	}
	
	public void mueve(double x, double y)
	{
		this.x += x;
		this.y += y;

	}

	@Override
	public void incrementaPos(double valorX, double valorY) throws IncrementoImposibleException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object clone() throws CloneNotSupportedException
	{
		Posicion posicionClonada = null;
		posicionClonada =(Posicion) super.clone();
		
		return posicionClonada;
	}
}
