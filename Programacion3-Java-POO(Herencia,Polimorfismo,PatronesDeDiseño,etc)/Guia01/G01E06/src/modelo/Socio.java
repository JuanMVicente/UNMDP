package modelo;

public class Socio {
	private String nombre;
	private int edad;
	
	public Socio(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	
	
	public double calcularCuota() {
		if(edad<18)
			return 500 * (1 - 0,25);
		else
			if(edad>65)
				return 500 * (1 - 0,5);
			else
				return 500;
	}
}
