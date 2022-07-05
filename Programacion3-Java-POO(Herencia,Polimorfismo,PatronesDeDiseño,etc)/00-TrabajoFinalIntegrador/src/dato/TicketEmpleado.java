package dato;

import java.time.LocalDateTime;


public class TicketEmpleado extends Ticket{
	
	private int resultado;  // 0 = Espera --  1 = Exito --  -1 = fracaso  
	
	public TicketEmpleado(LocalDateTime fechaAlta, FormularioBusqueda formularioBusqueda) {
		super(fechaAlta, formularioBusqueda);
		this.resultado = 0;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "TicketEmpleado [resultado=" + resultado + "]" + super.toString();
	}

}