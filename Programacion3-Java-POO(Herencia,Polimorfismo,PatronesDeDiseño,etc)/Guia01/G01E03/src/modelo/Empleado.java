package modelo;

public class Empleado {
	private String nombre;
	private int antiguedad, horasTrabajadas;
	private Categoria cat;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}
	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}
	public Categoria getCat() {
		return cat;
	}
	public void setCat(Categoria cat) {
		this.cat = cat;
	}
	
	public double getSueldo() {
		double aux;
		aux = this.cat.getSueldoPorHora() * this.horasTrabajadas;
		if(this.antiguedad>5) {
			if(this.antiguedad<10)
				aux *= 1.25;
			else
				aux *= 1.35;
		}
		return aux;
	}

	public String detalle() {
		String retorno = "Nombre: " + this.nombre + 
				"\nAntiguedad: " + this.antiguedad + " años\nHoras Trabajadas: " + this.horasTrabajadas
				+ "\nTipo de Categoria: " + this.cat.getNombreCategoria() + "\nSueldo por hora: " +
				this.cat.getSueldoPorHora() + "\nSueldo a cobrar: " + this.getSueldo() + "\n";
		
		return retorno;
	}
	
}
