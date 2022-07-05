package modelo;

import excepciones.CargaInvalidaException;
import excepciones.FaltaCombustibleException;
import excepciones.TipoCombustibleInvalidoException;

public class Surtidor {
	double cantidadDiesel;
	double cantidadPremium;
	double cantidadSuper;
	
	public void cargarCombustible(String combustible, double cantidad) throws DatoCargaInvalida
	{
		if(cantidad<0)
			throw new CargaInvalidaException("Carga Invalida", combustible, cantidad,0);
		if(combustible.equals("Diesel"))
			if(this.cantidadDiesel > cantidad)
				this.cantidadDiesel -= cantidad;
			else
				if(this.cantidadDiesel>0) {
					double cargado = cantidad - this.cantidadDiesel;
					this.cantidadDiesel=0;
					throw new FaltaCombustibleException("Cargado Parcial", combustible, cargado, this.cantidadDiesel);
				}
				else
					throw new FaltaCombustibleException("Sin carga", combustible, cantidad,0);
		else if(combustible.equals("Premium"))
			if(this.cantidadPremium > cantidad)
				this.cantidadPremium -= cantidad;
			else
				if(this.cantidadPremium>0) {
					double cargado = cantidad - this.cantidadPremium;
					this.cantidadPremium=0;
					throw new FaltaCombustibleException("Cargado Parcial", combustible, cargado, this.cantidadPremium);
				}
				else
					throw new FaltaCombustibleException("Sin carga", combustible, cantidad,0);		
		else if(combustible.equals("Super"))
			if(this.cantidadSuper > cantidad)
				this.cantidadSuper -= cantidad;
			else
				if(this.cantidadSuper>0) {
					double cargado = cantidad - this.cantidadSuper;
					this.cantidadSuper=0;
					throw new FaltaCombustibleException("Cargado Parcial", combustible, cargado, this.cantidadSuper);
				}
				else
					throw new FaltaCombustibleException("Sin carga", combustible, cantidad,0);
		else
			throw new TipoCombustibleInvalidoException("Combustible incorrecto", combustible, cantidad,0);
	}
	
	public double getCantidadDiesel() {
		return cantidadDiesel;
	}
	public void llenarDiesel() {
		this.cantidadDiesel = 2000;
	}
	public double getCantidadPremium() {
		return cantidadPremium;
	}
	public void llenarPremium() {
		this.cantidadPremium = 2000;
	}
	public double getCantidadSuper() {
		return cantidadSuper;
	}
	public void llenarSuper() {
		this.cantidadSuper = 2000;
	}
	
	
}
