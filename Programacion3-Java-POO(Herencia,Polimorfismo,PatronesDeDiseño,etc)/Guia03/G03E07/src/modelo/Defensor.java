package modelo;

public class Defensor extends Jugador {

	public Defensor(String nombre, double velocidad, double potencia) {
		super(nombre, velocidad, potencia);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double indiceDefensa() {
		// TODO Auto-generated method stub
		return super.velocidad * super.velocidad;
	}

	@Override
	public double indiceAtaque() {
		// TODO Auto-generated method stub
		return super.potencia * super.potencia;
	}

	@Override
	public String toString() {
		return "Defensor [velocidad=" + velocidad + ", potencia=" + potencia + ", indiceDefensa()=" + indiceDefensa()
				+ ", indiceAtaque()=" + indiceAtaque() + "]";
	}


}
