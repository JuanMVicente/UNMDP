package modelo;

public class Cuartel extends Edificio  {

	public Cuartel(String equipo, int x, int y) {
		super(equipo, 500, 3000, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void recibeDano(int cantidad) {
		if(this.energia > cantidad/2)
			this.energia -= cantidad / 2;
		else
			this.energia = 0;		
	}

	@Override
	public int getTiempoConstruccion() {
		return 40;
	}
	
}