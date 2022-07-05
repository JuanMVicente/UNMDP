package negocio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dato.EmpleadoPretenso;
import dato.Empleador;
import dato.EstadosTickets;
import dato.GeneradorFormulario;
import dato.PuntajesEmpleado;
import dato.ResultadosContrataciones;
import dato.TicketEmpleado;
import dato.UsuarioExterno;
import exceptions.ArrayVacioException;
import exceptions.EstadoTicketException;
import exceptions.FechaExpiradaException;
import exceptions.ObjetoNoEstaEnLaListaException;
import exceptions.ParametroFormularioFactoryException;

/**
 * @author Grupo9 <br>
 * Clase sistema de las funcionalidades a las que pueden acceder los usuarios de tip <br>
 */
public class FuncionesEmpleadoPretenso implements IFuncionesUsuariosExternos{

	private Sistema sistema = Sistema.getInstance();


	/**
	 ** Metodo implementado de la interfaz "IFuncionesUsuariosExternos" que permite a un UsuarioExterno viusalizar la lista de resultados producto de la "Ronda de Encuentros Laborales"<br>
	 * <b>Pre:</b> 
	 * 		<ul>
	 * 			<li>El UsuarioExterno que se pasa por parámetro debe ser un EmpleadoPretenso </li>
	 * 			<li>El UsuarioExterno que se pasa por parámetro debe ser distinto de null</li>
	 * 		</ul>
	 * <b>Post:</b>	Visualizacion de la lista de empleadores con los respectivos puntajes <br>
	 * 
	 * @param u EmpleadoPretenso que visulaiza su lista de resultados. <br>
	 * @throws ArrayVacioException Lanza la excepcion en caso de que la lista de resultados esté vacia
	 * @throws FechaExpiradaException Lanza la excepcion en caso que la fecha de la lista de resultados sea anterior a la fecha de la "Ronda de Encuentros"
	 */
	@Override	
	public void visualizacionResultadoRondaEncuentros(UsuarioExterno u) throws ArrayVacioException, FechaExpiradaException 
	{

		//EmpleadoPretenso p = (EmpleadoPretenso) empleado.getListadoResultados().get(1).getLista().get(1).getUsuario();
		EmpleadoPretenso  empleado= (EmpleadoPretenso) u; 

		if(empleado.getListadoResultados().getFecha().compareTo(sistema.getFechaRondaencuentros())>=0) {
			if(empleado.getListadoResultados().getArrayResultadosRondaEncuentros().size()>0)
				for(int i=0; i<empleado.getListadoResultados().getArrayResultadosRondaEncuentros().size(); i++) {			
					Empleador empleador = (Empleador) empleado.getListadoResultados().getArrayResultadosRondaEncuentros().get(i).getUsuario();
					if(empleador.getTicketEmpleador().getEstado() == EstadosTickets.activo)
						System.out.println(i+") "+ empleador.getNombre() + "  " + empleado.getListadoResultados().getArrayResultadosRondaEncuentros().get(i).getPuntuacion());
				}
		}
		else
			throw new FechaExpiradaException("El usuario ingreso al sistema luego de generada la ronda de encuentros laborales");
	}

