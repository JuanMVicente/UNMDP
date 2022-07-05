package modelo;

public class Vaca extends Animal implements IEmisorDeSonido {

	@Override
	public void emiteSonido() 
	{
		System.out.println("muuuu");
		
	}

}
