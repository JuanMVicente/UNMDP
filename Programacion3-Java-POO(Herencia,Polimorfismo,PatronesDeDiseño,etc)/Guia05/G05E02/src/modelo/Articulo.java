package modelo;

import java.time.LocalDateTime;

public class Articulo {
	private int codigo;
	private String titulo;
	private LocalDateTime fechaPublicacion;
	
	public Articulo(int codigo, String titulo, LocalDateTime fechaPublicacion) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.fechaPublicacion = fechaPublicacion;
	}


	public int getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public LocalDateTime getFechaPublicacion() {
		return fechaPublicacion;
	}

	@Override
	public String toString() {
		return "Articulo [codigo=" + codigo + ", titulo=" + titulo + ", fechaPublicacion=" + fechaPublicacion + "]";
	}
	
	
}
