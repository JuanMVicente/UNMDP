package modelo;

import java.time.LocalDateTime;

public class Libro extends Articulo implements Prestable{
	private boolean prestado = false;

	public Libro(int codigo, String titulo, LocalDateTime fechaPublicacion) {
		super(codigo, titulo, fechaPublicacion);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isPrestado() {
		return prestado;
	}

	
	
	@Override
	public String toString() {
		return "Articulo [codigo=" + this.getCodigo() + ", titulo=" + this.getTitulo() + ", fechaPublicacion=" + this.getFechaPublicacion() + "prestado=" + prestado + "]";
	}

	@Override
	public void prestar() {
		// TODO Auto-generated method stub
		this.prestado = true;
	}

	@Override
	public void devolver() {
		// TODO Auto-generated method stub
		this.prestado = false;
	}
	
	
}
