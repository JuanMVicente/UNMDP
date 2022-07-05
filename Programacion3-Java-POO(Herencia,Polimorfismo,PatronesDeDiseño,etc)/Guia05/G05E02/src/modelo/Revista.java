package modelo;

import java.time.LocalDateTime;

public class Revista extends Articulo {

	private int numero;
	
	public Revista(int codigo, String titulo, LocalDateTime fechaPublicacion, int numero) {
		super(codigo, titulo, fechaPublicacion);
		// TODO Auto-generated constructor stub
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Articulo [codigo=" + this.getCodigo() + ", titulo=" + this.getTitulo() + ", fechaPublicacion=" + this.getFechaPublicacion() + "numero=" + numero + "]";
	}

	
}
