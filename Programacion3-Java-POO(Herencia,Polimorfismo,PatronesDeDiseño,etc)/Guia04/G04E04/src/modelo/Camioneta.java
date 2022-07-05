package modelo;

public class Camioneta extends Vehiculo {
	private double pesoMaximo;
	
	public Camioneta(String patente, double pesoMaximo) {
		super(patente);
		this.setPesoMaximo(pesoMaximo);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	protected void getPrecio() {
		// TODO Auto-generated method stub
		System.out.println(super.precio * (1 + this.pesoMaximo * 0.2) + " por día");
	}




	public double getPesoMaximo() {
		return pesoMaximo;
	}




	public void setPesoMaximo(double pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}
}
