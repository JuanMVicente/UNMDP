package modelo;

public class Soldado extends Personaje implements IHostil {

	public Soldado(String equipo, int x, int y) {
		super(equipo, 100, 500, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mover(int x, int y) {
		// TODO Auto-generated method stub
		this.posicion.x += x;
		this.posicion.y += y;
	}

	@Override
	public void atacar(Unidad adversario) {
		adversario.recibeDano(50);
		
	}

	@Override
	public void recibeDano(int cantidad) {
		if(this.energia > cantidad)
			this.energia -= cantidad;
		else
			this.energia = 0;		
	}

}
