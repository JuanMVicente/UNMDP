package dato;

import java.time.LocalDate;

public class ResultadosContrataciones {

	private Empleador empleador;
	private EmpleadoPretenso empleado;
	private double comisionEmpleador;
	private double comisionEmpleado;
	private LocalDate fecha;
	
	public ResultadosContrataciones(Empleador empleador, EmpleadoPretenso empleado, double comisionEmpleador,
		double comisionEmpleado, LocalDate fecha) {
		super();
		this.empleador = empleador;
		this.empleado = empleado;
		this.comisionEmpleador = comisionEmpleador;
		this.comisionEmpleado = comisionEmpleado;
		this.fecha = fecha;
		
	}
    
	
	
	public Empleador getEmpleador() {
		return empleador;
	}

	public EmpleadoPretenso getEmpleado() {
		return empleado;
	}

	public double getComisionEmpleador() {
		return comisionEmpleador;
	}

	public double getComisionEmpleado() {
		return comisionEmpleado;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	@Override
	public String toString() {
		return this.getEmpleador().getNombreUsuario()+" CONTRATO A "+this.getEmpleado().getNombreUsuario();
	}
	
	
}
