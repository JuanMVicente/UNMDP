package modelo;

public class Camion extends Vehiculo {

	public Camion(String patente) {
		super(patente);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void getPrecio() {
		// TODO Auto-generated method stub
		System.out.println(super.precio + " por d�a" + super.precio * 0.4 + " adicionales");
	}
	
}
