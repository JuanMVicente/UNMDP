package persistencia;

import java.util.ArrayList;

import dato.AdministradorAgencia;
import dato.EmpleadoPretenso;
import dato.Empleador;
import dato.EmpleadorFisico;
import dato.EstadosTickets;
import dato.Lista;
import dato.ResultadosContrataciones;
import dato.StructListadoResultado;
import dato.TicketEmpleado;
import dato.TicketEmpleador;
import dato.UsuarioExterno;
import exceptions.ContraseniaIncorrectaException;
import exceptions.EstadoTicketException;
import exceptions.NombreUsuarioIncorrectoException;
import exceptions.ObjetoNoEstaEnLaListaException;
import exceptions.ParametroFormularioFactoryException;
import exceptions.ParametroInvalidoException;
import exceptions.UsuarioDuplicado;
import exceptions.UsuarioRepetidoException;
import negocio.FuncionesEmpleadoPretenso;
import negocio.FuncionesEmpleador;
import negocio.Sistema;



/**
 * @author equipo 9
 * Clase donde se realiza la copia de la instancia Sistema en las clases del DTO Serializables
 * y también se realiza la inversa
 */


public class UtilSistema {


	/**
	 * Método que copia la clase sistema en una clase DTO
	 * <b>Pre: </b>Intancia del Sistema que tiene el trabajo realizado y se necesita persistir.<br>
	 * <b>Post: </b>Instancia DTO con los datos almacenados en el Sistema.<br>
	 * @param sistema
	 * @return El sistema en una instancia DTO que permite la serialización
	 */
	public static SistemaDTO sistemaDTOFromSistema(Sistema sistema) {
		SistemaDTO respuesta = new SistemaDTO();

		ArrayList<EmpleadorDTO> empleadoresDTO = new ArrayList<EmpleadorDTO>();
		for(int i=0; i<sistema.getEmpleadores().size();i++) {
			empleadoresDTO.add(UtilSistema.EmpleadorDTOFromEmpleador(sistema.getEmpleadores().get(i)));
		}
		respuesta.setEmpleadores(empleadoresDTO);

		ArrayList<EmpleadoPretensoDTO> empleadosPretensosDTO = new ArrayList<EmpleadoPretensoDTO>();
		for(int i=0; i<sistema.getEmpleados().size();i++) {
			empleadosPretensosDTO.add(UtilSistema.EmpleadoPretensoDTOFromEmpleadoPretenso(sistema.getEmpleados().get(i)));
		}
		respuesta.setEmpleados(empleadosPretensosDTO);

		/*ArrayList<TicketEmpleadoDTO> ticketsEmpleadoDTO = new ArrayList<TicketEmpleadoDTO>();
		for(int i=0; i<sistema.getTicketsEmpleados().size();i++) {
			if(sistema.getTicketsEmpleados().get(i).getEstado().equals(EstadosTickets.finalizado) || sistema.getTicketsEmpleados().get(i).getEstado().equals(EstadosTickets.cancelado)){
				ticketsEmpleadoDTO.add(UtilSistema.TicketEmpleadoDTOFromTicketEmpleado(sistema.getTicketsEmpleados().get(i)));
			}
		}
		respuesta.setTicketEmpleados(ticketsEmpleadoDTO);

		ArrayList<TicketEmpleadorDTO> ticketsEmpleadorDTO = new ArrayList<TicketEmpleadorDTO>();
		for(int i=0; i<sistema.getTicketEmpleadores().size();i++) {
			if(sistema.getTicketEmpleadores().get(i).getEstado().equals(EstadosTickets.finalizado) || sistema.getTicketEmpleadores().get(i).getEstado().equals(EstadosTickets.cancelado)){
				ticketsEmpleadorDTO.add(UtilSistema.TicketEmpleadorDTOFromTicketEmpleador(sistema.getTicketEmpleadores().get(i)));
			}
		}
		respuesta.setTicketEmpleadores(ticketsEmpleadorDTO);*/

		respuesta.setAdministradorDeAgencia(UtilSistema.AdministradorDTOFromAdministrador(sistema.getAdministradorDeAgencia()));

		respuesta.setFechaRondaencuentros(sistema.getFechaRondaencuentros());

		ArrayList<ResultadosContratacionesDTO> historicoDTO = new ArrayList<ResultadosContratacionesDTO>();
		for(int i=0; i<sistema.getHistoricoResultados().size();i++) {
			historicoDTO.add(UtilSistema.ResultadosContratacionesDTOFromResultadosContrataciones(sistema.getHistoricoResultados().get(i)));
		}
		respuesta.setHistorialResultados(historicoDTO);
		
		respuesta.setBotonRondas(sistema.isBotonRondas());

		return respuesta;

	}

