package modelo;

import java.util.ArrayList;

public class FutbolAmateur {
	private ArrayList<Partido> partidos = new ArrayList<Partido>();
	
	
	public int partidosJudados(Jugador jugador) {
		int i=0;
		int contador=0;
		for(;i<this.partidos.size();i++) {
			if(this.partidos.get(i).getEquipo1().contains(jugador) || this.partidos.get(i).getEquipo2().contains(jugador)) {
				contador++;
			}
		}
		return contador;
	}
	public int partidosGanados(Jugador jugador) {
		int i=0;
		int contador=0;
		for(;i<this.partidos.size();i++) {
			if(this.partidos.get(i).getEquipo1().contains(jugador) && this.partidos.get(i).getGanador()==1) {
				contador++;
			}
			else
				if(this.partidos.get(i).getEquipo2().contains(jugador) && this.partidos.get(i).getGanador()==2) {
					contador++;
				}
		}
		return contador;
	}
	public int partidosPerdidos(Jugador jugador) {
		int i=0;
		int contador=0;
		for(;i<this.partidos.size();i++) {
			if(this.partidos.get(i).getEquipo1().contains(jugador) && this.partidos.get(i).getGanador()==2) {
				contador++;
			}
			else
				if(this.partidos.get(i).getEquipo2().contains(jugador) && this.partidos.get(i).getGanador()==1) {
					contador++;
				}
		}
		return contador;
	}
	
	public int partidosEmpatados(Jugador jugador) {
		return this.partidosJudados(jugador)-this.partidosGanados(jugador)-this.partidosPerdidos(jugador);
	}
	
	public int partidosJuntos(Jugador j1, Jugador j2) {
		int contador = 0;
		for(int i=0;i<this.partidos.size();i++) {
			if( this.partidos.get(i).getEquipo1().contains(j1) && this.partidos.get(i).getEquipo1().contains(j2)) {
				contador++;
			}
			else if( this.partidos.get(i).getEquipo2().contains(j1) && this.partidos.get(i).getEquipo2().contains(j2)) {
				contador++;
			}
		}
		return contador;
	}
	public int partidosSeparados(Jugador j1, Jugador j2) {
		int contador = 0;
		for(int i=0;i<this.partidos.size();i++) {
			if( this.partidos.get(i).getEquipo1().contains(j1) && this.partidos.get(i).getEquipo2().contains(j2)) {
				contador++;
			}
			else if( this.partidos.get(i).getEquipo2().contains(j1) && this.partidos.get(i).getEquipo1().contains(j2)) {
				contador++;
			}
		}
		return contador;
	}
}
