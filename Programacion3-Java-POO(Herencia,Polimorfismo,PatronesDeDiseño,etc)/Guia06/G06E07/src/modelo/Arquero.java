package modelo;

import excepciones.AtaqueImposibleException;

public class Arquero extends Personaje
{
	private int cantidadFlechas;

	public Arquero(String nombre, Posicion posicion)
	{
		super(nombre, 400, posicion, 8);
		this.cantidadFlechas = 20;

	}
	
	

	public int getCantidadFlechas()
	{
		return cantidadFlechas;
	}

	
	public void agregarFechas(int cantidad) 
	{
		this.cantidadFlechas+=cantidad;
	}


	@Override
	public void ataca(Personaje adversario) throws AtaqueImposibleException
	{
		
		if (this.cantidadFlechas > 0)// tenemos flechas
		{
			if (this.distancia(adversario) < 100)
			{
				this.cantidadFlechas--;
				adversario.recibeDano(20);
			} else
			{

				throw new AtaqueImposibleException(this,adversario);
			}

		} else
		{
			if (this.distancia(adversario) < 5)
			{
				adversario.recibeDano(5);
			} else
			{

				//respuesta = this.getNombre() + " No pudo atacar a " + adversario.getNombre()
				//		+ " No tenia flechas y la distancia era muy grande para ataques cortos "+this.distancia(adversario);;
			}
			
			
		}
	}

	@Override
	public void recibeDano(int cantidad)
	{
		this.vitalidad -= cantidad;

	}

	@Override
	public String toString()
	{
		
		
		return "Arquero "+super.toString()+" [cantidadFlechas=" + cantidadFlechas + "]";
	}



	@Override
	public void serBendecido()
	{
		this.cantidadFlechas+=5;
	}



	@Override
	public void serMaldecido()
	{
		this.cantidadFlechas=0;
	}


}
