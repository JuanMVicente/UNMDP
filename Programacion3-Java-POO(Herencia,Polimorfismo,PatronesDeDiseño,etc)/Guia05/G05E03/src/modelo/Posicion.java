package modelo;

public class Posicion implements IPosicionable {
	protected int x;
	protected int y;
	
	public Posicion(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return this.x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.y;
	}


}

