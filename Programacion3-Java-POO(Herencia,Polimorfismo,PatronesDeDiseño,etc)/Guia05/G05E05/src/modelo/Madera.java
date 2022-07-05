package modelo;

public class Madera extends Material {
	private String tipo;

	
	public Madera(String color, String tipo) {
		super(color);
		this.tipo = tipo;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String trabajoRealizado(Juguetero artesano) {
		// TODO Auto-generated method stub
		return "muñequito";
	}

	@Override
	public String trabajoRealizado(Joyero artesano) {
		// TODO Auto-generated method stub
		return "aros";
	}


}
