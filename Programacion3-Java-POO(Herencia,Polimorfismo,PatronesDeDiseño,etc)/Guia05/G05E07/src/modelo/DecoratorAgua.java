package modelo;

public class DecoratorAgua extends DecoratorElementos {

	public DecoratorAgua(IPersonaje encapsulado) {
		super(encapsulado);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getArmadura() {
		// TODO Auto-generated method stub
		return this.encapsulado.getArmadura() * 0.85;
	}

	@Override
	public double getAtaqueCorto() {
		// TODO Auto-generated method stub
		return this.encapsulado.getAtaqueCorto() * 1.2;
	}

	@Override
	public double getAtaqueDistante() {
		// TODO Auto-generated method stub
		return this.encapsulado.getAtaqueDistante();
	}
}
