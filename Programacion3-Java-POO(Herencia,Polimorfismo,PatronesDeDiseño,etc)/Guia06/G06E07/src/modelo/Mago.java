package modelo;

import excepciones.AtaqueImposibleException;

public class Mago extends Personaje
{
	private int armadura;

	public Mago(String nombre, Posicion posicion)
	{
		super(nombre, 800, posicion, 10);
		this.armadura = 400;

	}
	
	@Override
	public void incrementaPos(double valorX, double valorY)
	{
		// TODO Auto-generated method stub
		double movimiento = (valorX - this.getX()) * (valorX - this.getX()) + (valorY - this.getY()) * (valorY - this.getY());
		movimiento = Math.sqrt(movimiento);
		this.mueve(valorX, valorY);
	}

	public int getArmadura()
	{
		return armadura;
	}

	public void recuperaArmadura(int cantidad)
	{

		this.armadura += cantidad;
	}

	@Override
	public void ataca(Personaje adversario) throws AtaqueImposibleException
	{
		//String respuesta=null;
		
		if(this.distancia(adversario)<=10)
		{
			adversario.recibeDano(10);
			//respuesta=this.getNombre()+" Ataco con exito a "+adversario.getNombre();
		}
		else
			throw new AtaqueImposibleException(this,adversario);
			//respuesta=this.getNombre()+" No pudo atacar a " +adversario.getNombre()+ " , distancia demasiado grande "+this.distancia(adversario);
		//return respuesta;
	}

	@Override
	public void recibeDano(int cantidad)
	{
		if (cantidad < this.armadura)
			this.armadura -= cantidad;
		else
		{
			this.vitalidad -= (cantidad - this.armadura);
			this.armadura = 0;
		}

	}

	@Override
	public String toString()
	{

		return "Caballero " + super.toString() + " [armadura=" + this.armadura + "]";
	}

	@Override
	public void serBendecido()
	{
		this.armadura += 200;

	}

	@Override
	public void serMaldecido()
	{
		if (this.armadura > 200)
			this.armadura -= 200;
		else
			this.armadura = 0;
	}


}
