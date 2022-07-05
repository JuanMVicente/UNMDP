package excepciones;

public class DatoCargaInvalido extends Exception {
	private double cantidadDisponible;
	private double cantidadRequerida;
	private String Combustible;
	
	public DatoCargaInvalido(String combustible, double cantidadRequerida, double cantidadDisponible) {
		super();
		this.cantidadDisponible = cantidadDisponible;
		this.cantidadRequerida = cantidadRequerida;
		Combustible = combustible;
	}

	public double getCantidadDisponible() {
		return cantidadDisponible;
	}

	public double getCantidadRequerida() {
		return cantidadRequerida;
	}

	public String getCombustible() {
		return Combustible;
	}

}
