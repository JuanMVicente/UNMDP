package modelo;

public class Vehiculo {
	protected String patente;
	protected double precio = 500;
	
	public Vehiculo(String patente) {
		// TODO Auto-generated constructor stub
		this.patente = patente;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	protected void getPrecio() {
		System.out.println(this.precio + " por día");
	};

}
