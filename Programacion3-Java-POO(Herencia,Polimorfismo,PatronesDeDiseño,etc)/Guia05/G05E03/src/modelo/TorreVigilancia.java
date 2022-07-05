package modelo;

public class TorreVigilancia extends Edificio {

	public TorreVigilancia(String equipo, int x, int y) {
		super(equipo, 200, 2000, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getTiempoConstruccion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void recibeDano(int cantidad) {
		if(this.energia > cantidad)
			this.energia -= cantidad;
		else
			this.energia = 0;		
	}
	
	
}
