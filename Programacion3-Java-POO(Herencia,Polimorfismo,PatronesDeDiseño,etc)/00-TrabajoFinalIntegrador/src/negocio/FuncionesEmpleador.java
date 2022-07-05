package negocio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dato.EmpleadoPretenso;
import dato.Empleador;
import dato.EstadosTickets;
import dato.GeneradorFormulario;
import dato.ResultadosContrataciones;
import dato.TicketEmpleador;
import dato.UsuarioExterno;
import exceptions.ArrayVacioException;
import exceptions.EstadoTicketException;
import exceptions.FechaExpiradaException;
import exceptions.ObjetoNoEstaEnLaListaException;
import exceptions.ParametroFormularioFactoryException;
import exceptions.ParametroInvalidoException;

/**
 * @author Grupo9 <br>
 * Clase sistema de las funcionalidades a las que pueden acceder los usuarios de tipo Empleador <br>
 */
public class FuncionesEmpleador implements IFuncionesUsuariosExternos {
	private Sistema sistema = Sistema.getInstance();

	
	/**
	 ** Metodo implementado de la interfaz "IFuncionesUsuariosExternos" que permite a un UsuarioExterno viusalizar la lista de resultados producto de la "Ronda de Encuentros Laborales"<br>
	 * <b>Pre:</b> El UsuarioExterno que se pasa por parámetro debe ser un Empleador <br>
	 * <b>Post:</b>	Visualizacion de la lista de empleados con los respectivos puntajes <br>
	 * 
	 * @param u Empleador que visulaiza su lista de resultados. <br>
	 */	
	@Override	
	public void visualizacionResultadoRondaEncuentros(UsuarioExterno u) throws ArrayVacioException, FechaExpiradaException {

		Empleador  empleador= (Empleador) u; 
		//getListadoResultados().getFecha()
		//empleador.getTicketEmpleador().getFechaAlta()
		if(empleador.getListadoResultados().getFecha().compareTo(sistema.getFechaRondaencuentros())>=0) {
			if(empleador.getListadoResultados().getArrayResultadosRondaEncuentros().size()>0)
				for(int i=0; i<empleador.getListadoResultados().getArrayResultadosRondaEncuentros().size(); i++) {			
					EmpleadoPretenso empleado = (EmpleadoPretenso) empleador.getListadoResultados().getArrayResultadosRondaEncuentros().get(i).getUsuario();
					if(empleado.getTicketEmpleadoP().getEstado() == EstadosTickets.activo)
						System.out.println(i+") "+ empleado.getNombre() + "  " + empleador.getListadoResultados().getArrayResultadosRondaEncuentros().get(i).getPuntuacion());
				}
		}
		else
			throw new FechaExpiradaException("El usuario ingreso al sistema luego de generada la ronda de encuentros laborales");
	}
	
	
	public ArrayList<EmpleadoPretenso> getResultadoRondaEncuentros(UsuarioExterno u) throws ArrayVacioException, FechaExpiradaException {

		Empleador  empleador= (Empleador) u; 
		ArrayList<EmpleadoPretenso> resultadoRondaEncuentros = new ArrayList<EmpleadoPretenso>();
		
		
		if(empleador.getListadoResultados().getFecha().compareTo(sistema.getFechaRondaencuentros())>=0) {
			if(empleador.getListadoResultados().getArrayResultadosRondaEncuentros().size()>=0) {
				for(int i=0; i<empleador.getListadoResultados().getArrayResultadosRondaEncuentros().size(); i++) {			
					EmpleadoPretenso empleado = (EmpleadoPretenso) empleador.getListadoResultados().getArrayResultadosRondaEncuentros().get(i).getUsuario();
					if(empleado.getTicketEmpleadoP().getEstado().equalsIgnoreCase(EstadosTickets.activo))
						resultadoRondaEncuentros.add(empleado);
				}
				return resultadoRondaEncuentros;
			}
			else
				throw new ArrayVacioException("No se encontraron coincidencias de su ticket con el de algun empleador");
		}
		else
			throw new FechaExpiradaException("El usuario ingreso al sistema luego de generada la ronda de encuentros laborales");
	}

