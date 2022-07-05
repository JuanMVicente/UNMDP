package modelo;

public class CuentaUniversitaria extends CuentaBancaria{
	private double extraccionMensual;
	
	public CuentaUniversitaria(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void extraccion(double cantidad) {
		if(this.saldo - cantidad>0 && this.extraccionMensual<1000)
			this.saldo-=cantidad;
	}

	@Override
	public void deposito(double cantidad) {
		this.saldo += cantidad;		
	}

	
}
