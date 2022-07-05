package modelo;

public class Elfo extends Personaje {

	public Elfo(String nombre) {
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
		return 20;
	}

	@Override
	public double getAtaqueDistante() {
		// TODO Auto-generated method stub
		return 100;
	}

}
