package modelo;

import java.time.LocalDateTime;

public abstract class ArchivoGeneral {
	private String nombre;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaModificacion;
	private double tamano;
	
	
	
	public ArchivoGeneral(String nombre, LocalDateTime fechaCreacion, LocalDateTime fechaModificacion) {
		super();
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
	}

	public ArchivoGeneral(String nombre, LocalDateTime fechaCreacion, LocalDateTime fechaModificacion, double tamano) {
		super();
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.tamano = tamano;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public LocalDateTime getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(LocalDateTime fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public double getTamano() {
		return tamano;
	}
	public void setTamano(double tamano) {
		this.tamano = tamano;
	}
	
	
}
