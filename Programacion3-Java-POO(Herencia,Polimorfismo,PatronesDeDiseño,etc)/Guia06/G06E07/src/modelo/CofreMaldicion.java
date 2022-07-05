package modelo;

public class CofreMaldicion implements ICofre
{

	@Override
	public void hechizar(Hechizable hechizable)
	{
		hechizable.serMaldecido();
		
	}

}