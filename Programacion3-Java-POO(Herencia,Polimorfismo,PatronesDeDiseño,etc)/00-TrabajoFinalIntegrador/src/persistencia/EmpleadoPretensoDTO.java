package persistencia;

import java.io.Serializable;
import java.time.LocalDate;


public class EmpleadoPretensoDTO extends UsuarioExternoDTO implements Serializable {
	
	private String telefono;
	private String fechaNacimiento;
	private String dni;
	private TicketEmpleadoDTO TicketEmpleadoP;
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public TicketEmpleadoDTO getTicketEmpleadoP() {
		return TicketEmpleadoP;
	}
	public void setTicketEmpleadoP(TicketEmpleadoDTO ticketEmpleadoP) {
		TicketEmpleadoP = ticketEmpleadoP;
	}
	
	

}
