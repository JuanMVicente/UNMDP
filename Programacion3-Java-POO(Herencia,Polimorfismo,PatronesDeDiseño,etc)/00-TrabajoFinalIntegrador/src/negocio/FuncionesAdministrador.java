package negocio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Observable;

import dato.AdministradorAgencia;
import dato.CargaHoraria;
import dato.EmpleadoPretenso;
import dato.Empleador;
import dato.EstadosTickets;
import dato.EstudiosCursados;
import dato.ExperienciaPrevia;
import dato.FormularioBusqueda;
import dato.PuntajesEmpleado;
import dato.PuntajesEmpleador;
import dato.RangoEtario;
import dato.Remuneracion;
import dato.ResultadosContrataciones;
import dato.StructListadoResultado;
import dato.TicketEmpleado;
import dato.TicketEmpleador;
import dato.TipoPuesto;
import exceptions.ArrayVacioException;
import exceptions.FechaExpiradaException;
import persistencia.PersistenciaEscritura;

/**
 * @author Grupo 9<br>
 * Clase que representa el sistema con las funcionales del Administrador de la agencia.
 * 
 */
public class FuncionesAdministrador extends Observable{
	private Sistema sistema = Sistema.getInstance();

	/**
	 * Genera la puntuación correspondiente al enfrentamiento de un TicketEmpleador con un TicketEmpleado.<br>
	 * <b>Pre: </b>Se ingresan ticket distintos de "null".<br>
	 * <b>Post: </b>Retorna la puntuación correspondiente al enfrentamiento mencionado.
	 * @param TEmpleador Parámetro que representa el Ticket de un empleador específico que será enfrentado con el Ticket de un
	 * empleado para calcular el puntaje correspondiente.<br>
	 * @param TEmpleado Parámetro que representa el Ticket de un empleado específico que será enfrentado con el Ticket de un
	 * empleador para calcular el puntaje correspondiente.<br>
	 * @return puntuación correspondiente al enfrentamiento de un TicketEmpleador con un TicketEmpleado.
	 */
	private double generaPuntuacion(TicketEmpleador TEmpleador ,TicketEmpleado TEmpleado) {
		FormularioBusqueda formularioEmpleador = TEmpleador.getFormularioBusqueda();
		FormularioBusqueda formularioEmpleadoP = TEmpleado.getFormularioBusqueda();

		double puntuacion = 0;

		puntuacion += formularioEmpleador.getLocacion().versus(formularioEmpleadoP.getLocacion());
		puntuacion += Remuneracion.enfrentar(formularioEmpleador.getRemuneracion(), formularioEmpleadoP.getRemuneracion());
		puntuacion += CargaHoraria.enfrentar(formularioEmpleador.getCargaHoraria(), formularioEmpleadoP.getCargaHoraria());
		puntuacion += TipoPuesto.enfrentar(formularioEmpleador.getTipoPuesto(), formularioEmpleadoP.getTipoPuesto());
		puntuacion += RangoEtario.enfrentar(formularioEmpleador.getRangoEtario(), formularioEmpleadoP.getRangoEtario());
		puntuacion += ExperienciaPrevia.enfrentar(formularioEmpleador.getExperienciaPrevia(), formularioEmpleadoP.getExperienciaPrevia());
		puntuacion += EstudiosCursados.enfrentar(formularioEmpleador.getEstudios(), formularioEmpleadoP.getEstudios());

		return puntuacion;

	}


