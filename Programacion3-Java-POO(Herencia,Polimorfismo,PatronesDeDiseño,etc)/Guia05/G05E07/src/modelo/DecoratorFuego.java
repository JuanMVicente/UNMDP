package modelo;

public class DecoratorFuego extends DecoratorElementos {

	public DecoratorFuego(IPersonaje encapsulado) {
		super(encapsulado);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getArmadura() {
		// TODO Auto-generated method stub
		return this.encapsulado.getArmadura() * 0.5;
	}

	@Override
	public double getAtaqueCorto() {
		// TODO Auto-generated method stub
		return this.encapsulado.getAtaqueCorto() * 1.8;
	}

	@Override
	public double getAtaqueDistante() {
		// TODO Auto-generated method stub
		return this.encapsulado.getAtaqueDistante() * 1.7;
	}

}
