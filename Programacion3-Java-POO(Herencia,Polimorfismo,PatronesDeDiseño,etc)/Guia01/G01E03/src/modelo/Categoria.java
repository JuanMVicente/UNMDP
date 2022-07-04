package modelo;

public class Categoria {
	private String nombreCategoria;
	private double sueldoPorHora;
	
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public double getSueldoPorHora() {
		return sueldoPorHora;
	}
	public Categoria(String nombreCategoria, double sueldoPorHora) {
		this.nombreCategoria = nombreCategoria;
		this.sueldoPorHora = sueldoPorHora;
	}
	
	
}
