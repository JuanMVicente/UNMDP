package modelo;

public class Metal extends Material {
	private String nombre;

	public Metal(String color, String nombre) {
		super(color);
		this.nombre = nombre;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String trabajoRealizado(Juguetero artesano) {
		// TODO Auto-generated method stub
		return "autito";
	}

	@Override
	public String trabajoRealizado(Joyero artesano) {
		// TODO Auto-generated method stub
		return "anillo";
	}
}
