package modelo;

public class Motor implements Cloneable {
	private String fabricante;
	private String nSerie;
	private double potencia;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Motor motorClonado = null;
		motorClonado = (Motor) this.clone();
		return motorClonado;
	}
	
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getNSerie() {
		return nSerie;
	}
	public void setNSerie(String nSerie) {
		this.nSerie = nSerie;
	}
	public double getPotencia() {
		return potencia;
	}
	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}
	
	
	
	
}