	/**
	 * Método que genera las listas con los resultados para todos los empleados pretensos y empleadores con ticket activo. También,
	 * realiza las modificaciones correspondientes a los puntajes de los usuarios cuando aplica.<br>
	 * <b>Pre: </b>Este método será efectivo en caso de que haya usuarios empleados y empleadores que tengan tickets activos.<br>
	 * <b>Post: </b>Genera para cada empleado las listas ordenadas por puntaje (de mayor a menor) de los empleadores potenciales.<br>
	 * Genera para cada empleador las listas ordenadas por puntaje (de mayor a menor) de los empleados pretensos.
	 */
	public void RondaEncuentrosLaborales() {
		int i=0;
		int j;
		
		System.out.println("RONDA ENC");
		////
		sistema.setFechaRondaencuentros(LocalDateTime.now());//

		StructListadoResultado resultadoEmpleador;
		StructListadoResultado resultadoEmpleado;
		ArrayList<StructListadoResultado> arrayResultadosEmpleador = null ;

		//Se limpia el array de la lista de resultados de los empleados
		for(j=0; j<sistema.getEmpleados().size();j++)
			sistema.getEmpleados().get(j).getListadoResultados().getArrayResultadosRondaEncuentros().clear();

		for (;i<sistema.getEmpleadores().size();i++) 
		{
			Empleador empleador = sistema.getEmpleadores().get(i);

			if(empleador.getTicketEmpleador() != null && empleador.getTicketEmpleador().getEstado() == EstadosTickets.activo ) {
				arrayResultadosEmpleador = new ArrayList<StructListadoResultado>();

				for(j=0; j<sistema.getEmpleados().size();j++) { 

					EmpleadoPretenso empleado = sistema.getEmpleados().get(j);


					if(empleado.getTicketEmpleadoP()!=null && empleado.getTicketEmpleadoP().getEstado() == EstadosTickets.activo) {

						//GENERA STRUCT DE RESULTADOS DEL EMPLEADOR
						//------------------------
						resultadoEmpleador = new StructListadoResultado();
						resultadoEmpleador.setPuntuacion(this.generaPuntuacion(empleador.getTicketEmpleador(), empleado.getTicketEmpleadoP()));
						resultadoEmpleador.setUsuario(empleado);
						arrayResultadosEmpleador.add(resultadoEmpleador);

						// GENERA STRUCT DE RESULTADOS DEL EMPLEADO
						//-------------------------		
						resultadoEmpleado = new StructListadoResultado();
						resultadoEmpleado.setPuntuacion(resultadoEmpleador.getPuntuacion());
						resultadoEmpleado.setUsuario(empleador);
						empleado.getListadoResultados().getArrayResultadosRondaEncuentros().add(resultadoEmpleado);
					}
				}
				empleador.getListadoResultados().setArrayResultadosRondaEncuentros(arrayResultadosEmpleador); //lista terminada para empleador

				//PUNTAJES EMPLEADO
				if(arrayResultadosEmpleador.size()>0) {
					EmpleadoPretenso empleado;
					empleado = (EmpleadoPretenso) empleador.getListadoResultados().getArrayResultadosRondaEncuentros().get(arrayResultadosEmpleador.size()-1).getUsuario(); //ultimo
					empleado.setPuntajefijo(empleado.getPuntajefijo() + PuntajesEmpleado.serUltimo); //se le resta 5 al ultimo

					empleado = (EmpleadoPretenso) empleador.getListadoResultados().getArrayResultadosRondaEncuentros().get(0).getUsuario(); //primero
					empleado.setPuntajefijo(empleado.getPuntajefijo() + PuntajesEmpleado.serPrimero);
				}
			}

		}

		for(int a=0 ; a<sistema.getEmpleados().size() ; a++) {
			EmpleadoPretenso empleado =  sistema.getEmpleados().get(a);


			if(empleado.getTicketEmpleadoP() != null && empleado.getTicketEmpleadoP().getEstado() == EstadosTickets.activo  && empleado.getListadoResultados().getArrayResultadosRondaEncuentros().size()>0) { 

				empleado.getListadoResultados().setArrayResultadosRondaEncuentros(empleado.getListadoResultados().getArrayResultadosRondaEncuentros());

				//PUNTAJES EMPLEADOR
				Empleador empleador = (Empleador) empleado.getListadoResultados().getArrayResultadosRondaEncuentros().get(0).getUsuario();//primero
				empleador.setPuntajefijo(empleador.getPuntajefijo() + PuntajesEmpleador.serPrimero); //suma 10 por estar primero en la lista
				int ultimo = empleado.getListadoResultados().getArrayResultadosRondaEncuentros().size()-1;
				empleador = (Empleador) empleado.getListadoResultados().getArrayResultadosRondaEncuentros().get(ultimo).getUsuario();//ultimo
				empleador.setPuntajefijo(empleador.getPuntajefijo() + PuntajesEmpleador.serUltimo); /// al que este ultimo le resto 20
			}
		}
		//PersistenciaEscritura.EscrituraArchivo();
		setChanged();
		this.notifyObservers();
	}

