package modelo;

public class DecoratorTierra extends DecoratorElementos {

	public DecoratorTierra(IPersonaje encapsulado) {
		super(encapsulado);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getArmadura() {
		// TODO Auto-generated method stub
		return this.encapsulado.getArmadura() * 1.25;
	}

	@Override
	public double getAtaqueCorto() {
		// TODO Auto-generated method stub
		return this.encapsulado.getAtaqueCorto() * 0.8;
	}

	@Override
	public double getAtaqueDistante() {
		// TODO Auto-generated method stub
		return this.encapsulado.getAtaqueDistante() * 0.7;
	}

}
