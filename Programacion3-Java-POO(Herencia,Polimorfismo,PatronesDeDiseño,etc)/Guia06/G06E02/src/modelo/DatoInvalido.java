package modelo;

public class DatoInvalido {
	double extraccionSolicitada;
	double saldo;
	
	
	public DatoInvalido(double extraccionSolicitada, double saldo) {
		super();
		this.extraccionSolicitada = extraccionSolicitada;
		this.saldo = saldo;
	}
	public double getExtraccionSolicitada() {
		return extraccionSolicitada;
	}
	public double getSaldo() {
		return saldo;
	}
	
	
}
