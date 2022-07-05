package modelo;

public class CajaDeAhorro extends CuentaBancaria{
	private int cantExtracciones=0;
	
	public CajaDeAhorro(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void deposito(double cantidad) {
		this.saldo += cantidad;		
	}


	@Override
	protected boolean validaExtraccion(double cantidad) {
		// TODO Auto-generated method stub
		if(super.saldo>cantidad && this.cantExtracciones<10)
			return true;
		else
			return false;
	}

}
