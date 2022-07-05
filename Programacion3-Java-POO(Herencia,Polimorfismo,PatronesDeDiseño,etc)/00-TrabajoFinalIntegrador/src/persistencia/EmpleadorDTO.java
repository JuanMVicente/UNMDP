package persistencia;

import java.io.Serializable;

public class EmpleadorDTO extends UsuarioExternoDTO implements Serializable {

	private String rubro; // "salud" - "comercio local" - "comercio internacional"
	private TicketEmpleadorDTO ticketEmpleador;
	private String tipoEmpleador;

	public String getTipoEmpleador() {
		return tipoEmpleador;
	}
	public void setTipoEmpleador(String tipoEmpleador) {
		this.tipoEmpleador = tipoEmpleador;
	}
	public String getRubro() {
		return rubro;
	}
	public void setRubro(String rubro) {
		this.rubro = rubro;
	}
	public TicketEmpleadorDTO getTicketEmpleador() {
		return ticketEmpleador;
	}
	public void setTicketEmpleador(TicketEmpleadorDTO ticketEmpleadorDTO) {
		this.ticketEmpleador = ticketEmpleadorDTO;
	}
	
	
}
