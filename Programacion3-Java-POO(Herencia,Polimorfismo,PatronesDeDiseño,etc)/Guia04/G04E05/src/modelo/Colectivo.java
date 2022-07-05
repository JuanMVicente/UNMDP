package modelo;

public abstract class Colectivo extends Vehiculo {
	protected int cantidadPasajeros;
	private static int sigID = 0;
	
	public Colectivo(String modelo) {	
		super(modelo, sigID);
		sigID++;
		// TODO Auto-generated constructor stub
	}
	
	
}
