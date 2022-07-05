package modelo;

public class Medico extends Personaje {

	public Medico(String equipo, int x, int y) {
		super(equipo, 40, 100, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mover(int x, int y) {
		// TODO Auto-generated method stub
		this.posicion.x += x;
		this.posicion.y += y;
	}

	@Override
	public void recibeDano(int cantidad) {
		if(this.energia > 1.5 * cantidad)
			this.energia -= 1.5 * cantidad;
		else
			this.energia = 0;		
	}


}
