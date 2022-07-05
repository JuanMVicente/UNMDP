package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ArchivoComprimido extends ArchivoGeneral{
	private double compresion;
	private ArrayList<Archivo> archivos = new ArrayList<Archivo>();
	private ArrayList<Directorio> directorios = new ArrayList<Directorio>();
	
	public ArchivoComprimido(String nombre, LocalDateTime fechaCreacion, LocalDateTime fechaModificacion,
			double compresion) {
		super(nombre, fechaCreacion, fechaModificacion);
		double tamano = 0;
		for(int i=0; i<this.archivos.size(); i++)
			tamano += this.archivos.get(i).getTamano()*compresion;
		for(int i = 0;i<this.directorios.size();i++)
			tamano += this.directorios.get(i).getTamano()*compresion;		
		compresion=tamano;
		super.setTamano(tamano);
		// TODO Auto-generated constructor stub
	}
	
	

}
