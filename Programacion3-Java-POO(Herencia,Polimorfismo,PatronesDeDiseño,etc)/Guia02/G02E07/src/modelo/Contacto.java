package modelo;

import java.util.HashMap;

public class Contacto {
	private String nombre;
	private String telefonoFijo;
	private String celular;
	
	
	
	public Contacto(String nombre, String telefonoFijo, String celular) {
		super();
		this.nombre = nombre;
		this.telefonoFijo = telefonoFijo;
		this.celular = celular;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefonoFijo() {
		return telefonoFijo;
	}
	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	@Override
	public String toString() {
		return "Contacto\n" +
				"Nombre= " + this.nombre + "\n" + 
				"Telefono Fijo= " + this.telefonoFijo + "\n" +
				"TelefonosCelulares= " + this.celular;
	}
}