	/**
	 * Método que geneta una instancia DTO de un Empleador
	 * <b>Pre: </b>Intancia de empleador que tiene el trabajo realizado y se necesita persistir.<br>
	 * <b>Post: </b>Instancia DTO con los datos almacenados en el Sistema de un Empleador.<br>
	 * @param empleador
	 * @return El Empleador en una instancia DTO que permite la serialización
	 */
	private static EmpleadorDTO EmpleadorDTOFromEmpleador(Empleador empleador) {
		EmpleadorDTO respuesta = new EmpleadorDTO();
		if(empleador.getClass().getSimpleName().equalsIgnoreCase("EmpleadorFisico")) respuesta.setTipoEmpleador("FISICA");
		else if(empleador.getClass().getSimpleName().equalsIgnoreCase("EmpleadorJuridico")) respuesta.setTipoEmpleador("JURIDICA");
		respuesta.setNombreUsuario(empleador.getNombreUsuario());
		respuesta.setContrasenia(empleador.getContrasenia());
		respuesta.setNombre(empleador.getNombre());
		respuesta.setPuntajefijo(empleador.getPuntajefijo());
		respuesta.setRubro(empleador.getRubro());
		respuesta.setTicketEmpleador(UtilSistema.TicketEmpleadorDTOFromTicketEmpleador(empleador.getTicketEmpleador()));
		respuesta.setListadoResultados(UtilSistema.ListaDTOFromLista(empleador.getListadoResultados()));
		ArrayList<String> elecciones = new ArrayList<String>();
		for(int i=0; i<empleador.getElecciones().size();i++) {
			elecciones.add(empleador.getElecciones().get(i).getNombreUsuario());
		}
		respuesta.setElecciones(elecciones);
		return respuesta;
	}

