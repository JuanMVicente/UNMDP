package modelo;

public class CajaDeAhorro extends CuentaBancaria{
	private int cantExtracciones;
	
	public CajaDeAhorro(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void extraccion(double cantidad) {
		if(super.saldo - cantidad>0 && this.cantExtracciones<10)
			super.saldo-=cantidad;
	}

	@Override
	public void deposito(double cantidad) {
		this.saldo += cantidad;		
	}

}
