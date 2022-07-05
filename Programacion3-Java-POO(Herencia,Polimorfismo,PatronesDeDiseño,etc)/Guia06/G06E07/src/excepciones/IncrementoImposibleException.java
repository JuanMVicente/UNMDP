package modelo;

public class IncrementoImposibleException extends Exception {
	private double maxDistanciaSoportada;
	private double distanciaPretendida;
	
	
	public IncrementoImposibleException(double maxDistanciaSoportada, double distanciaPretendida) {
		super();
		this.maxDistanciaSoportada = maxDistanciaSoportada;
		this.distanciaPretendida = distanciaPretendida;
	}


	public void setMaxDistanciaSoportada(double maxDistanciaSoportada) {
		this.maxDistanciaSoportada = maxDistanciaSoportada;
	}


	public void setDistanciaPretendida(double distanciaPretendida) {
		this.distanciaPretendida = distanciaPretendida;
	}


	@Override
	public String toString() {
		return "IncrementoImposibleException [maxDistanciaSoportada=" + maxDistanciaSoportada + ", distanciaPretendida="
				+ distanciaPretendida + "]";
	}

	
}