	/**
	 * Método que devuelve una instancia DTO del ticket correspondiente a determinado Empleador.
	 * <b>Pre: </b>Intancia de ticket que tiene el sistema y se necesita persistir.<br>
	 * <b>Post: </b>Instancia DTO con los datos almacenados en el sistema de un ticket.<br>
	 * @param ticket de un determinado Empleador dentro del sistema.
	 * @return instancia DTO con los datos del ticket que se desean persistir
	 */
	private static TicketEmpleadorDTO TicketEmpleadorDTOFromTicketEmpleador(TicketEmpleador ticket) {
		TicketEmpleadorDTO respuesta = null;
		if(ticket != null) { // (ticket.getEstado().equals(EstadosTickets.activo) || ticket.getEstado().equals(EstadosTickets.suspendido)))
			respuesta = new TicketEmpleadorDTO();
			respuesta.setEstado(ticket.getEstado());
			respuesta.setFechaAlta(ticket.getFechaAlta());
			respuesta.setCantidadEmpleadosSolicitados(ticket.getCantidadEmpleadosSolicitados());
			respuesta.setCantidadEmpleadosObtenidos(ticket.getCantidadEmpleadosObtenidos());
			respuesta.setLocacionInt(ticket.getFormularioBusqueda().getLocacionInt());
			respuesta.setRangoEtario(ticket.getFormularioBusqueda().getRangoEtario());
			respuesta.setRemuneracion(ticket.getFormularioBusqueda().getRemuneracion());
			respuesta.setCargaHoraria(ticket.getFormularioBusqueda().getCargaHoraria());
			respuesta.setEstudios(ticket.getFormularioBusqueda().getEstudios());
			respuesta.setExperienciaPrevia(ticket.getFormularioBusqueda().getExperienciaPrevia());
			respuesta.setTipoPuesto(ticket.getFormularioBusqueda().getTipoPuesto());
		}
		return respuesta;
	}
	/**
	 * Método que devuelve una instancia DTO de la lista correspondiente a determinado Usuario Externo.
	 * <b>Pre: </b>Intancia de Lista que tiene el sistema y se necesita persistir.<br>
	 * <b>Post: </b>Instancia DTO con los datos almacenados en el sistema de una Lista.<br>
	 * @param Lista de un determinado Usuario Externo dentro del sistema.
	 * @return instancia DTO con los datos del la Lista que se desean persistir
	 */
	private static ListaDTO ListaDTOFromLista(Lista lista) {
		ListaDTO respuesta = null;
		if(lista!=null) {
			respuesta = new ListaDTO();
			respuesta.setFecha(lista.getFecha());
			ArrayList<ListadoResultadoDTO> resultados = new ArrayList<ListadoResultadoDTO>();
			for(int i=0; i<lista.getArrayResultadosRondaEncuentros().size();i++) {
				resultados.add(UtilSistema.ListadoResultadoDTOFromStructListadoResultado(lista.getArrayResultadosRondaEncuentros().get(i)));
			}
			respuesta.setArrayResultadosRondaEncuentros(resultados);
		}
		return respuesta;
	}
	/**
	 * Método que genera una instancia DTO de un Listado de Resultados
	 * <b>Pre: </b>Intancia de Listado de Resultados que tiene el trabajo realizado y se necesita persistir.<br>
	 * <b>Post: </b>Instancia DTO con los datos almacenados en el Sistema de un Listado de Resultados.<br>
	 * @param Listado de Resultados de un Usuario Externo
	 * @return El Listado de Resultados en una instancia DTO que permite la serialización
	 */
	private static ListadoResultadoDTO ListadoResultadoDTOFromStructListadoResultado(StructListadoResultado listadoResultado) {
		ListadoResultadoDTO respuesta = null;
		if(listadoResultado != null) {
			respuesta = new ListadoResultadoDTO();
			respuesta.setPuntuacion(listadoResultado.getPuntuacion());
			respuesta.setUsuario(listadoResultado.getUsuario().getNombreUsuario());
		}
		return respuesta;
	}
	/**
	 * Método que genera una instancia DTO de un Empleado Pretenso
	 * <b>Pre: </b>Intancia de empleado pretenso que tiene el trabajo realizado y se necesita persistir.<br>
	 * <b>Post: </b>Instancia DTO con los datos almacenados en el Sistema de un Empleado Pretenso.<br>
	 * @param empleador
	 * @return El Empleado Pretenso en una instancia DTO que permite la serialización
	 */
	private static EmpleadoPretensoDTO EmpleadoPretensoDTOFromEmpleadoPretenso(EmpleadoPretenso empleadoPretenso) {
		
		EmpleadoPretensoDTO respuesta = new EmpleadoPretensoDTO();
		respuesta.setNombreUsuario(empleadoPretenso.getNombreUsuario());
		respuesta.setContrasenia(empleadoPretenso.getContrasenia());
		respuesta.setNombre(empleadoPretenso.getNombre());
		respuesta.setPuntajefijo(empleadoPretenso.getPuntajefijo());
		respuesta.setDni(empleadoPretenso.getDni());
		respuesta.setFechaNacimiento(empleadoPretenso.getFechaNacimiento());
		respuesta.setTelefono(empleadoPretenso.getTelefono());
		respuesta.setTicketEmpleadoP(UtilSistema.TicketEmpleadoDTOFromTicketEmpleado(empleadoPretenso.getTicketEmpleadoP()));
		respuesta.setListadoResultados(UtilSistema.ListaDTOFromLista(empleadoPretenso.getListadoResultados()));
		ArrayList<String> elecciones = new ArrayList<String>();
		for(int i=0; i<empleadoPretenso.getElecciones().size();i++) {
			elecciones.add(empleadoPretenso.getElecciones().get(i).getNombreUsuario());
		}
		respuesta.setElecciones(elecciones);
		return respuesta;
		
	}

