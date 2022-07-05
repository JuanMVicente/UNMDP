package modelo;

public class Mago extends Personaje {

	public Mago(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getArmadura() {
		// TODO Auto-generated method stub
		return 500;
	}

	@Override
	public double getAtaqueCorto() {
		// TODO Auto-generated method stub
		return 50;
	}

	@Override
	public double getAtaqueDistante() {
		// TODO Auto-generated method stub
		return 70;
	}

}
