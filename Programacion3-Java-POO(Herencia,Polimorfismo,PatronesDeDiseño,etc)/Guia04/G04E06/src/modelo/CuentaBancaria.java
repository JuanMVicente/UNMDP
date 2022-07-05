package modelo;

public abstract class CuentaBancaria {
	protected String nombre;
	protected double saldo;
	
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
	
	public abstract void deposito(double cantidad);
	
	public void extraer(double cantidad) {
		if(this.validaExtraccion(cantidad))
			this.extraccion(cantidad);
	}
	
	protected abstract boolean validaExtraccion(double cantidad);	
	
	protected void extraccion(double cantidad) {
		this.saldo-=cantidad;
	}
	
	
}
