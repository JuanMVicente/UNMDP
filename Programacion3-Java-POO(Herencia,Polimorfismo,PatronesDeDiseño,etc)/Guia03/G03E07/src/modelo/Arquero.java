package modelo;

public class Arquero extends Jugador {
	
	public Arquero(String nombre, double velocidad, double potencia) {
		super(nombre, velocidad, potencia);
		// TODO Auto-generated constructor stub
	}

	private double efectividad = 0.5;
	
	@Override
	public double indiceDefensa() {
		// TODO Auto-generated method stub
		return this.efectividad;
	}

	@Override
	public double indiceAtaque() {
		// TODO Auto-generated method stub
		return 0.1 * super.velocidad * super.potencia;
	}

	@Override
	public String toString() {
		return "Arquero [efectividad=" + efectividad + ", velocidad=" + velocidad + ", potencia=" + potencia
				+ ", indiceDefensa()=" + indiceDefensa() + ", indiceAtaque()=" + indiceAtaque()  +"]";
	}
	
}
