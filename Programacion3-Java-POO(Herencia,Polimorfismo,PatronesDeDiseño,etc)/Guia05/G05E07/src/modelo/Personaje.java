package modelo;

public abstract class Personaje implements IPersonaje {
	
	private String nombre;

	public Personaje(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + "]";
	}

	
	
}
