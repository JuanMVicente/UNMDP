package modelo;

public class Libro {

	private int idnum;
	private String titulo;
	
	public int getIdnum() {
		return idnum;
	}
	public String getTitulo() {
		return titulo;
	}
	public Libro(int idnum, String titulo) {
		super();
		this.idnum = idnum;
		this.titulo = titulo;
	}
}
