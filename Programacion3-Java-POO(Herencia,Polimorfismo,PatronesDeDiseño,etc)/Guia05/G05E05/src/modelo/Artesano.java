package modelo;

public abstract class Artesano {
	private String nombre;
	
	
	
	public Artesano(String nombre) {
		super();
		this.nombre = nombre;
	}



	public abstract String trabajar(Material material);
	
}
