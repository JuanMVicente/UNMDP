package modelo;

public abstract class Automovil {
	private String patente;
	protected double velocidad = 0;
	protected double velocidadMaxima;
	protected int marcha;
	
	
	public Automovil(String patente, double velocidadMaxima) {
		super();
		this.patente = patente;
		this.velocidadMaxima = velocidadMaxima;
	}
	public Automovil(String patente) {
		super();
		this.patente = patente;
		this.velocidadMaxima = 160;
	}
	public String getPatente() {
		return patente;
	}
	public double getVelocidad() {
		return velocidad;
	}
	public int getMarcha() {
		return marcha;
	}
	public abstract void acelerar(double velocidad);
	
	public abstract void frenar(double velocidad);
	@Override
	public String toString() {
		return "Automovil [patente=" + patente + ", velocidad=" + velocidad + ", velocidadMaxima=" + velocidadMaxima
				+ ", marcha=" + marcha + "]";
	}
	
	protected void setMarcha(int nuevaMarcha) {
		if(nuevaMarcha<6 && nuevaMarcha>-2)
			this.marcha = nuevaMarcha;
	}
	
}
