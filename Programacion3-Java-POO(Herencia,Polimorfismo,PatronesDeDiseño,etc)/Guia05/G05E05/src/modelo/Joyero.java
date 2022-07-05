package modelo;

public class Joyero extends Artesano {

	
	
	public Joyero(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	public String trabajar(Material material) {
		// TODO Auto-generated method stub
		return material.trabajoRealizado(this);
	}

}
