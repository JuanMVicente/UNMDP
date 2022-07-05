package excepsiones;

public class DepositoInvalidoException extends Exception {
	private double cantidadInvalida;

	public DepositoInvalidoException(double cantidadInvalida) {
		super();
		this.cantidadInvalida = cantidadInvalida;
	}

	public double getCantidadInvalida() {
		return cantidadInvalida;
	}
	
	
}
