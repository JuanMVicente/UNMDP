package modelo;

import java.util.ArrayList;

public class Empresa {
	private ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
	private ArrayList<Chofer> choferes = new ArrayList<Chofer>();
	private ArrayList<Acoplado> acoplados = new ArrayList<Acoplado>();
	
	public int cantidadChoferes() {
		return choferes.size();
	}
	
	public int cantidadChoferesSinVehiculoAsignado() {
		int contador = 0;
		for(int i=0; i < choferes.size(); i++) {
			if(choferes.get(i).getVehiculoAsignado() != null)
				contador++;
		}
		return contador;
	}
	
	public int cantidadVehiculos() {
		return vehiculos.size();
	}
	
	public int cantidadAcoplados() {
		return acoplados.size();
	}
	
}
