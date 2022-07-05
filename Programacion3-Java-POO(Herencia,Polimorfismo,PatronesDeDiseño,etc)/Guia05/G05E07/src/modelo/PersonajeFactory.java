package modelo;

public class PersonajeFactory {

	public static IPersonaje getPersonaje(String tipo, String elemento, String nombre)
	{
		IPersonaje encapsulado=null;
		IPersonaje respuesta = null;
		
		if (tipo.equalsIgnoreCase("MAGO"))
			encapsulado = new Mago(nombre);
		else if (tipo.equalsIgnoreCase("ELFO"))
			encapsulado = new Elfo(nombre);
		else if (tipo.equalsIgnoreCase("HECHICERA"))
			encapsulado = new Hechicera(nombre);
		else if (tipo.equalsIgnoreCase("DRAGON"))
			encapsulado = new Dragon(nombre);
		else if (tipo.equalsIgnoreCase("GUERRERO"))
			encapsulado = new Guerrero(nombre);

		if (encapsulado != null)
		{
			if (elemento.equalsIgnoreCase("FUEGO"))
				respuesta = new DecoratorFuego(encapsulado);
			else if (elemento.equalsIgnoreCase("AGUA"))
				respuesta = new DecoratorAgua(encapsulado);
			else if (elemento.equalsIgnoreCase("AIRE"))
				respuesta = new DecoratorAire(encapsulado);
			else if (elemento.equalsIgnoreCase("TIERRA"))
				respuesta = new DecoratorTierra(encapsulado);
			
		}

		return respuesta;

	}
}