	/**
	 * Permite la visualizar todos los empleadores registrados en el sistema.<br>
	 * <b>Pre: </b>Debe tener empleadores registrados para su correcta ejecución, de lo contrario el sistema no muestra ningún dato..<br>
	 * <b>Post: </b>Se pueden visualizar todos los empleadores cargados dentro del sistema.
	 */
	public void visualizarEmpleadores() {
		for(int i=0; i<sistema.getEmpleadores().size();i++) {
			System.out.println(sistema.getEmpleadores().get(i).getNombreUsuario());
		}		
	}

	/**
	 * Permite la visualizar todos los empleadoros registrados en el sistema.<br>
	 * <b>Pre: </b>Debe tener empleadoros registrados para su correcta ejecución, de lo contrario el sistema no muestra ningún dato..<br>
	 * <b>Post: </b>Se pueden visualizar todos los empleados cargados dentro del sistema.
	 */
	public void visualizarEmpleados() {
		for(int i=0; i<sistema.getEmpleados().size();i++) {
			System.out.println(sistema.getEmpleados().get(i).getNombre());
		}
	}

	/**
	 * Permite visualizar los tickets cargados por cada uno de los empleadosPretensos.<br>
	 * <b>Pre: </b>Debe tener tickets registrados para su correcta ejecución, de lo contrario el sistema no muestra ningún dato.<br>
	 * <b>Post: </b>Se pueden visualizar tickets cargados por los empleados pretensos, el sistema solo permite uno por usuario.
	 */
	public void visualizarTicketsEmpleados() {
		for(int i=0; i<sistema.getEmpleados().size();i++) {
			if(sistema.getEmpleados().get(i).getTicketEmpleadoP()!=null) {
				System.out.println("Nombre Empleador:" + sistema.getEmpleados().get(i).getNombre());
				System.out.println("Fecha:" + sistema.getEmpleados().get(i).getTicketEmpleadoP().getFechaAlta());
				System.out.println("Estado: "+ sistema.getEmpleados().get(i).getTicketEmpleadoP().getEstado());
				System.out.println(sistema.getEmpleados().get(i).getTicketEmpleadoP().getFormularioBusqueda().toString());
			}
		}
	}

	/**
	 * Permite visualizar los tickets cargados por cada uno de los empleadores potenciales.<br>
	 * <b>Pre: </b>Debe tener tickets registrados para su correcta ejecución, de lo contrario el sistema no muestra ningún dato.<br>
	 * <b>Post: </b>Se pueden visualizar tickets cargados por los empleadores potenciales, el sistema solo permite uno por usuario.
	 */
	public void visualizarTicketsEmpleadores() {
		for(int i=0; i<sistema.getEmpleadores().size();i++) {
			if(sistema.getEmpleadores().get(i).getTicketEmpleador()!=null) {
				System.out.println("Nombre Empleador:" + sistema.getEmpleadores().get(i).getNombreUsuario());
				System.out.println("Fecha:" + sistema.getEmpleadores().get(i).getTicketEmpleador().getFechaAlta());
				System.out.println("Estado: "+ sistema.getEmpleadores().get(i).getTicketEmpleador().getEstado());
				System.out.println("Cantidad Solicitada: " + sistema.getEmpleadores().get(i).getTicketEmpleador().getCantidadEmpleadosSolicitados());
				System.out.println(sistema.getEmpleadores().get(i).getTicketEmpleador().getFormularioBusqueda().toString());
			}
		}
	}


