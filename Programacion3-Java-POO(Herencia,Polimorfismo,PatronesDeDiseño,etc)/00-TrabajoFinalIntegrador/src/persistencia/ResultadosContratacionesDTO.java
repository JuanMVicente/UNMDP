package persistencia;

import java.io.Serializable;
import java.time.LocalDate;

public class ResultadosContratacionesDTO implements Serializable {
	private String empleadorNombreUsuario;
	private String empleadoNombreUsuario;
	private double comisionEmpleador;
	private double comisionEmpleado;
	private LocalDate fecha;

	

	public String getEmpleadorNombreUsuario() {
		return empleadorNombreUsuario;
	}
	public void setEmpleadorNombreUsuario(String empleadorNombreUsuario) {
		this.empleadorNombreUsuario = empleadorNombreUsuario;
	}
	public String getEmpleadoNombreUsuario() {
		return empleadoNombreUsuario;
	}
	public void setEmpleadoNombreUsuario(String empleadoNombreUsuario) {
		this.empleadoNombreUsuario = empleadoNombreUsuario;
	}
	public double getComisionEmpleador() {
		return comisionEmpleador;
	}
	public void setComisionEmpleador(double comisionEmpleador) {
		this.comisionEmpleador = comisionEmpleador;
	}
	public double getComisionEmpleado() {
		return comisionEmpleado;
	}
	public void setComisionEmpleado(double comisionEmpleado) {
		this.comisionEmpleado = comisionEmpleado;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

}