	/**
	 * El Empleador que ingresa por parametros elije de su Lista de Resultados a los Empleados que sean de su interes <br>
	 * <b>Pre:  </b> El empleado pasado por parametro no debe ser nulo<br>
	 * <b>Post: </b> Se generará una lista con los empleados elegidos por el empleador<br>
	 * @param empleador Eligirá los empleados que sean de su preferencia para ver si los puede contratar <br>
	 * @throws ArrayVacioException Propaga la excepcion proveniente de la visualizacion en caso de que el listado de resultados este vacio<br>
	 * @throws FechaExpiradaException Propaga la excepcion en caso de que la fecha de la lista de visualizacion sea anterior a la fecha de Ronda de Encuentros Laborales. En dicho caso no se podra participar de la Ronda de elecciones <br>
	 * @throws EstadoTicketException Se lanza esta excepcion en caso de que el ticket no haya sido generado o que haya sido cancelado, o en el caso de que el ticket este suspendido <br>
	 */
	public void RondaEleccionEmpleadosPretensos(Empleador empleador, List<EmpleadoPretenso> list) throws ArrayVacioException, FechaExpiradaException, EstadoTicketException 
	{
		
		if(empleador.getTicketEmpleador() != null)
			if(empleador.getTicketEmpleador().getEstado() == EstadosTickets.activo) {
				for(int i=0; i<list.size();i++) {
					int j=0;
					System.out.println("Eleccion:"+list.get(i));
					empleador.getElecciones().add(list.get(i));
					while(j<empleador.getListadoResultados().getArrayResultadosRondaEncuentros().size() && empleador.getListadoResultados().getArrayResultadosRondaEncuentros().get(j).getUsuario() != list.get(i))
						j++;
					if(j<empleador.getListadoResultados().getArrayResultadosRondaEncuentros().size())
						empleador.getListadoResultados().getArrayResultadosRondaEncuentros().remove(j);
						
				}
				//PersistenciaEscritura.EscrituraArchivo();

			}
			else
				throw new  EstadoTicketException("El ticket no se encuentra activo");
		else
			throw new EstadoTicketException("El ticket no fue creado o se encuentra suspendido");
	}	

	/**
	 * Metodo implementado de la interfaz IFuncionesUsuariosExternos, el cual permite modificar el estado del ticket <br>
	 * <b>Pre: </b> El usuario que viene por parametro debe ser un Empleador <br>
	 * <b>Post: </b> Generacion del cambio de estado del ticket <br>
	 * 
	 * @param u Empleador que quiere cambiar el estado de su ticket
	 * @param estado Estado al cual se va a cambiar el ticket
	 * @throws EstadoTicketException 
	 * 
	 */

	@Override
	public void setEstadoTicket(UsuarioExterno u,String estado) throws EstadoTicketException {

		Empleador empleador = (Empleador) u;
		if (empleador.getTicketEmpleador() != null) {		
			if(estado == EstadosTickets.activo || estado == EstadosTickets.suspendido)
				empleador.getTicketEmpleador().setEstado(estado);
			else if(estado == EstadosTickets.cancelado) {
				sistema.getTicketEmpleadores().remove(empleador.getTicketEmpleador());
				empleador.setTicketEmpleador(null);
			}
		}
		else
			throw new EstadoTicketException("No existe un ticket al cual cambiarle el estado");
	} 


