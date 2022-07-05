package modelo;

public abstract class Vehiculo {
	private String modelo;
	protected int interno;
	
	
	
	public Vehiculo(String modelo, int interno) {
		super();
		this.modelo = modelo;
		this.interno = interno;
	}



	public abstract boolean aceptoChofer(Chofer chofer);
}
