package modelo;

public class EmpleadoTemporario extends Empleado{
	private double sueldoHora;
	private int cantHoras;
	
	
	public EmpleadoTemporario(String nombre, int legajo, String domicilio, double sueldoHora, int cantHoras) {
		super(nombre, legajo, domicilio);
		this.sueldoHora = sueldoHora;
		this.cantHoras = cantHoras;
	}


	@Override
	public double calculoSueldo() {
		double sueldo = cantHoras * sueldoHora;
		return sueldo;
	}
	
	
	
}