	/**
	 * Metodo que genera el ticket de un empleador <br>
	 * 
	 * <b>Post: </b> Generacion del ticket para un empleador
	 * 
	 * @param empleador Empleado que genera el ticket<br>
	 * @param solicitados Cantidad de empleados que querra contratar el empleador
	 *  @param locacion Valor entero mayor a cero, que representa el tipo de locacion<br>
	 * 		<ul>
	 * 			<li>0  = locacionHomeOffice()</li>
	 * 			<li>1  = locacionPresencial()</li>
	 * 			<li>2  = locacionIndistinto()</li>	
	 * 		</ul>
	 * @param remuneracion Valor entero mayor a cero, que representa la remuneracion<br>
	 *		<ul>
	 * 			<li>0 = $40000</li>
	 * 			<li>1= $80000</li>
	 * 			<li>2= $120000</li>	
	 * 		</ul>
	 * @param cargaHoraria Valor entero mayor a cero, que representa la de carga horaria<br>
	 * 		<ul>
	 * 			<li>El UsuarioExterno que se pasa por parámetro debe ser distinto de null</li>
	 * 			<li>El UsuarioExterno que se pasa por parámetro debe ser un EmpleadoPretenso </li>
	 * 			<li>El UsuarioExterno que se pasa por parámetro debe ser distinto de null</li>
	 * 		</ul>
	 * @param tipoPuesto Valor entero mayor a cero, que representa el tipo de puesto<br>
	 * 		<ul>
	 * 			<li>0 = "junior"</li>
	 * 			<li>1= "senior"</li>
	 * 			<li>2= "managment"</li>
	 * 		</ul>
	 * @param rangoEtario Valor entero mayor a cero, que representa el tipo de rango etario<br>
	 * 		<ul>
	 * 			<li>0 = mayor a 18 </li>
	 * 			<li>1 = mayor a 35 </li>
	 * 			<li>2 = mayor a 50 </li>
	 * 		</ul>
	 * @param experienciaPrevia Valor entero mayor a cero, que representa la experiencia previa<br>
	 * 		<ul>
	 * 			<li>0 = "nada"</li>
	 * 			<li>1 = "media" </li>
	 * 			<li>2 = "mucha"</li>
	 * 		</ul>
	 * @param estudios Valor entero mayor a cero, que representa los estudios previos<br>
	 * 		<ul>
	 * 			<li>0 = "primario"</li>
	 * 			<li>1 = "secundario"</li>
	 * 			<li>2 = "terciario"</li>
	 * 		</ul>
	 * @throws ObjetoNoEstaEnLaListaException Lanza el error si el empleador no se encuetra registrado en el sistema<br>
	 * @throws ParametroFormularioFactoryException  Propaga la excepcion en caso de que se haya ingresado un tipo incorrecto en la creacion del formulario de busqueda<br>
	 * @throws EstadoTicketException 
	 */
	public void generarTicket(Empleador empleador,int solicitados ,int locacion, int remuneracion, int cargaHoraria, int tipoPuesto, int rangoEtario, int experienciaPrevia, int estudios) throws ObjetoNoEstaEnLaListaException,ParametroFormularioFactoryException, ParametroInvalidoException, EstadoTicketException{

		if(empleador.getTicketEmpleador()==null)
			if (solicitados > 0) {
				int index = sistema.getEmpleadores().indexOf(empleador);
	
				if (index>-1) {
					GeneradorFormulario form = new GeneradorFormulario();
					TicketEmpleador ticket = new TicketEmpleador(LocalDateTime.now(),solicitados,form.getFormulario(locacion, remuneracion, cargaHoraria, tipoPuesto, rangoEtario, experienciaPrevia, estudios));
					empleador.setTicketEmpleador(ticket);
					sistema.registrarTicketEmpleadores(ticket);
				}
				else
					throw new ObjetoNoEstaEnLaListaException("El empleado " + empleador.getNombreUsuario() + "no se encuentra registrado");
			}
			else
				throw new ParametroInvalidoException("Debe solicitar contratar por lo menos a un empleado");
		else
			throw new EstadoTicketException("Ya posee un ticket activo. Debe cancelarlo para generar otro");

	}

	public ArrayList<ResultadosContrataciones> visualizacionResultadosContrataciones() {
		return sistema.getHistoricoResultados();
	}

}