	// compara formularios de Empleados Pretensos con los formularios de los Empleadores y despuï¿½s los ticket de los 
	// Empleadores con los ticket de los empleados pretensos
	// la salida es para cada usuario que tenga un ticket activo va a generar un listado de opuestos con puntaje 
	// de la comparaciï¿½n



	/**
	 * Genera las comparaciones entre las elecciones de los usuarios y genera la contratación, calcula las comisiones a pagar
	 * por cada una de las partes y modifica el puntaje de los usuarios cuando corresponde.<br>
	 * <b>Pre: </b>Debe tener tickets registrados para su correcta ejecución, de lo contrario el sistema no muestra ningún dato.<br>
	 * <b>Post: </b>Se genera un arreglo con las contrataciones realizadas, junto a las comisiones a pagar
	 * por cada una de las partes y se modifica el puntaje de los usuarios cuando corresponde.<br>
	 * @throws ArrayVacioException propaga la excepción cuando se encuentra vacío el listado.<br>
	 * @throws FechaExpiradaException propaga la excepción cuando la fecha de del usuario comparado no coincide con la fecha de 
	 * la ultima ronde de contrataciones, ya que el usuario no participó en la última ronda de encuentros.
	 */
	public void RondaDeContratacion() {
		
		
		System.out.println("RONDA CONT");
          //// 
		ArrayList<Empleador> empleadores = sistema.getEmpleadores();

		for(int i=0; i<empleadores.size(); i++) {

			int j=0;  ///esto es lo que yo decia del criterio para la contratacion

			Empleador empleador = empleadores.get(i); //empleador que estoy tratando

			if(empleador.getListadoResultados().getFecha().compareTo(sistema.getFechaRondaencuentros())>=0 && (empleador.getElecciones().size()>0) ){	

				while(j<empleador.getElecciones().size() && empleador.getTicketEmpleador().getEstado() == EstadosTickets.activo) { //while que recorre eleccion empleados
					EmpleadoPretenso empleado = (EmpleadoPretenso) empleador.getElecciones().get(j);

					if(empleado.getTicketEmpleadoP().getEstado() == EstadosTickets.activo) {

						if(empleado.getElecciones().contains(empleador)){
							empleador.getTicketEmpleador().incrCantidadEmpleadosObtenidos();
							AdministradorAgencia.comisionesCobradas += empleador.comisionesEmpleador();								
							ResultadosContrataciones resultados = new ResultadosContrataciones(empleador, empleado, empleador.comisionesEmpleador(), empleado.comisionesEmpleado(), LocalDate.now());
							sistema.addResultadoContratacion(resultados);

							if(empleador.getTicketEmpleador().getCantidadEmpleadosObtenidos() == empleador.getTicketEmpleador().getCantidadEmpleadosSolicitados()) {
								empleador.getTicketEmpleador().setEstado(EstadosTickets.finalizado);
								empleador.setPuntajefijo(empleador.getPuntajefijo() + PuntajesEmpleador.finalizado);
							}

							AdministradorAgencia.comisionesCobradas += empleado.comisionesEmpleado();
							empleado.getTicketEmpleadoP().setEstado(EstadosTickets.finalizado);
							empleado.setPuntajefijo(empleado.getPuntajefijo() + PuntajesEmpleado.finalizado);

							empleador.getElecciones().remove(empleado);
							empleado.getElecciones().clear();
						}
						else
							j++;
					}
					else
						j++;
				}
			}	
		}
		//PersistenciaEscritura.EscrituraArchivo();
	}

	/**
	 * Método que retona el histórico de contrataciones realizadas gracias al sistema.<br>
	 * <b>Pre: </b>Debe tener resultados registrados para su correcta ejecución, de lo contrario el sistema no muestra ningún dato.<br>
	 * <b>Post: </b>Array List con los resultados generados en la Ronda de Contrataciones.<br>
	 * @return histórico de contrataciones.
	 */
	public ArrayList<ResultadosContrataciones> visualizacionResultadosContrataciones() {
		return sistema.getHistoricoResultados();
	}

}
