package modelo;

public abstract class Empleado {
	private String nombre;
	private int legajo;
	private String domicilio;
	
		
	public Empleado(String nombre, int legajo, String domicilio) {
		this.nombre = nombre;
		this.legajo = legajo;
		this.domicilio = domicilio;
	}


	public String getNombre() {
		return nombre;
	}


	public int getLegajo() {
		return legajo;
	}


	public String getDomicilio() {
		return domicilio;
	}
	
	public abstract double calculoSueldo();
	
	/*public boolean prueba() {
		if(this.calculoSueldo()>10)
			return true;
		else
			return false;
	}*/
		
}
