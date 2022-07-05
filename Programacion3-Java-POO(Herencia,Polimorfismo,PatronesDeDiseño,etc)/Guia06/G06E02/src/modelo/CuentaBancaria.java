package modelo;

import excepsiones.DepositoInvalidoException;
import excepsiones.ExtraccionInvalidaException;

public class CuentaBancaria {
	private double saldo;
	private String titular;
	public CuentaBancaria(String titular) {
		super();
		this.titular = titular;
	}
	public double getSaldo() {
		return saldo;
	}
	public String getTitular() {
		return titular;
	}
	
	public void depositar(double cantidad) throws DepositoInvalidoException
	{
		if(cantidad>0)
			this.saldo += cantidad;
		else
			throw new DepositoInvalidoException(cantidad);
	}
	
	public void extraer(double cantidad) throws ExtraccionInvalidaException
	{
		if(cantidad<=0)
			if(this.saldo + cantidad >= 0)
				this.saldo += cantidad;
			else
				throw new ExtraccionInvalidaException(cantidad,this.saldo);
		else
			throw new ExtraccionInvalidaException(cantidad,this.saldo);
	}
}
