package modelo;

public abstract class Unidad implements IPosicionable {
	private String equipo;
	private int costo;
	protected int energia;
	protected Posicion posicion;
	
	public Unidad(String equipo, int costo, int energia, int x, int y) 
	{
		super();
		this.equipo = equipo;
		this.costo = costo;
		this.setEnergia(energia);
		this.posicion = new Posicion(x,y);
	}
	
	public abstract void recibeDano(int cantidad);

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return this.posicion.getX();
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.posicion.getY();
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}
	

}
