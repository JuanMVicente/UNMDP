package threads;

import java.util.ArrayList;

import dato.TiposDatosTicktets;
import negocio.Ilocacion;

public class EmpleadoPretensoThreads extends Thread {
	private String nombre;
	private BolsaDeTrabajo bolsaDeTrabajo;
	private String rubroBuscado;
	private Ilocacion locacionElegida;
	private ArrayList<TicketSimplificado>  ticketsVisitados = new ArrayList<TicketSimplificado>();
	private TicketSimplificado ticketCerrado = null;
	
	public EmpleadoPretensoThreads(String nombre) {
		super();
		this.nombre = nombre;
		this.rubroBuscado = Tipos.tipoPuesto(Util.random());
		int locacion = Util.random();
		if(TiposDatosTicktets.getLocacion().containsKey(locacion)) { 
			this.locacionElegida = TiposDatosTicktets.getLocacion().get(locacion);
		}
		this.bolsaDeTrabajo = BolsaDeTrabajo.getInstance();
		
		//System.out.println("empleado pretenso " + this.locacionElegida + " ## ");
	}
	
	
	public ArrayList<TicketSimplificado> getTicketsVisitados() {
		return ticketsVisitados;
	}

	
	public BolsaDeTrabajo getBolsaDeTrabajo() {
		return bolsaDeTrabajo;
	}


	public void setBolsaDeTrabajo(BolsaDeTrabajo bolsaDeTrabajo) {
		this.bolsaDeTrabajo = bolsaDeTrabajo;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setRubroBuscado(String rubroBuscado) {
		this.rubroBuscado = rubroBuscado;
	}


	public void setLocacionElegida(Ilocacion locacionElegida) {
		this.locacionElegida = locacionElegida;
	}


	public void setTicketsVisitados(ArrayList<TicketSimplificado> ticketsVisitados) {
		this.ticketsVisitados = ticketsVisitados;
	}

	public TicketSimplificado getTicketCerrado() {
		return ticketCerrado;
	}

	public void setTicketCerrado(TicketSimplificado ticketCerrado) {
		this.ticketCerrado = ticketCerrado;
	}

	public String getRubroBuscado() {
		return rubroBuscado;
	}
	
	
	public Ilocacion getLocacionElegida() {
		return locacionElegida;
	}



	public String getNombre() {
		return nombre;
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Util.espera();
		this.bolsaDeTrabajo.empleadoBuscaTicket(this);
	}

}
