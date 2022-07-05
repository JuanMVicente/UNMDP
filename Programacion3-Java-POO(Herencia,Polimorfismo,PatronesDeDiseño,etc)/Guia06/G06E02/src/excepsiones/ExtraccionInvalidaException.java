package excepsiones;

import modelo.DatoInvalido;

public class ExtraccionInvalidaException extends Exception {
	private DatoInvalido dato;

	
	
	public ExtraccionInvalidaException(double extraccionSolicitada, double cantidad) {
		super();
		this.dato = new DatoInvalido(extraccionSolicitada, cantidad);
	}

	public DatoInvalido getDato() {
		return dato;
	}
	
	
}
