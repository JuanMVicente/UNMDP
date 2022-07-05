package modelo;

import excepciones.AtaqueImposibleException;

public class Guerrero extends Personaje
{

	public Guerrero(String nombre,  Posicion posicion)
	{
		super(nombre, 500, posicion, 5);
		
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
		this.vitalidad-=cantidad;

	}
	
	@Override
	public String toString()
	{
			
		return "Guerrero "+super.toString();
	}

	@Override
	public void serBendecido()
	{
		this.vitalidad*=1.25;
		
	}

	@Override
	public void serMaldecido()
	{
		this.vitalidad*=0.50;
		
	}

}
