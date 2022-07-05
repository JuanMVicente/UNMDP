package modelo;

public class CuentaCorriente extends CuentaBancaria{
	
	private double giroDescubierto;
	
	public CuentaCorriente(String nombre, double giro) {
		super(nombre);
		this.giroDescubierto = giro;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void deposito(double cantidad) {
		this.saldo += cantidad;		
	}

	@Override
	protected boolean validaExtraccion(double cantidad) {
		// TODO Auto-generated method stub
		if(super.saldo + giroDescubierto >cantidad)
			return true;
		else
			return false;
	}
	
}
