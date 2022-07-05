package modelo;

public abstract class DecoratorElementos implements IPersonaje {

	protected IPersonaje encapsulado;


	public DecoratorElementos(IPersonaje encapsulado){
	super();
	this.encapsulado = encapsulado;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.encapsulado.getNombre();
	}

}
