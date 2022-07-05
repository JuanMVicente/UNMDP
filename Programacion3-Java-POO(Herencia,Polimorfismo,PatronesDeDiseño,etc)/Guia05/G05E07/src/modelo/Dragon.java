package modelo;

public class Dragon extends Personaje {

	public Dragon(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getArmadura() {
		// TODO Auto-generated method stub
		return 10000;
	}

	@Override
	public double getAtaqueCorto() {
		// TODO Auto-generated method stub
		return 500;
	}

	@Override
	public double getAtaqueDistante() {
		// TODO Auto-generated method stub
		return 200;
	}

}
