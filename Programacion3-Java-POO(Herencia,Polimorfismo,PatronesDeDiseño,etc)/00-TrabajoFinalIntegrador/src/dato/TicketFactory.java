package dato;

import java.time.LocalDateTime;

public class TicketFactory {

	public static Ticket getTicket(int tipo, LocalDateTime fechaAlta, FormularioBusqueda formularioBusqueda, int empleadosSolicitados) {
		Ticket ticket = null;
		if(tipo == 0) {//Empleado Pretenso
			ticket = new TicketEmpleado(fechaAlta, formularioBusqueda);
		}
		else if(tipo==1) {//Empleador Fisico
			ticket = new TicketEmpleador(fechaAlta, empleadosSolicitados, formularioBusqueda);
		}
		else if(tipo==2) {//Empleador Juridico
			ticket = new TicketEmpleado(fechaAlta, formularioBusqueda);
		}
		return ticket;
		
		
	}
}