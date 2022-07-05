package modelo;

public class Juguetero extends Artesano {


	public Juguetero(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String trabajar(Material material) {
		// TODO Auto-generated method stub
		return material.trabajoRealizado(this);
	}

}
