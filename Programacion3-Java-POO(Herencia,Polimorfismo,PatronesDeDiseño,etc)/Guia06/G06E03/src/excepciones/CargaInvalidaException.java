package excepciones;

public class CargaInvalidaException extends Exception {
	private DatoCargaInvalido datoCargaInvalido;
	

	public CargaInvalidaException(String mensaje, String combustible, double cantidadRequerida, double cantidadDisponible) {
		this.datoCargaInvalido = new DatoCargaInvalido(combustible, cantidadRequerida, cantidadDisponible);
	}

	public DatoCargaInvalido getCargaInvalida() {
		return datoCargaInvalido;
	}
	
	
}
