package modelo;

public class CofreBendicion implements ICofre
{

	@Override
	public void hechizar(Hechizable hechizable)
	{
		hechizable.serBendecido();
		
	}

	

	

}
