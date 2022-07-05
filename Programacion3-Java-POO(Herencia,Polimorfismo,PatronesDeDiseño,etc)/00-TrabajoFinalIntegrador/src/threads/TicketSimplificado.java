package threads;

import dato.TiposDatosTicktets;
import negocio.Ilocacion;

public class TicketSimplificado {
	private Ilocacion locacion;
	private EmpleadorThreads empleador;
	private String estado;
	
	public TicketSimplificado(Integer intLocacion, EmpleadorThreads empleador) {
		super();
		this.empleador = empleador;
		if(TiposDatosTicktets.getLocacion().containsKey(intLocacion)) { 
		 	this.locacion = TiposDatosTicktets.getLocacion().get(intLocacion);
		}
		this.estado = "Disponible";
	}

	public EmpleadorThreads getEmpleador() {
		return empleador;
	}
	
	public Ilocacion getLocacion() {
		return locacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
