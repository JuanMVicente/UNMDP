package excepciones;

public class OperacionConjuntoInvalidaException extends Exception {
	private Object elemento;

	public OperacionConjuntoInvalidaException(String string, Object elemento) {
		super();
		this.elemento = elemento;
	}

	public Object getElemento() {
		return elemento;
	}
	
	
}
