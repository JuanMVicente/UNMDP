package modelo;

public class Delantero extends Jugador {

	public Delantero(String nombre, double velocidad, double potencia) {
		super(nombre, velocidad, potencia);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double indiceDefensa() {
		// TODO Auto-generated method stub
		return super.velocidad*0.5;
	}

	@Override
	public double indiceAtaque() {
		// TODO Auto-generated method stub
		return super.velocidad * super.potencia;
	}

	@Override
	public String toString() {
		return "Delantero [velocidad=" + velocidad + ", potencia=" + potencia + ", indiceDefensa()=" + indiceDefensa()
				+ ", indiceAtaque()=" + indiceAtaque() + "]";
	}
	
	
}
