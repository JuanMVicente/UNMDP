package dato;

import java.time.LocalDateTime;


public class TicketEmpleador extends Ticket {

	private int cantidadEmpleadosSolicitados;
	private int cantidadEmpleadosObtenidos = 0;
	
	public TicketEmpleador(LocalDateTime fechaAlta, int empleadosSolicitados, FormularioBusqueda formularioBusqueda) {
		super(fechaAlta, formularioBusqueda);
		this.cantidadEmpleadosSolicitados = empleadosSolicitados;
	}
	
	public int getCantidadEmpleadosSolicitados() {
		return cantidadEmpleadosSolicitados;
	}
	
	public int getCantidadEmpleadosObtenidos() {
		return cantidadEmpleadosObtenidos;
	}
	
	public void incrCantidadEmpleadosObtenidos() {
		this.cantidadEmpleadosObtenidos += 1;
		
	}
	
	
	@Override
	public String toString() {
		return "TicketEmpleador [cantidadEmpleadosSolicitados=" + cantidadEmpleadosSolicitados
				+ ", cantidadEmpleadosObtenidos=" + cantidadEmpleadosObtenidos + "]" + super.toString();
	}
	
}