package excepciones;

public class FaltaCombustibleException extends CargaInvalidaException {

	public FaltaCombustibleException(String mensaje, String combustible, double cantidadRequerida,
			double cantidadDisponible) {
		super(mensaje, combustible, cantidadRequerida, cantidadDisponible);
		// TODO Auto-generated constructor stub
	}



}
