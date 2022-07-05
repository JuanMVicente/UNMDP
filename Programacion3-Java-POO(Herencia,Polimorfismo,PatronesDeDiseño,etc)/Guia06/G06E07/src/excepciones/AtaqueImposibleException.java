package excepciones;

import modelo.Personaje;

public class AtaqueImposibleException extends Exception {
	private Personaje atacante;
	private Personaje Atacado;
	public AtaqueImposibleException(Personaje atacante, Personaje atacado) {
		super();
		this.atacante = atacante;
		Atacado = atacado;
	}
	public Personaje getAtacante() {
		return atacante;
	}
	public Personaje getAtacado() {
		return Atacado;
	}
	
	
}
