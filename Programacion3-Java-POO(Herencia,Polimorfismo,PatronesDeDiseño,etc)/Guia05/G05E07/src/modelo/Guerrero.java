package modelo;

public class Guerrero extends Personaje {

	public Guerrero(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getArmadura() {
		// TODO Auto-generated method stub
		return 1500;
	}

	@Override
	public double getAtaqueCorto() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public double getAtaqueDistante() {
		// TODO Auto-generated method stub
		return 100;
	}

}
