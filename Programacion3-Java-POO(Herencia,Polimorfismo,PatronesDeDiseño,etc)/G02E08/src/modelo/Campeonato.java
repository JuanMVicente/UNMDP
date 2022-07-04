package modelo;

import java.util.ArrayList;

public class Campeonato {
	private static Campeonato instance = null;
	private ArrayList<Equipo> equipos = new ArrayList<Equipo>();
	
	private Campeonato() {	
	}
	
	public static Campeonato getInstance() 
	{
		if(instance == null)
			instance = new Campeonato();
		return instance;
	}
	
	public double promedio(Jugador jugador){
		return jugador.getGoles()/jugador.getPartidosJugados();
	}
	
	public Jugador comparaGoles(Jugador j1, Jugador j2) {
		if(j1.getGoles()>j2.getGoles())
			return j1;
		else
			if(j1.getGoles()<j2.getGoles())
				return j2;
			else
				if(promedio(j1)>=promedio(j2))
					return j1;
				else
					return j2;
	}
	
	public int puntosObtenidosEquipo(Equipo equipo) {
		return equipo.getPartidosGanados()*3+equipo.getPartidosEmpatados();
	}
	
	public int partidosJugadosEquipo(Equipo equipo) {
		return equipo.getPartidosGanados()+equipo.getPartidosEmpatados()+equipo.getPartidosPerdidos();
	}
	
	public Equipo comparaPuntajes(Equipo e1, Equipo e2) {
		if(puntosObtenidosEquipo(e1)>puntosObtenidosEquipo(e1))
			return e1;
		else
			if(puntosObtenidosEquipo(e1)<puntosObtenidosEquipo(e1))
				return e2;
			else
				if(e1.getGolesAFavor()>e2.getGolesEnContra())
					return e1;
				else
					if(e1.getGolesAFavor()<e2.getGolesEnContra())
						return e2;
					else
						if(e1.getGolesEnContra()>e2.getGolesEnContra())
							return e1;
						else
							return e2;
	}	
	
	
	
}
