package modelo;

public class JugadorFactory {
	
	public static Jugador getJugador(String tipo, String nombre, double velocidad, double potencia) {
		Jugador jugador = null;
		if(tipo.equals("Delantero"))
			jugador = new Delantero(nombre,velocidad, potencia);
		else if(tipo.equals("Defensor"))
			jugador = new Defensor(nombre,velocidad, potencia);
		else if(tipo.equals("Arquero"))
			jugador = new Arquero(nombre,velocidad, potencia);
		return jugador;
	}
}
