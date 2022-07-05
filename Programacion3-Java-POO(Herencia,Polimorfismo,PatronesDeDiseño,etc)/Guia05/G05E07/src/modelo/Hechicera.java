package modelo;

public class Hechicera extends Personaje {

	public Hechicera(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getArmadura() {
		// TODO Auto-generated method stub
		return 1000;
	}

	@Override
	public double getAtaqueCorto() {
		// TODO Auto-generated method stub
		return 70;
	}

	@Override
	public double getAtaqueDistante() {
		// TODO Auto-generated method stub
		return 50;
	}

}
