package modelo;

public abstract class Edificio extends Unidad implements IConstruible{

	public Edificio(String equipo, int costo, int energia, int x, int y) {
		super(equipo, costo, energia, x, y);
		// TODO Auto-generated constructor stub
	}

	public abstract int getTiempoConstruccion();

}
