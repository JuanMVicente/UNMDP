package modelo;

public class CuentaCorriente extends CuentaBancaria{
	
	private double giroDescubierto;
	
	public CuentaCorriente(String nombre, double giro) {
		super(nombre);
		this.giroDescubierto = giro;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void extraccion(double cantidad) {
		if(this.saldo - cantidad>this.giroDescubierto)
			this.saldo-=cantidad;		
	}

	@Override
	public void deposito(double cantidad) {
		this.saldo += cantidad;		
	}

}
