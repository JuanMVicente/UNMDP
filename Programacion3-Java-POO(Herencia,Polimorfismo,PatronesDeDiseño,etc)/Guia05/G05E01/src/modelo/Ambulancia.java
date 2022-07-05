package modelo;

public class Ambulancia extends Vehiculo implements IEmisorDeSonido {

	@Override
	public void emiteSonido() 
	{
		System.out.println("sirena sonando");
	}

}
