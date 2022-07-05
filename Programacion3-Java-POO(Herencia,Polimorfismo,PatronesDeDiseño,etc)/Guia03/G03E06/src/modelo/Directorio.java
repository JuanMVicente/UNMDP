package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Directorio {
	private String nombre;
	private LocalDateTime fechaCreacion;
	private ArrayList<Directorio> subDirectorios = new ArrayList<Directorio>();
	private ArrayList<ArchivoGeneral> archivos = new ArrayList<ArchivoGeneral>();
	private double tamano;
	
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public ArrayList<Directorio> getSubDirectorios() {
		return subDirectorios;
	}


	public void setSubDirectorios(ArrayList<Directorio> subDirectorios) {
		this.subDirectorios = subDirectorios;
	}


	public ArrayList<ArchivoGeneral> getArchivos() {
		return archivos;
	}


	public void setArchivos(ArrayList<ArchivoGeneral> archivos) {
		this.archivos = archivos;
	}
	

	public double getTamano() {
		return tamano;
	}


	public void setTamano() {
		double tamano=0;
		for(int i=0;i<this.subDirectorios.size();i++)
			tamano += this.subDirectorios.get(i).tamano;
		for(int i = 0;i<this.archivos.size();i++)
			tamano += this.archivos.get(i).getTamano();
		this.tamano = tamano;
	}
	
	
}
