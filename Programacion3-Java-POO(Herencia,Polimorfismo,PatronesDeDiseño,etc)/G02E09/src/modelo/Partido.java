package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Partido {
	private ArrayList<Jugador> equipo1 = new ArrayList<Jugador>();
	private ArrayList<Jugador> equipo2 = new ArrayList<Jugador>();

	private LocalDateTime fecha;
	
	private int ganador;
	
	
	
	public ArrayList<Jugador> getEquipo1() {
		return equipo1;
	}



	public void setEquipo1(ArrayList<Jugador> equipo1) {
		this.equipo1 = equipo1;
	}



	public ArrayList<Jugador> getEquipo2() {
		return equipo2;
	}



	public void setEquipo2(ArrayList<Jugador> equipo2) {
		this.equipo2 = equipo2;
	}



	public LocalDateTime getFecha() {
		return fecha;
	}



	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}



	public int getGanador() {
		return ganador;
	}



	public void setGanador(int ganador) {
		this.ganador = ganador;
	}



	public void registraGanador(int ganador) {
		int i=0;
		if(ganador == 1)
			for(; i<equipo1.size();i++) {
				this.equipo1.get(i).setPuntos(this.equipo1.get(i).getPuntos()+3);
			}
		else
			if(ganador == 2)
				for(; i<equipo2.size();i++) {
					this.equipo2.get(i).setPuntos(this.equipo2.get(i).getPuntos()+3);
				}
			else
				if(ganador == 0) {
					for(; i<equipo1.size();i++) {
						this.equipo1.get(i).setPuntos(this.equipo1.get(i).getPuntos()+1);
					}					
					for(; i<equipo2.size();i++) {
						this.equipo2.get(i).setPuntos(this.equipo2.get(i).getPuntos()+1);
					}
				}
	}
	


}
