package threads;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import dato.EmpleadoPretenso;


/**
 * @author equipo 9
 * Clase donde se comparten los Tickets Simplificados para poder gestioanar los mismos entre los empleadores
 * y los empleados pretensos
 */
public class BolsaDeTrabajo extends Observable {
	private static BolsaDeTrabajo instance = null;
	private ArrayList<TicketSimplificado>  listado = new ArrayList<TicketSimplificado>();
	private boolean termina = false;
	private String respuesta;
	
	
	public static BolsaDeTrabajo getInstance() 
	{
		if(instance == null) 
			instance = new BolsaDeTrabajo();
		   
		return instance;
	}

	public ArrayList<TicketSimplificado> getListadoTicketsSimplificados() {
		return listado;
	}

	/**
	 * Método utilizado para que el empleador agregue un ticket en la bolsa de trabajo.
	 * <b>Pre: </b>Empleador ingresa con la intensión de dejar un ticket simplificado<br>
	 * <b>Post: </b>Bolsa de trabajo con un nuevo ticket<br>
	 * @param ticket
	 */
	public synchronized void agregaTicket(TicketSimplificado ticket) {
	  if(!termina){
		this.listado.add(ticket);
		notifyAll();
		respuesta = (ticket.getEmpleador().getNombre().toUpperCase() + " del rubro " + ticket.getEmpleador().getRubro().toUpperCase() + " dejo un nuevo Ticket, por un trabajo de locacion " + ticket.getLocacion().toString());
		setChanged();
		notifyObservers(respuesta);
	}
}
	
	/*public Synchronized String agregaTicket(TicketSimplificado ticket) {
		// TODO Auto-generated method stub
		this.listado.add(ticket);
		notifyAll();
		return(ticket.getEmpleador().getNombre().toUpperCase() + " del rubro " + ticket.getEmpleador().getRubro().toUpperCase() + " dejo un nuevo Ticket, por un trabajo de locacion " + ticket.getLocacion().toString());
	}*/
	
	
	
	/**
	 * Método utilizado para que el pretenso busque un ticket según lo buscado.
	 * Puede realizar hasta 10 intentos.
	 * <b>Pre: </b>Ingresa EMpleador a buscar un trabajo que satisfaga su búsqueda<br>
	 * <b>Post: </b>Empleador puede o no encontrar tranbajo dependiendo si en la bolsa encontró alguno compatible a su búsqueda<br>
	 * @param empleadoPretenso
	 */
	public void empleadoBuscaTicket(EmpleadoPretensoThreads empleadoPretenso) {
		
		int i=0;
		while(empleadoPretenso.getTicketCerrado() == null && i<10 && !termina) {
			i++;
			Util.espera();
			//System.out.println(empleadoPretenso.getNombre().toUpperCase() + " esta buscando trabajo en el rubro " + empleadoPretenso.getRubroBuscado().toUpperCase() + " y locacion " + empleadoPretenso.getLocacionElegida().toString().toUpperCase() + ", en el intendo " + i);
			respuesta = empleadoPretenso.getNombre().toUpperCase() + " esta buscando trabajo en el rubro " + empleadoPretenso.getRubroBuscado().toUpperCase() + " y locacion " + empleadoPretenso.getLocacionElegida().toString().toUpperCase() + ", en el intendo " + i;
			setChanged();
			notifyObservers(respuesta);
			this.buscaTicketPorRubro(empleadoPretenso);
			if(empleadoPretenso.getTicketsVisitados().size()>0 && empleadoPretenso.getTicketsVisitados().get(empleadoPretenso.getTicketsVisitados().size()-1).getEstado().equals("En Proceso")) {
				double a = empleadoPretenso.getTicketsVisitados().get(empleadoPretenso.getTicketsVisitados().size()-1).getLocacion().versus(empleadoPretenso.getLocacionElegida());
				if(a==1) {
					empleadoPretenso.setTicketCerrado(empleadoPretenso.getTicketsVisitados().get(empleadoPretenso.getTicketsVisitados().size()-1));
					empleadoPretenso.getTicketCerrado().setEstado("Cerrado");
					respuesta = (empleadoPretenso.getNombre().toUpperCase() + " encontró el trabajo buscado en la empresa " + empleadoPretenso.getTicketCerrado().getEmpleador().getNombre().toUpperCase() + " y se cerró el ticket");
					setChanged();
					notifyObservers(respuesta);
				}
				else {
					respuesta = (empleadoPretenso.getNombre().toUpperCase() + " no encontró la locación deseada en el ticket por lo que va a devolver el mismo");
					setChanged();
					notifyObservers(respuesta);
					if(empleadoPretenso.getTicketsVisitados().get(empleadoPretenso.getTicketsVisitados().size()-1).getEstado().equals("En Proceso")) 
						this.devuelveTicket(empleadoPretenso);
					this.duerme();
					
				}
			}
			else {
				respuesta = (empleadoPretenso.getNombre().toUpperCase() + " no encontró ticket con el Rubro de su interés.");
				setChanged();
				notifyObservers(respuesta);
				this.duerme();
			}
			
			//System.out.println(respuesta);
			
		}
		if(termina) {
			//System.out.println(empleadoPretenso.getNombre().toUpperCase() + " no encontró el trabajo deseado en esta simulación");
			respuesta = empleadoPretenso.getNombre().toUpperCase() + " no encontró el trabajo deseado en esta simulación";
			setChanged();
			notifyObservers(respuesta);
		}
	}
	
