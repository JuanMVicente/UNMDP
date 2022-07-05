package modelo;

public class Gato extends Animal implements IEmisorDeSonido {

	@Override
	public void emiteSonido() 
	{
		System.out.println("miauuu");
		
	}
}