	/**
	 * Método que devuelve una instancia DTO del ticket correspondiente a determinado Empleado Pretenso.
	 * <b>Pre: </b>Intancia de ticket que tiene el sistema y se necesita persistir.<br>
	 * <b>Post: </b>Instancia DTO con los datos almacenados en el sistema de un ticket.<br>
	 * @param ticket de un determinado Empleado Pretenso dentro del sistema.
	 * @return instancia DTO con los datos del ticket que se desean persistir
	 */
	private static TicketEmpleadoDTO TicketEmpleadoDTOFromTicketEmpleado(TicketEmpleado ticket) {
		TicketEmpleadoDTO respuesta = null;
		if(ticket != null) {
			respuesta = new TicketEmpleadoDTO();
			respuesta.setEstado(ticket.getEstado());
			respuesta.setFechaAlta(ticket.getFechaAlta());
			respuesta.setResultado(ticket.getResultado());
			respuesta.setLocacionInt(ticket.getFormularioBusqueda().getLocacionInt());
			respuesta.setRangoEtario(ticket.getFormularioBusqueda().getRangoEtario());
			respuesta.setRemuneracion(ticket.getFormularioBusqueda().getRemuneracion());
			respuesta.setCargaHoraria(ticket.getFormularioBusqueda().getCargaHoraria());
			respuesta.setEstudios(ticket.getFormularioBusqueda().getEstudios());
			respuesta.setExperienciaPrevia(ticket.getFormularioBusqueda().getExperienciaPrevia());
			respuesta.setTipoPuesto(ticket.getFormularioBusqueda().getTipoPuesto());
		}
		return respuesta;
	}
	/**
	 * Método que genera una instancia DTO del Administrador de Agencia
	 * <b>Pre: </b>Intancia de Administrador de Agencia que tiene el trabajo realizado y se necesita persistir.<br>
	 * <b>Post: </b>Instancia DTO con los datos almacenados en el Sistema del Administrador de Agencia.<br>
	 * @param empleador
	 * @return El Empleado Pretenso en una instancia DTO que permite la serialización
	 */
	private static AdministradorAgenciaDTO AdministradorDTOFromAdministrador(AdministradorAgencia administradorDeAgencia) {
		AdministradorAgenciaDTO respuesta = null;
		if(administradorDeAgencia != null) {
			respuesta = new AdministradorAgenciaDTO();
			respuesta.setNombreUsuario(administradorDeAgencia.getNombreUsuario());
			respuesta.setNombre(administradorDeAgencia.getNombre());
			respuesta.setContrasenia(administradorDeAgencia.getNombre());
			respuesta.setComisionesCobradas(AdministradorAgencia.getComisionesCobradas());
		}
		return respuesta;
	}
	/**
	 * Método que devuelve una instancia DTO de un Resultado de Contrataciones
	 * <b>Pre: </b>Intancia de Resultado de Contrataciones que tiene el sistema y se necesita persistir.<br>
	 * <b>Post: </b>Instancia DTO con los datos almacenados en el sistema de un Resultado de Contrataciones.<br>
	 * @param Resultado de Contrataciones dentro del sistema.
	 * @return instancia DTO con los datos del Resultado de Contrataciones que se desea persistir
	 */
	private static ResultadosContratacionesDTO ResultadosContratacionesDTOFromResultadosContrataciones(ResultadosContrataciones historico) {
		ResultadosContratacionesDTO respuesta = new ResultadosContratacionesDTO();
		respuesta.setEmpleadorNombreUsuario(historico.getEmpleador().getNombreUsuario());
		respuesta.setEmpleadoNombreUsuario(historico.getEmpleado().getNombreUsuario());
		respuesta.setComisionEmpleador(historico.getComisionEmpleador());
		respuesta.setComisionEmpleado(historico.getComisionEmpleado());
		return null;
	}

	/**
	 * Método que copia la clase DTO en una clase Sistema para poder trabajar sobre los datos almacenados en el archivo
	 * <b>Pre: </b>Intancia DTO tiene el trabajo almacenado los datos.<br>
	 * <b>Post: </b>Instancia Sistema con los datos actualizados.<br>
	 * @param sistemaDTO
	 * @return El sistema en una instancia DTO que permite la serialización
	 * @throws EstadoTicketException 
	 */
	public static Sistema sistemaFromSistemaDTO(SistemaDTO sistemaDTO) throws EstadoTicketException {
		Sistema respuesta = Sistema.getInstance();
		//System.out.println(sistemaDTO.getEmpleados().size());
		//System.out.println(sistemaDTO.getEmpleadores().size());
		for(int i=0; i<sistemaDTO.getEmpleadores().size();i++) {
			UtilSistema.EmpleadorFromEmpleadorDTO(sistemaDTO.getEmpleadores().get(i));
		}

		for(int i=0; i<sistemaDTO.getEmpleados().size();i++) {
			UtilSistema.EmpleadoPretensoFromEmpleadoPretensoDTO(sistemaDTO.getEmpleados().get(i));
		}


		/*for(int i=0; i<sistemaDTO.getTicketEmpleados().size();i++) {
			if(sistemaDTO.getTicketEmpleadores().get(i).getEstado().equals(EstadosTickets.cancelado) || sistemaDTO.getTicketEmpleadores().get(i).getEstado().equals(EstadosTickets.finalizado)){
				UtilSistema.TicketEmpleadoFromTicketEmpleadoDTO(sistemaDTO.getTicketEmpleados().get(i));
			}
		}

		for(int i=0; i<sistemaDTO.getTicketEmpleadores().size();i++) {
			if(sistemaDTO.getTicketEmpleadores().get(i).getEstado().equals(EstadosTickets.cancelado) || sistemaDTO.getTicketEmpleadores().get(i).getEstado().equals(EstadosTickets.finalizado)){
				UtilSistema.TicketEmpleadorFromTicketEmpleadorDTO(sistemaDTO.getTicketEmpleadores().get(i));
			}
		}*/

		UtilSistema.ListaFromListaDTO(respuesta,sistemaDTO);

		UtilSistema.EleccionesFromEleccionesDTO(respuesta,sistemaDTO);

		respuesta.setFechaRondaencuentros(sistemaDTO.getFechaRondaencuentros());

		UtilSistema.HistoricoFromHistoricoDTO(respuesta,sistemaDTO);

		UtilSistema.AdministradorFromAdministradorDTO(respuesta,sistemaDTO);
		
		respuesta.setBotonRondas(sistemaDTO.isBotonRondas());
		
		return respuesta;


	}

