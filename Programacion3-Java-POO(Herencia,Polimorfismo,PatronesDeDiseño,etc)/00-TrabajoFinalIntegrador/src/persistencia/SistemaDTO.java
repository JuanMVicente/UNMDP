package persistencia;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 * @author equipo 9
 * Clase Serializable que almacena todos los datos del sistema
 */
public class SistemaDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static SistemaDTO instance = null;
	private ArrayList<EmpleadorDTO> empleadores = new ArrayList<EmpleadorDTO>();
	private ArrayList<EmpleadoPretensoDTO> empleados = new ArrayList<EmpleadoPretensoDTO>();
	private ArrayList<TicketEmpleadoDTO> ticketEmpleados = new ArrayList<TicketEmpleadoDTO>();
	private ArrayList<TicketEmpleadorDTO> ticketEmpleadores = new ArrayList<TicketEmpleadorDTO>();
	private AdministradorAgenciaDTO administradorDeAgencia = null;
	private LocalDateTime fechaRondaencuentros = null;
	private ArrayList<ResultadosContratacionesDTO> historialResultados = new ArrayList<ResultadosContratacionesDTO>();
	private boolean botonRondas;
	
	public static SistemaDTO getInstance() {
		if(instance == null)
			instance = new SistemaDTO();
		return instance;
	}
	
	public ArrayList<EmpleadorDTO> getEmpleadores() {
		return empleadores;
	}
	public void setEmpleadores(ArrayList<EmpleadorDTO> empleadores) {
		this.empleadores = empleadores;
	}
	public ArrayList<EmpleadoPretensoDTO> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(ArrayList<EmpleadoPretensoDTO> empleados) {
		this.empleados = empleados;
	}
	public ArrayList<TicketEmpleadoDTO> getTicketEmpleados() {
		return ticketEmpleados;
	}
	public void setTicketEmpleados(ArrayList<TicketEmpleadoDTO> ticketsEmpleados) {
		this.ticketEmpleados = ticketsEmpleados;
	}
	public ArrayList<TicketEmpleadorDTO> getTicketEmpleadores() {
		return ticketEmpleadores;
	}
	public void setTicketEmpleadores(ArrayList<TicketEmpleadorDTO> ticketEmpleadores) {
		this.ticketEmpleadores = ticketEmpleadores;
	}
	public AdministradorAgenciaDTO getAdministradorDeAgencia() {
		return administradorDeAgencia;
	}
	public void setAdministradorDeAgencia(AdministradorAgenciaDTO administradorDeAgencia) {
		this.administradorDeAgencia = administradorDeAgencia;
	}
	public LocalDateTime getFechaRondaencuentros() {
		return fechaRondaencuentros;
	}
	public void setFechaRondaencuentros(LocalDateTime fechaRondaencuentros) {
		this.fechaRondaencuentros = fechaRondaencuentros;
	}
	public ArrayList<ResultadosContratacionesDTO> getHistorialResultados() {
		return historialResultados;
	}
	public void setHistorialResultados(ArrayList<ResultadosContratacionesDTO> historialResultados) {
		this.historialResultados = historialResultados;
	}

	public boolean isBotonRondas() {
		return botonRondas;
	}

	public void setBotonRondas(boolean botonRondas) {
		this.botonRondas = botonRondas;
	}

	
}
