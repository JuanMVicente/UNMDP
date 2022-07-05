package modelo;

public abstract class CuentaBancaria {
	private String nombre;
	private double saldo;
	
	public CuentaBancaria(String nombre) {
		this.nombre = nombre;
		this.saldo = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public abstract void extraccion(double cantidad);
	
	public abstract void deposito(double cantidad);
	
	
	
	
	
}
