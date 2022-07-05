package modelo;

import java.util.Objects;

public class Persona implements Comparable{
	private String apellido;
	private String nombre;
	private String direccion;
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public int hashCode() {
		return Objects.hash(apellido, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(nombre, other.nombre);
	}
	@Override
	public int compareTo(Object o) {
		Persona pers = (Persona) o;
		if(this.apellido.compareTo(pers.apellido) == 0)
			return this.nombre.compareTo(pers.nombre);
		else
			return this.apellido.compareTo(pers.apellido);
	}
	
	public Persona(String apellido, String nombre) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Persona [apellido=" + apellido + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
	
	
	
}
