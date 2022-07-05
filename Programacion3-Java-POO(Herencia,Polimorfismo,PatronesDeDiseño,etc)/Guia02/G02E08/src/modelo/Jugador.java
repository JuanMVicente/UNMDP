package modelo;

import java.time.LocalDateTime;

public class Jugador {
	private String nombre;
	private LocalDateTime nacimiento;
	private int camiseta;
	private int posicion;
	private int partidosJugados;
	private int goles;
	
	
	public Jugador(String nombre, int camiseta, int posicion, int partidosJugados, int goles) {
		super();
		this.nombre = nombre;
		this.camiseta = camiseta;
		this.posicion = posicion;
		this.partidosJugados = partidosJugados;
		this.goles = goles;
	}
	
	public String getNombre() {
		return nombre;
	}
	public LocalDateTime getNacimiento() {
		return nacimiento;
	}
	public int getCamiseta() {
		return camiseta;
	}
	public int getPosicion() {
		return posicion;
	}
	public int getPartidosJugados() {
		return partidosJugados;
	}
	public int getGoles() {
		return goles;
	}
	
	
}
