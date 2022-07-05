package modelo;

public class Pollito extends Animal implements IEmisorDeSonido {

	@Override
	public void emiteSonido() 
	{
		System.out.println("piiiio");
		
	}
}
