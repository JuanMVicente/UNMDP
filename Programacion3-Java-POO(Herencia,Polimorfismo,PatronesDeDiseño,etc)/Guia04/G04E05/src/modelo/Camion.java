package modelo;

public class Camion extends Vehiculo {
	private double tara;
	private double cargaMaxima;
	private Acoplado acoplado = null;
	
	
	
	public Camion(String modelo, int interno, double tara, double cargaMaxima) {
		super(modelo, interno);
		this.tara = tara;
		this.cargaMaxima = cargaMaxima;
		// TODO Auto-generated constructor stub
	}

	public void setAcoplado(Acoplado acoplado) {
		this.acoplado = acoplado;
	}
	public void setAcoplado() {
		this.acoplado = null;
	}
	@Override
	public boolean aceptoChofer(Chofer chofer) {
		return chofer.getCategoria().isHabilitaCamion();
	}
	
	
}
