package modelo;

import java.time.LocalDateTime;

public class Partido {
	private Equipo local;
	private Equipo visitante;
	private LocalDateTime fecha;
	private int golesLocal;
	private int golesVisitante;
	private Jugador jugadoresGolesLocal[];
	private Jugador jugadoresGolesVisitante[];
	
	private int a[];
	
	void sumaPuntaje() {
		if(this.golesLocal>this.golesVisitante) {
			this.local.setPartidosGanados(this.local.getPartidosGanados()+1);
			this.visitante.setPartidosPerdidos(this.visitante.getPartidosPerdidos()+1);
		}
		else
			if(this.golesLocal<this.golesVisitante) {
				this.visitante.setPartidosGanados(this.visitante.getPartidosGanados()+1);
				this.local.setPartidosPerdidos(this.local.getPartidosPerdidos()+1);
			}
			else
				this.local.setPartidosEmpatados(this.local.getPartidosEmpatados()+1);
				this.visitante.setPartidosEmpatados(this.visitante.getPartidosEmpatados()+1);
	}
	
}
