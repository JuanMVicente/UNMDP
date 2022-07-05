package dato;

import java.time.LocalDateTime;

/**
 * @author Grupo 9
 * 
 * Clase que desarrolla el objeto ticket, que sera padre de ticketemplaedo y padre de ticketempleador. Contiene como parametros, la fecha de alta del mismo, el estado y su correspondiente formulario de busqueda.
 */

public class Ticket {
	
	private LocalDateTime fechaAlta;
	private String estado = EstadosTickets.activo;     
	private FormularioBusqueda formularioBusqueda;

	/**
	 * Constructor del ticket, tiene como parametros la fecha de alta del mismo y su respectivo formulario de busqueda ya validado.
	 **/
	public Ticket(LocalDateTime fechaAlta, FormularioBusqueda formularioBusqueda) {
		super();
		this.fechaAlta = fechaAlta;
		this.formularioBusqueda = formularioBusqueda;
	}

	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}
	
	public void setFechaAlta(LocalDateTime fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getEstado() {
		return estado;
	}

	public FormularioBusqueda getFormularioBusqueda() {
		return formularioBusqueda;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	@Override
	public String toString() {
		return "Ticket [fechaAlta=" + fechaAlta + ", estado=" + estado + ", formularioBusqueda=" + formularioBusqueda
				+ "]";
	}
		
	
} 