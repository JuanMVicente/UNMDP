package modelo;

public class Perro extends Animal implements IEmisorDeSonido  {

	@Override
	public void emiteSonido() 
	{
		System.out.println("guauu");
		
	}
}