	/**
	 * Método utilizado para poner a dormir a los threads
	 */
	private synchronized void duerme() {
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * Método para buscar por Rubro en la bolsa de trabajo
	 * @param empleadoPretenso
	 */
	private synchronized void buscaTicketPorRubro(EmpleadoPretensoThreads empleadoPretenso) {
		int j = this.buscaTipoRubro(empleadoPretenso);
		if(j<listado.size()) {
			//System.out.println(empleadoPretenso.getNombre().toUpperCase() + " encontró un ticket de la empresa " + listado.get(j).getEmpleador().getNombre().toUpperCase());
			respuesta = empleadoPretenso.getNombre().toUpperCase() + " encontró un ticket de la empresa " + listado.get(j).getEmpleador().getNombre().toUpperCase();
			setChanged();
			notifyObservers(respuesta);
			empleadoPretenso.getTicketsVisitados().add(listado.get(j));
			listado.get(j).setEstado("En Proceso");
		}
	}
	
	/**
	 * El Empleado Pretenso Devuelve el ticket tomado a la bolsa de trabajo
	 * @param empleadoPretenso
	 */
	public synchronized void devuelveTicket(EmpleadoPretensoThreads empleadoPretenso) {
		int ultimo = empleadoPretenso.getTicketsVisitados().size()-1;
		empleadoPretenso.getTicketsVisitados().get(ultimo).equals("Disponible");
		//System.out.println(empleadoPretenso.getNombre().toUpperCase() + " dejó disponible el Ticket tomado de la empresa " + empleadoPretenso.getTicketsVisitados().get(ultimo).getEmpleador().getNombre().toUpperCase());
		respuesta = empleadoPretenso.getNombre().toUpperCase() + " dejó disponible el Ticket tomado de la empresa " + empleadoPretenso.getTicketsVisitados().get(ultimo).getEmpleador().getNombre().toUpperCase();
		setChanged();
		notifyObservers(respuesta);
		notifyAll();
	}
	/**
	 * Función para encontrar la ubicación de un ticket
	 * @param empleadoPretenso
	 */
	private int buscaTipoRubro(EmpleadoPretensoThreads empleadoPretenso) {
		// TODO Auto-generated method stub
		boolean encontrado = false;
		int i = 0;
		while(i<listado.size() && !encontrado) {
			if(listado.get(i).getEmpleador().getRubro() == empleadoPretenso.getRubroBuscado() && !empleadoPretenso.getTicketsVisitados().contains(listado.get(i)) && listado.get(i).getEstado().equals("Disponible")) 
				encontrado = true;
			else 
				i++;
		}
		return i;
	}
	/**
	 * Función para terminar la busqueda de los threads que no han encontrado trabajo.
	 * @param empleadoPretenso
	 */
	public synchronized void setTermina() {
		this.termina = true;
		notifyAll();
	}


	
}

/*public synchronized void busquedaLaboral(EmpleadoPretensoThreads empleadoPretenso) {
// TODO Auto-generated method stub
System.out.println(empleadoPretenso.getNombre() + " esta buscando trabajo en el rubro " + empleadoPretenso.getRubroBuscado());
int i=0, j=0;
boolean coinciden = false;
//busca dentro del listado de tickets si encuentra el rubro
j = this.buscaTicketTipoRubro(empleadoPretenso);
if(j<listado.size()) {
	coinciden = comparaTicketLocacion(j,empleadoPretenso);
}
while(!coinciden && i<10) {
	i++;
	if(j<listado.size()) this.reordenaListado(j);
	try {
		System.out.println(empleadoPretenso.getNombre() + " no encontró ticket que satisfaga su búsqueda en el intento "+ i +", debe esperar");
		wait();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(empleadoPretenso.getNombre() + " esta buscando trabajo en el rubro " + empleadoPretenso.getRubroBuscado());
	j = this.buscaTicketTipoRubro(empleadoPretenso);
	if(j<listado.size())
		coinciden = comparaTicketLocacion(j,empleadoPretenso);			
}
if(j<listado.size()) { //hubo coincidencia entre emopleado Pretenso y Empleador
	System.out.println(empleadoPretenso.getNombre() + " consiguió trabajo en la empresa " + listado.get(j).getEmpleador().getNombre());
	this.listado.remove(j);
}
else
	System.out.println(empleadoPretenso.getNombre() + " buscó en la bolsa de trabajo 10 veces y no tuvo exito");
notifyAll();
}*/

/*private void reordenaListado(int j) {
// TODO Auto-generated method stub
TicketSimplificado ticket = listado.get(j);
listado.remove(j);
listado.add(ticket);

}*/

/*private boolean comparaTicketLocacion(int j, EmpleadoPretensoThreads empleadoPretenso) {
// TODO Auto-generated method stub
//listado.get(j).
double a = listado.get(j).getLocacion().versus(empleadoPretenso.getLocacionElegida());
if(a == -1)
	return false;
else
	return true;
}*/

