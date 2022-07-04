package modelo;

import java.util.ArrayList;

public class Equipo {
	private String nombre;
	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	private int partidosGanados;
	private int partidosEmpatados;
	private int partidosPerdidos;
	private int golesAFavor;
	private int golesEnContra;
	
	public String getNombre() {
		return nombre;
	}
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}
	public int getPartidosGanados() {
		return partidosGanados;
	}
	public int getPartidosEmpatados() {
		return partidosEmpatados;
	}
	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}
	public int getGolesAFavor() {
		return golesAFavor;
	}
	public int getGolesEnContra() {
		return golesEnContra;
	}
	
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}
	public void setPartidosEmpatados(int partidosEmpatados) {
		this.partidosEmpatados = partidosEmpatados;
	}
	public void setPartidosPerdidos(int partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}
	public void setGolesAFavor(int golesAFavor) {
		this.golesAFavor = golesAFavor;
	}
	public void setGolesEnContra(int golesEnContra) {
		this.golesEnContra = golesEnContra;
	}
	public Jugador goleadorEquipo() {
		Jugador jugador = null;
		int goles=-1;
		for(int i=0; i<this.jugadores.size();i++) {
			if(goles<jugadores.get(i).getGoles())
				goles=jugadores.get(i).getGoles();
				jugador = jugadores.get(i);
		}
		return jugador;
	}
	
}
