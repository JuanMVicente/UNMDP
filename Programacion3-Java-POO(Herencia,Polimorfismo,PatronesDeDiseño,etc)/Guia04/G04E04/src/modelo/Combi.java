package modelo;

public class Combi extends Vehiculo {
	private int plaza;
	
	public Combi(String patente, int plaza) {
		super(patente);
		this.plaza = plaza;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void getPrecio() {
		// TODO Auto-generated method stub
		System.out.println(super.precio + 0.015 * plaza + " por d�a " + 0.02 * plaza + " Adicional fijo por plaza");
	}
}