	/**
	 * Método que genera una instancia Empleador en el Sistema desde una instancia DTO
	 * <b>Pre: </b>Intancia DTO con los datos del Empleador a incluir en el sistema.<br>
	 * <b>Post: </b>Instancia de Empleador construida para trabajar en el sistema.<br>
	 * @param empleador instancia de EmpleadorDTO
	 * @throws EstadoTicketException 
	 */
	private static void EmpleadorFromEmpleadorDTO(EmpleadorDTO empleador) throws EstadoTicketException {
		Sistema respuesta = Sistema.getInstance();
		try {
			respuesta.registrarEmpleador(empleador.getNombreUsuario(), empleador.getContrasenia(), empleador.getTipoEmpleador(), empleador.getNombre(), empleador.getRubro());
		} catch (ContraseniaIncorrectaException | NombreUsuarioIncorrectoException | UsuarioRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Empleador empleadorNuevo = respuesta.getEmpleadores().get(respuesta.getEmpleadores().size()-1);
		//System.out.println(respuesta.getEmpleadores().get(respuesta.getEmpleadores().size()-1).getNombreUsuario());
		FuncionesEmpleador empleadorFunc = new FuncionesEmpleador();
		TicketEmpleadorDTO ticket = empleador.getTicketEmpleador();		
		if(empleador.getTicketEmpleador()!=null) {
			try {
				empleadorFunc.generarTicket(empleadorNuevo, ticket.getCantidadEmpleadosSolicitados(), ticket.getLocacionInt(), ticket.getRemuneracion(), ticket.getCargaHoraria(), ticket.getTipoPuesto(), ticket.getRangoEtario(), ticket.getExperienciaPrevia(), ticket.getEstudios());
			} catch (ObjetoNoEstaEnLaListaException | ParametroInvalidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			empleadorNuevo.getTicketEmpleador().setFechaAlta(ticket.getFechaAlta());
			if(empleador.getTicketEmpleador().getEstado().equals(EstadosTickets.suspendido)) {
				empleadorFunc.setEstadoTicket(empleadorNuevo,EstadosTickets.suspendido);	
			}else if(empleador.getTicketEmpleador().getEstado().equals(EstadosTickets.finalizado))
				empleadorFunc.setEstadoTicket(empleadorNuevo,EstadosTickets.finalizado);

		}



	}
	/**
	 * Método que genera una instancia Empleado Pretenso en el Sistema desde una instancia DTO
	 * <b>Pre: </b>Intancia DTO con los datos del Empleado Pretenso a incluir en el sistema.<br>
	 * <b>Post: </b>Instancia de Empleado Pretenso construida para trabajar en el sistema.<br>
	 * @param empleado pretenso instancia de EmpleadorDTO
	 * @throws EstadoTicketException 
	 */
	private static void EmpleadoPretensoFromEmpleadoPretensoDTO(EmpleadoPretensoDTO empleado) throws EstadoTicketException {
		Sistema respuesta = Sistema.getInstance();
		try {
			respuesta.registrarEmpleadoPretenso(empleado.getNombreUsuario(), empleado.getContrasenia(), empleado.getNombre(), empleado.getTelefono(), "2000", empleado.getDni());
		} catch (ContraseniaIncorrectaException | NombreUsuarioIncorrectoException | UsuarioRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EmpleadoPretenso empleadoNuevo = respuesta.getEmpleados().get(respuesta.getEmpleados().size()-1);
		FuncionesEmpleadoPretenso empleadoFunc = new FuncionesEmpleadoPretenso();
		TicketEmpleadoDTO ticket = empleado.getTicketEmpleadoP();	
		if(empleado.getTicketEmpleadoP()!=null) {
			try {
				empleadoFunc.generarTicket(empleadoNuevo, ticket.getLocacionInt(), ticket.getRemuneracion(), ticket.getCargaHoraria(), ticket.getTipoPuesto(), ticket.getRangoEtario(), ticket.getExperienciaPrevia(), ticket.getEstudios());
			} catch (ParametroFormularioFactoryException | ObjetoNoEstaEnLaListaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			empleadoNuevo.getTicketEmpleadoP().setFechaAlta(empleado.getTicketEmpleadoP().getFechaAlta());
			if(empleado.getTicketEmpleadoP().getEstado().equals(EstadosTickets.suspendido)) {
				empleadoFunc.setEstadoTicket(empleadoNuevo, EstadosTickets.suspendido);
			} else if(empleado.getTicketEmpleadoP().getEstado().equals(EstadosTickets.finalizado)) {
				empleadoFunc.setEstadoTicket(empleadoNuevo, EstadosTickets.finalizado);
			}
		}
	}

	/**
	 * Método que devuelve al sistema los ticket persistidos correspondientes a determinado Empleado Pretenso.
	 * <b>Pre: </b>Intancia de DTO con los datos del ticket que se va a agregar al sistema.<br>
	 * <b>Post: </b>Instancia de Ticket incorporada al sistema.<br>
	 * @param datos DTO del ticket de un determinado Empleado Pretenso dentro del sistema.
	 * @throws EstadoTicketException 
	 */
	private static void TicketEmpleadoFromTicketEmpleadoDTO(TicketEmpleadoDTO ticket) throws EstadoTicketException {
		EmpleadoPretenso empleadoFicticio = new EmpleadoPretenso("xxx","xxx","xxx","xxx", "xxx", "xxx");
		FuncionesEmpleadoPretenso empleadoFunc = new FuncionesEmpleadoPretenso();

		try {
			empleadoFunc.generarTicket(empleadoFicticio, ticket.getLocacionInt(), ticket.getRemuneracion(), ticket.getCargaHoraria(), ticket.getTipoPuesto(), ticket.getRangoEtario(), ticket.getExperienciaPrevia(), ticket.getEstudios());
		} catch (ParametroFormularioFactoryException | ObjetoNoEstaEnLaListaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		empleadoFunc.setEstadoTicket(empleadoFicticio, ticket.getEstado());
	}

	/**
	 * Método que devuelve al sistema los ticket persistidos correspondientes a determinado Empleador.
	 * <b>Pre: </b>Intancia de DTO con los datos del ticket que se va a agregar al sistema.<br>
	 * <b>Post: </b>Instancia de Ticket incorporada al sistema.<br>
	 * @param datos DTO del ticket de un determinado Empleador dentro del sistema.
	 * @return ticket ingresado al sistema disponible para continuar con la ejecusión de las tareas.
	 * @throws EstadoTicketException 
	 */
	private static void TicketEmpleadorFromTicketEmpleadorDTO(TicketEmpleadorDTO ticket) throws EstadoTicketException {
		EmpleadorFisico empleadorFicticio = new EmpleadorFisico("xxx","xxx","xxx","xxx");
		FuncionesEmpleador empleadorFunc = new FuncionesEmpleador();
		try {
			empleadorFunc.generarTicket(empleadorFicticio,ticket.getCantidadEmpleadosSolicitados(), ticket.getLocacionInt(), ticket.getRemuneracion(), ticket.getCargaHoraria(), ticket.getTipoPuesto(), ticket.getRangoEtario(), ticket.getExperienciaPrevia(), ticket.getEstudios());
		} catch (ObjetoNoEstaEnLaListaException | ParametroInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		empleadorFunc.setEstadoTicket(empleadorFicticio, ticket.getEstado());
	}	
	/**
	 * Método que devuelve al sistema los datos almacenados en una Lista de un Usuario Externo.
	 * <b>Pre: </b>Intancia DTO que tiene almacenado los datos de la Lista de determinado Usuario Externo.<br>
	 * <b>Post: </b>instancia de Lista incorporada al Usuario Externo correspondiente en el sistema.<br>
	 * @param datos de la lista de almacenados en una instancia DTO.
	 */
	private static void ListaFromListaDTO(Sistema sistema, SistemaDTO sistemaDTO) {
		//Arma listas de cada uno de los Empleadores
		for(int i = 0; i<sistema.getEmpleadores().size();i++) {
			//Lista listaEmpleador = sistema.getEmpleadores().get(i).getListadoResultados();
			//ListaDTO listaEmpleadorDTO = sistemaDTO.getEmpleadores().get(i).getListadoResultados();
			//System.out.println("empleador = " + sistema.getEmpleadores().get(i).getNombreUsuario() + " " + sistemaDTO.getEmpleadores().get(i).getListadoResultados().getArrayResultadosRondaEncuentros().size());
			for(int j = 0; j < sistemaDTO.getEmpleadores().get(i).getListadoResultados().getArrayResultadosRondaEncuentros().size() ; j++) {
				StructListadoResultado resultado = new StructListadoResultado();
				int k=0;
				while(k< sistema.getEmpleados().size() && !sistema.getEmpleados().get(k).getNombreUsuario().equals(sistemaDTO.getEmpleadores().get(i).getListadoResultados().getArrayResultadosRondaEncuentros().get(j).getUsuario())) {
					k++;
				}
				if(k<sistema.getEmpleados().size()) {
					resultado.setPuntuacion(sistemaDTO.getEmpleadores().get(i).getListadoResultados().getArrayResultadosRondaEncuentros().get(j).getPuntuacion());
					resultado.setUsuario(sistema.getEmpleados().get(k));
					sistema.getEmpleadores().get(i).getListadoResultados().getArrayResultadosRondaEncuentros().add(resultado);
				}

			}
			sistema.getEmpleadores().get(i).getListadoResultados().setFecha(sistemaDTO.getEmpleadores().get(i).getListadoResultados().getFecha());
		}	

		//Arma listas de cada uno de los Empleados Pretensos
		for(int i = 0; i<sistema.getEmpleados().size();i++) {
			//Lista listaEmpleado = sistema.getEmpleados().get(i).getListadoResultados();
			//ListaDTO listaEmpleadoDTO = sistemaDTO.getEmpleados().get(i).getListadoResultados();
			//System.out.println("empleador = " + sistema.getEmpleados().get(i).getNombreUsuario() + " " + sistemaDTO.getEmpleados().get(i).getListadoResultados().getArrayResultadosRondaEncuentros().size());
			for(int j = 0; j < sistemaDTO.getEmpleados().get(i).getListadoResultados().getArrayResultadosRondaEncuentros().size() ; j++) {
				StructListadoResultado resultado = new StructListadoResultado();
				int k=0;
				while(k< sistema.getEmpleadores().size() && !sistema.getEmpleadores().get(k).getNombre().equals(sistemaDTO.getEmpleados().get(i).getListadoResultados().getArrayResultadosRondaEncuentros().get(j).getUsuario()))
					k++;
				if(k<sistema.getEmpleadores().size()) {
					resultado.setPuntuacion(sistemaDTO.getEmpleados().get(i).getListadoResultados().getArrayResultadosRondaEncuentros().get(j).getPuntuacion());
					resultado.setUsuario(sistema.getEmpleadores().get(k));
					sistema.getEmpleados().get(i).getListadoResultados().getArrayResultadosRondaEncuentros().add(resultado);
				}
			}
			sistema.getEmpleados().get(i).getListadoResultados().setFecha(sistemaDTO.getEmpleados().get(i).getListadoResultados().getFecha());
		}	


	}
	/**
	 * Método que devuelve al sistema los datos almacenados en elecciones de un Usuario Externo.
	 * <b>Pre: </b>Intancia DTO que tiene almacenado los datos de elecciones de determinado Usuario Externo.<br>
	 * <b>Post: </b>instancia de elecciones incorporada al Usuario Externo correspondiente en el sistema.<br>
	 * @param datos de las elecciones de almacenados en una instancia DTO.
	 */
	private static void EleccionesFromEleccionesDTO(Sistema sistema, SistemaDTO sistemaDTO) {
		//agrega las elecciones de cada Empleador
		for(int i = 0; i<sistema.getEmpleadores().size();i++) {
			ArrayList<UsuarioExterno> elecciones = new ArrayList<UsuarioExterno>();
			//ArrayList<String> eleccionesDTO = sistemaDTO.getEmpleadores().get(i).getElecciones();
			for(int j = 0; j < sistemaDTO.getEmpleadores().get(i).getElecciones().size() ; j++) {
				//System.out.println("empleador = " + sistema.getEmpleadores().get(i).getNombreUsuario());
				int k=0;
				while(k< sistema.getEmpleados().size() && !sistema.getEmpleados().get(k).getNombreUsuario().equals(sistemaDTO.getEmpleadores().get(i).getElecciones().get(j)))
					k++;
				if(k<sistema.getEmpleados().size()) {
					elecciones.add(sistema.getEmpleados().get(k));
				}
				
			}
			sistema.getEmpleadores().get(i).setElecciones(elecciones);
		}

		//agrega las elecciones de cada Empleado
		for(int i = 0; i<sistema.getEmpleados().size();i++) {
			ArrayList<UsuarioExterno> elecciones = new ArrayList<UsuarioExterno>();
			//ArrayList<String> eleccionesDTO = sistemaDTO.getEmpleados().get(i).getElecciones();
			//System.out.println("empleado = " + sistema.getEmpleados().get(i).getNombreUsuario() + eleccionesDTO.size());
			for(int j = 0; j < sistemaDTO.getEmpleados().get(i).getElecciones().size() ; j++) {
				//System.out.println("empleado = " + sistema.getEmpleados().get(i).getNombreUsuario());
				elecciones = new ArrayList<UsuarioExterno>();
				int k=0;
				while(k< sistema.getEmpleadores().size() && !sistema.getEmpleadores().get(k).getNombreUsuario().equals(sistemaDTO.getEmpleados().get(i).getElecciones().get(j)))
					k++;
				System.out.println("empleador = " + sistema.getEmpleadores().get(k).getNombreUsuario());
				if(k<sistema.getEmpleadores().size()) {
					elecciones.add(sistema.getEmpleadores().get(k));
				}
			}
			sistema.getEmpleados().get(i).setElecciones(elecciones);
		}
	}

	/**
	 * Método que devuelve al sistema los datos almacenados en el historial de contrataciones.
	 * <b>Pre: </b>Intancia DTO que tiene almacenado los datos del historial de contrataciones.<br>
	 * <b>Post: </b>instancia de historioal de contrataciones incorporada al Usuario Externo correspondiente en el sistema.<br>
	 * @param datos del historial de almacenados en una instancia DTO.
	 */
	private static void HistoricoFromHistoricoDTO(Sistema sistema, SistemaDTO sistemaDTO) {
		for(int i = 0; i<sistema.getHistoricoResultados().size();i++) {
			int j=0,k=0;
			while(j < sistema.getEmpleadores().size() && sistema.getHistoricoResultados().get(j).getEmpleador().getNombreUsuario().equals(sistemaDTO.getHistorialResultados().get(i).getEmpleadorNombreUsuario()))
				j++;
			while(k < sistema.getEmpleados().size() && sistema.getHistoricoResultados().get(j).getEmpleado().getNombreUsuario().equals(sistemaDTO.getHistorialResultados().get(i).getEmpleadoNombreUsuario()))
				k++;
			ResultadosContrataciones resultado = new ResultadosContrataciones(sistema.getEmpleadores().get(j),sistema.getEmpleados().get(k),sistemaDTO.getHistorialResultados().get(i).getComisionEmpleador(),sistemaDTO.getHistorialResultados().get(i).getComisionEmpleado(), sistemaDTO.getHistorialResultados().get(i).getFecha());
			sistema.getHistoricoResultados().add(resultado);
		}
	}

	private static void AdministradorFromAdministradorDTO(Sistema sistema, SistemaDTO sistemaDTO) {
		try {
			sistema.registrarAdministrador(sistemaDTO.getAdministradorDeAgencia().getNombreUsuario(), sistemaDTO.getAdministradorDeAgencia().getNombre(), sistemaDTO.getAdministradorDeAgencia().getNombre());
		} catch (ContraseniaIncorrectaException | NombreUsuarioIncorrectoException | UsuarioDuplicado e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 


}