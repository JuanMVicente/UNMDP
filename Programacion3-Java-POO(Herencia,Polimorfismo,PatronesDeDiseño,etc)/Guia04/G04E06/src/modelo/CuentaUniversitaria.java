package modelo;

public class CuentaUniversitaria extends CuentaBancaria{
	private double extraccionDiaria = 0;
	
	public CuentaUniversitaria(String nombre) {
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
		if(super.saldo>cantidad && this.extraccionDiaria<1000) {
			this.extraccionDiaria+=cantidad;
			return true;
		}
		else
			return false;
	}
	
}
