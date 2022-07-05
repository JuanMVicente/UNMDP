package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Equipo {
	private String nombre;
	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	
	
	public double indiceDefensa() {
		double aux=0;
		for(int i=0; i<jugadores.size(); i++) {
			aux += this.jugadores.get(i).indiceDefensa();
		}
		return aux;
	}
	
	public double indiceAtaque() {
		double aux=0;
		for(int i=0; i<jugadores.size(); i++) {
			aux += this.jugadores.get(i).indiceAtaque();
		}
		return aux;
	}
	
	public String agregaJugador(String tipo, String nombre, double velocidad, double potencia){
		if(velocidad>1 || velocidad<0) {
			if(potencia<0 || potencia>1) {
				jugadores.add(JugadorFactory.getJugador(tipo,nombre,velocidad,potencia));
				return "Jugador Agregado";
			}
			else
				return "Potencia Incorrecta";
		}
		else
			return "Velocidad Incorrecta";
	}

	public void eliminaJugador(Jugador jugador) {
		this.jugadores.remove(jugador);
	}

	public Iterator<Jugador> getJugadores() {
		 return this.getJugadores();
	}
	
	

}