	public ArrayList<Empleador> getResultadoRondaEncuentros(UsuarioExterno u) throws ArrayVacioException, FechaExpiradaException {

		EmpleadoPretenso  empleado= (EmpleadoPretenso) u; 
		ArrayList<Empleador> resultadoRondaEncuentros = new ArrayList<Empleador>();

		//empleado.getListadoResultados().getFecha()
		
		if(empleado.getListadoResultados().getFecha().compareTo(sistema.getFechaRondaencuentros())>=0) {
			if(empleado.getListadoResultados().getArrayResultadosRondaEncuentros().size()>=0) {
				for(int i=0; i<empleado.getListadoResultados().getArrayResultadosRondaEncuentros().size(); i++) {			
					Empleador empleador = (Empleador) empleado.getListadoResultados().getArrayResultadosRondaEncuentros().get(i).getUsuario();
					if(empleador.getTicketEmpleador().getEstado().equalsIgnoreCase(EstadosTickets.activo))
						resultadoRondaEncuentros.add(empleador);					
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
	 * El EmpleadoPretenso que ingresa por parametros elije de su Lista de Resultados a los Empleadores que sean de su interes <br>
	 * <b>Pre: El empleado pasado por parametro debe ser distinto de null</b>
	 * <b>Post: Se generará una lista con los empleadores elegidos por el empleado</b>
	 * @param empleado Eligirá los empleadores que sean de su preferencia para ver si puede conseguir el trabajo <br>
	 * @throws ArrayVacioException Propaga la excepcion proveniente de la visualizacion en caso de que el listado de resultados este vacio<br>
	 * @throws FechaExpiradaException Propaga la excepcion en caso de que la fecha de la lista de visualizacion sea anterior a la fecha de Ronda de Encuentros Laborales. En dicho caso no se podra participar de la Ronda de elecciones <br>
	 * @throws EstadoTicketException Se lanza esta excepcion en caso de que el ticket no haya sido generado o que haya sido cancelado, o en el caso de que el ticket este suspendido <br>
	 */

	/*public void RondaEleccionEmpleador(EmpleadoPretenso empleado)
			throws ArrayVacioException, FechaExpiradaException, EstadoTicketException {

		if (empleado.getTicketEmpleadoP() != null)
			if (empleado.getTicketEmpleadoP().getEstado() == EstadosTickets.activo) {
				this.visualizacionResultadoRondaEncuentros(empleado);
				int eleccion;
				do {
					System.out.println("ingrese el numero de empleado que desea elegir, ingrese -1 para finalizar");
					Scanner scanner = new Scanner(System.in);
					eleccion = scanner.nextInt();
				} while (eleccion < -1	|| eleccion >= empleado.getListadoResultados().getArrayResultadosRondaEncuentros().size());

				while (empleado.getListadoResultados().getArrayResultadosRondaEncuentros().size() > 0	&& eleccion != -1) {
					empleado.getElecciones().add(empleado.getListadoResultados().getArrayResultadosRondaEncuentros().get(eleccion).getUsuario());
					empleado.getListadoResultados().getArrayResultadosRondaEncuentros().remove(eleccion);
					if (empleado.getListadoResultados().getArrayResultadosRondaEncuentros().size() > 0) {
						this.visualizacionResultadoRondaEncuentros(empleado);
						do {
							System.out.println("ingrese el numero de empleado que desea elegir, ingrese -1 para finalizar");
							Scanner scanner = new Scanner(System.in);
							eleccion = scanner.nextInt();
						} while (eleccion < -1 || eleccion >= empleado.getListadoResultados().getArrayResultadosRondaEncuentros().size());

					}

				}	
			} 
			else
				throw new EstadoTicketException("El ticket no se encuentra activo");
		else
			throw new EstadoTicketException("El ticket no fue creado o se encuentra suspendido");
	}	
	
	*/
	
	
	public void RondaEleccionEmpleadores(EmpleadoPretenso empleado, List<Empleador> list) throws ArrayVacioException, FechaExpiradaException, EstadoTicketException 
	{

		
		if(empleado.getTicketEmpleadoP() != null)
			if(empleado.getTicketEmpleadoP().getEstado() == EstadosTickets.activo) {
				for(int i=0; i<list.size();i++) {
					int j=0;
					empleado.getElecciones().add(list.get(i));
					while(j<empleado.getListadoResultados().getArrayResultadosRondaEncuentros().size() && empleado.getListadoResultados().getArrayResultadosRondaEncuentros().get(j).getUsuario() != list.get(i))
						j++;
					if(j<empleado.getListadoResultados().getArrayResultadosRondaEncuentros().size())
						empleado.getListadoResultados().getArrayResultadosRondaEncuentros().remove(j);
				}
				//PersistenciaEscritura.EscrituraArchivo();
			}
			else
				throw new  EstadoTicketException("El ticket no se encuentra activo");
		else
			throw new EstadoTicketException("El ticket no fue creado o se encuentra suspendido");
	}	


	/**
	 * Metodo que genera el ticket de un empleado <br>
	 * 
	 * <b>Post: </b> Generacion del ticket para un empleado pretenso
	 * 
	 * @param empleado Empleado que genera el ticket<br>
	 * @param locacion Valor entero mayor a cero, que representa el tipo de locacion<br>
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
	 * 			<li>0 = "media"     </li>
	 * 			<li>1 = "completo"  </li>
	 * 			<li>2 = "extendido" </li>
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
	 * 	
	 * @throws ObjetoNoEstaEnLaListaException Lanza el error si el empleado no se encuetra registrado en el sistema<br>
	 * @throws ParametroFormularioFactoryException Propaga la excepcion en caso de que se haya ingresado un tipo incorrecto en la creacion del formulario de busqueda<br>
	 * @throws EstadoTicketException 
	 */
	public void generarTicket(EmpleadoPretenso empleado, int locacion, int remuneracion, int cargaHoraria, int tipoPuesto, 
			int rangoEtario, int experienciaPrevia, int estudios) throws ObjetoNoEstaEnLaListaException, ParametroFormularioFactoryException, EstadoTicketException
	{
		if(empleado.getTicketEmpleadoP()==null) {
			int index = sistema.getEmpleados().indexOf(empleado);
			if (index>-1) {
				GeneradorFormulario form = new GeneradorFormulario();
				TicketEmpleado ticket = new TicketEmpleado(LocalDateTime.now(),form.getFormulario(locacion, remuneracion, cargaHoraria, tipoPuesto, rangoEtario, experienciaPrevia, estudios));
				empleado.setTicketEmpleadoP(ticket);
				sistema.registrarTicketsEmpleados(ticket);
			}
			else
				throw new ObjetoNoEstaEnLaListaException("El empleado " + empleado.getNombreUsuario() + "no se encuentra registrado");
		}
		else
			throw new EstadoTicketException("Ya posee un ticket activo. Debe cancelarlo para generar otro");
	}


	/**
	 * Metodo implementado de la interfaz "IFuncionesUsuariosExternos", el cual permite modificar el estado del ticket <br>
	 * <b>Pre: </b> 
	 * 		<ul>
	 * 			<li>El UsuarioExterno que se pasa por parámetro debe ser un EmpleadoPretenso </li>
	 * 			<li>El UsuarioExterno que se pasa por parámetro debe ser distinto de null</li>
	 * 		</ul> <br>
	 * <b>Post: </b> Generacion del cambio de estado del ticket <br>
	 * 
	 * @param u Empleado que quiere cambiar el estado de su ticket
	 * @param estado Estado al cual se va a cambiar el ticket
	 * @throws EstadoTicketException 
	 * 
	 */
	@Override
	public void setEstadoTicket(UsuarioExterno u,String estado) throws EstadoTicketException {

		EmpleadoPretenso empleadoP = (EmpleadoPretenso) u;
		if (empleadoP.getTicketEmpleadoP() != null) {		
			if(estado == EstadosTickets.activo || estado == EstadosTickets.suspendido) ///solo el sistema lo puede dar por finalizado
				empleadoP.getTicketEmpleadoP().setEstado(estado);
			else if(estado == EstadosTickets.cancelado) {
				sistema.getTicketsEmpleados().remove(empleadoP.getTicketEmpleadoP());
				empleadoP.setTicketEmpleadoP(null);
				empleadoP.setPuntajefijo(empleadoP.getPuntajefijo() + PuntajesEmpleado.cancelacion);
			}
		}
		else
			throw new EstadoTicketException("No existe un ticket al cual cambiarle el estado");
	} 

	public ArrayList<ResultadosContrataciones> visualizacionResultadosContrataciones() {
		return sistema.getHistoricoResultados();
	}

}
