package negocio;

import java.time.LocalDateTime;
import java.util.ArrayList;

import dato.AdministradorAgencia;
import dato.EmpleadoPretenso;
import dato.Empleador;
import dato.EmpleadorFisico;
import dato.EmpleadorJuridico;
import dato.ResultadosContrataciones;
import dato.TicketEmpleado;
import dato.TicketEmpleador;
import dato.Usuario;
import exceptions.ArrayVacioException;
import exceptions.ContraseniaIncorrectaException;
import exceptions.ErrorLogInException;
import exceptions.NombreUsuarioIncorrectoException;
import exceptions.TipoUsuarioIncorrectoExcpection;
import exceptions.UsuarioDuplicado;
import exceptions.UsuarioRepetidoException;

//import exceptions.ErrorRemoveArray;

/**
 * @author Grupo 9<br>
 * Clase que representa el sistema que contiene todas los datos y funcionalidades a ejecutar por el programa.
 * 
 */
public class Sistema {

	private static Sistema instance = null;

	private ArrayList<Empleador> empleadores = new ArrayList<Empleador>();
	private ArrayList<EmpleadoPretenso> empleados = new ArrayList<EmpleadoPretenso>();
	private ArrayList<TicketEmpleado> ticketsEmpleados = new ArrayList<TicketEmpleado>();
	private ArrayList<TicketEmpleador> ticketEmpleadores = new ArrayList<TicketEmpleador>();
	private AdministradorAgencia administradorDeAgencia = null;
	private LocalDateTime fechaRondaencuentros = null;;
	private ArrayList<ResultadosContrataciones> historialResultados = new ArrayList<ResultadosContrataciones>();
	
	private boolean botonRondas = true;

	/**
	 * M�todo que retorna la fecha de la �ltima ronda de encuentros laborales.<br>
	 * <b>Pre: </b>Se debe haber realizado una ronda de encuentros laborales para retornar una fecha cierta, de no ser as� la fecha ser� nula.<br>
	 * <b>Post: </b> Fecha en la cual se gener� la �ltima ronda de Encuentros laborales.<br>
	 * @return Retorna la fecha de la ultima ronda de encuentros laborales.
	 */
	public LocalDateTime getFechaRondaencuentros() {
		return fechaRondaencuentros;
	}


	/**
	 * M�todo que setea fecha de la ultima ronda de encuentros laborales.<br>
	 * <b>Pre: </b>No posee ninguna precondici�n.<br>
	 * <b>Post: </b>Le asigna al atributo "fechaRondaencuentros" de esta clase la fecha ingresada como par�metro.<br>
	 * @param localDateTime
	 */
	public void setFechaRondaencuentros(LocalDateTime localDateTime) {
		this.fechaRondaencuentros = localDateTime;
	}

	/**
	 * Constructor desarrollado como privado que permite cumplir con el patr�n Singleton.
	 */
	private Sistema() {
		super();
		this.fechaRondaencuentros = LocalDateTime.now();	
	}


	/**
	 * M�todo qu� retorna la �nica instancia de sistema generada gracias al patr�n Singleton.<br>
	 * <b>Pre: </b>No posee ninguna precondici�n.<br>
	 * <b>Post: </b>Retorna la �nica instancia de sistema generada gracias al patr�n Singleton. En el primer llamado a este m�todo 
	 * genera esta �nica instancia.<br>
	 * @return retorna la �nica instancia de sistema generada gracias al patr�n Singleton.
	 */
	public static Sistema getInstance() 
	{
		if(instance == null)
			instance = new Sistema();
		return instance;
	}


	/**
	 * M�todo qu� retorna la lista de empleadores cargados en el sistema.<br>
	 * <b>Pre: </b>Debe tener empleadores registrados para su correcta ejecuci�n, de lo contrario el sistema no muestra ning�n dato.<br>
	 * <b>Post: </b>Retorna la lista de empleadores cargados en el sistema.<br>
	 * @return lista de empleadores cargados en el sistema.
	 */
	public ArrayList<Empleador> getEmpleadores() {
		return empleadores;
	}

	/**
	 * M�todo qu� retorna la lista de empleados pretensos cargados en el sistema.<br>
	 * <b>Pre: </b>Debe tener empleados pretensos registrados para su correcta ejecuci�n, de lo contrario el sistema no muestra ning�n dato.<br>
	 * <b>Post: </b>Retorna la lista de empleadores cargados en el sistema.<br>
	 * @return lista de empleados pretensos cargados en el sistema.
	 */
	public ArrayList<EmpleadoPretenso> getEmpleados() {
		return empleados;
	}

	/**
	 * M�todo qu� retorna el listado hist�rico de tickets de empleados pretensos cargados en el sistema.<br>
	 * <b>Pre: </b>Debe tener tickets registrados para su correcta ejecuci�n, de lo contrario el sistema no muestra ning�n dato.<br>
	 * <b>Post: </b>Retorna la lista hist�tica de tickets de empleados pretensos en el sistema.<br>
	 * @return listado hist�rico de tickets de empleados pretensos  cargados en el sistema.
	 */
	public ArrayList<TicketEmpleado> getTicketsEmpleados() {
		return ticketsEmpleados;
	}

	/**
	 * M�todo qu� retorna el listado hist�rico de tickets de empleadores potenciales cargados en el sistema.<br>
	 * <b>Pre: </b>Debe tener tickets registrados para su correcta ejecuci�n, de lo contrario el sistema no muestra ning�n dato.<br>
	 * <b>Post: </b>Retorna la lista hist�tica de tickets de empleadores potenciales en el sistema.<br>
	 * @return listado hist�rico de tickets de empleadores potenciales  cargados en el sistema.
	 */
	public ArrayList<TicketEmpleador> getTicketEmpleadores() {
		return ticketEmpleadores;
	}

	/**
	 * M�todo qu� retorna el usuario Administrador del Sistema.<br>
	 * <b>Pre: </b>Debe tener usuario registrado, de lo contrario el sistema no muestra ning�n dato.<br>
	 * <b>Post: </b>Retorna el usuario Administrador del Sistema.<br>
	 * @return retorna el usuario Administrador del Sistema.
	 */
	public AdministradorAgencia getAdministradorDeAgencia() {
		return administradorDeAgencia;
	}


	/**
	 * M�todo qu� registra un nuevo Empleado Pretenso dentro del sistema.<br>
	 * <b>Pre: </b>No debe existir el nuevo usuario en el sistema, de lo contratio lanzar� una excepci�n.<br>
	 * <b>Post: </b>Usuario enviado como par�metro cargado en el sistema<br>
	 * @param empleadoPretenso representa un nuevo empleado pretenso a cargar en el sistema de clase EmpleadoPretenso.<br>
	 * @throws UsuarioRepetidoException Cuando el usuario ya se encuentra cargado en el sistema lanza una excepci�n.
	 * @throws ContraseniaIncorrectaException Se lanza en caso de que el usuario no haya sido creado con un nombre de usuario
	 * @throws NombreUsuarioIncorrectoException  Se lanza en caso de que el usuario no haya sido creado con una contrasenia
	 */
	public void registrarEmpleadoPretenso(String nombreUsuario, String contrasenia, String nombre, String telefono, String fechaNac, String dni) throws UsuarioRepetidoException, ContraseniaIncorrectaException, NombreUsuarioIncorrectoException 
	{    
			
		int i=0;
		while(i<this.getEmpleados().size() && !this.getEmpleados().get(i).getNombreUsuario().equalsIgnoreCase(nombreUsuario))
			i++;
		if(i==this.getEmpleados().size()) {
			empleados.add(new EmpleadoPretenso(nombreUsuario, contrasenia, nombre, telefono, fechaNac, dni));
			//PersistenciaEscritura.EscrituraArchivo();
		}
		else 
			throw new UsuarioRepetidoException("EL nombre de usuario ingresado no esta disponible"); 
	}


	/**
	 * M�todo qu� registra un nuevo Empleador dentro del sistema.<br>
	 * <b>Pre: </b>No debe existir el nuevo usuario en el sistema, de lo contratio lanzar� una excepci�n.<br>
	 * <b>Post: </b>Usuario enviado como par�metro cargado en el sistema<br>
	 * @param empleador representa un nuevo empleador a cargar en el sistema de clase "Empleador".<br>
	 * @throws UsuarioRepetidoException Cuando el usuario ya se encuentra cargado en el sistema lanza una excepci�n.
	 * @throws ContraseniaIncorrectaException Se lanza en caso de que el usuario no haya sido creado con un nombre de usuario
	 * @throws NombreUsuarioIncorrectoException  Se lanza en caso de que el usuario no haya sido creado con una contrasenia
	 */
	public void registrarEmpleador(String nombreUsuario, String contrasenia,String tipoEmpleador, String razonSocial, String rubro) throws UsuarioRepetidoException, ContraseniaIncorrectaException, NombreUsuarioIncorrectoException  
	{
		int i=0;
		while(i<this.getEmpleadores().size() && !(this.getEmpleadores().get(i).getNombreUsuario().equalsIgnoreCase(nombreUsuario)))
			i++;
		if(i==this.getEmpleadores().size())	{
			if(tipoEmpleador.equalsIgnoreCase("FISICA"))
				empleadores.add(new EmpleadorFisico(nombreUsuario, contrasenia,razonSocial,rubro));
			else if(tipoEmpleador.equalsIgnoreCase("JURIDICA"))
				empleadores.add(new EmpleadorJuridico(nombreUsuario, contrasenia, razonSocial,rubro));
			
			//PersistenciaEscritura.EscrituraArchivo();
		}else 
			throw new UsuarioRepetidoException("EL nombre de usuario no esta disponible");
		
	}


	/**
	 * M�todo qu� registra un nuevo Empleador dentro del sistema.<br>
	 * <b>Pre: </b>No debe existir un usuario de tipo Administrador en el sistema.<br>
	 * <b>Post: </b>Asigna a la clase sistema al usuario Administrador.<br>
	 * @param administrador usuario administrador de clase AdministradorAgencia.
	 * @throws ContraseniaIncorrectaException Se lanza en caso de que el usuario no haya sido creado con un nombre de usuario
	 * @throws NombreUsuarioIncorrectoException  Se lanza en caso de que el usuario no haya sido creado con una contrasenia
	 * @throws UsuarioDuplicado 
	 * 
	 */

	public void registrarAdministrador(String usuario,String contrasenia,String nombre) throws ContraseniaIncorrectaException, NombreUsuarioIncorrectoException, UsuarioDuplicado 
	{
		if(!usuario.isBlank())
		{
			if(!contrasenia.isBlank())
			{
				if(this.administradorDeAgencia == null) {
					this.administradorDeAgencia =  new AdministradorAgencia(usuario,contrasenia,nombre);
					//PersistenciaEscritura.EscrituraArchivo();
			    }
				else
					throw new UsuarioDuplicado("El Administrador de Agencia ya se encuentra registrado");
			}
			else
				throw new ContraseniaIncorrectaException("Para resgistrarse debe ingresar una contrasenia");
		}
		else
			throw new NombreUsuarioIncorrectoException("Para registrarse debe ingresar un nombre de usuario");
	}


	/**
	 * M�todo qu� registra un Ticket de Empleado Pretenso dentro del hist�rico de Tickets del sistema.<br>
	 * <b>Pre: </b>Cumplir con los par�metros de entrada correspondientes.<br>
	 * <b>Post: </b>Nuevo Ticket ingreso al hist�rico de tickets de empleados pretensos en el sistema.<br> 
	 * @param ticketsEmpleados: objeto de clase TicketEmpleado a cargar en el hist�rico.
	 */
	public void registrarTicketsEmpleados(TicketEmpleado ticketsEmpleados) {
		this.ticketsEmpleados.add(ticketsEmpleados);
		//PersistenciaEscritura.EscrituraArchivo();
	}


	/**
	 * M�todo qu� registra un Ticket de Empleadores dentro del hist�rico de Tickets del sistema.<br>
	 * <b>Pre: </b>Cumplir con los par�metros de entrada correspondientes.<br>
	 * <b>Post: </b>Nuevo Ticket ingreso al hist�rico de tickets de empleadores en el sistema.<br> 
	 * @param ticketEmpleadores: objeto de clase TicketEmpleadores a cargar en el hist�rico.
	 */
	public void registrarTicketEmpleadores(TicketEmpleador ticketEmpleadores) {
		this.ticketEmpleadores.add(ticketEmpleadores);
		//PersistenciaEscritura.EscrituraArchivo();
	}


	@Override
	public String toString() {
		return "Sistema [empleadores=" + empleadores + ", empleados=" + empleados + ", administradorDeAgencia="
				+ administradorDeAgencia + "]";
	}	

	/**
	 * @return
	 */
	public ArrayList<ResultadosContrataciones> getHistoricoResultados() {
		return historialResultados;
	}

	/**
	 * M�todo qu� registra un resultado nuevo al historial de resultados del sistema.<br>
	 * <b>Pre: </b>Ingresar un par�metro resultado.<br>
	 * <b>Post: </b>Nuevo resultado de contrataci�n ingresado al hist�rico.<br>
	 * @param resultados
	 */
	public void addResultadoContratacion(ResultadosContrataciones resultados) {
		//historialResultados.add(resultados);
		historialResultados.add(0, resultados);
		//PersistenciaEscritura.EscrituraArchivo();
	}


	/**
	 * M�todo que permite el log in de cualquier tipo de usuario que desea ingresar al sistema. Sea EMpleado Pretenso, Empleador o
	 * Administrador del Sistema.<br>
	 * @param nombreusuario: String con el nombre del usuario que desea ingresar<br>
	 * @param contrasenia: String con la contrasenia correspondiente a ese usuario.<br>
	 * @param tipo: Int con el tipo de usuario (0: Empleado Pretenso / 1: Empleador / 2: Administrador del sistema)<br>
	 * @return devuelve el mensaje si el usuario se ha loggeado con �xito.<br>
	 * @throws ErrorLogInException lanza excepciones si el usuario se equivoca en alguno de los tres par�metros.
	 */
	public Usuario login(String nombreusuario,String contrasenia,String tipoUsuario) throws ErrorLogInException, ArrayVacioException{  

		int i=0;

		if(tipoUsuario.equalsIgnoreCase("EMPLEADO")) { /// 0 = empleado

			if(empleados.size()!=0)
			{
				while(empleados.size()>i && (!empleados.get(i).getNombreUsuario().equalsIgnoreCase(nombreusuario))) 
					i++;
				if(i<empleados.size())
					if((empleados.get(i).getContrasenia().equalsIgnoreCase(contrasenia))) 
						return empleados.get(i);
					else
						throw new ContraseniaIncorrectaException("La contrasenia ingresada es incorrecta");
				else
					throw new NombreUsuarioIncorrectoException("El nombre de usuario ingresado no existe");
			}
			else
				throw new ArrayVacioException("El usuario no se encuentra registrado");
		}
		else

			if(tipoUsuario.equalsIgnoreCase("EMPLEADOR"))
				if(empleadores.size()>0) 
				{
					while(empleadores.size()>i && (!empleadores.get(i).getNombreUsuario().equalsIgnoreCase(nombreusuario))) 
						i++;
					if(i < empleadores.size()) {
						if((empleadores.get(i).getContrasenia().equalsIgnoreCase(contrasenia))) 
							return empleadores.get(i);
						else
							throw new ContraseniaIncorrectaException("La contrasenia ingresada es incorrecta");
					}
					else
						throw new NombreUsuarioIncorrectoException("El nombre de usuario ingresado no existe");
				}
				else
					throw new ArrayVacioException("El usuario no se encuentra registrado");


			else 
				if(tipoUsuario.equalsIgnoreCase("ADMINISTRADOR"))
				{ 
					if(this.administradorDeAgencia!=null)
						if(administradorDeAgencia.getNombreUsuario().equalsIgnoreCase(nombreusuario))
							if(administradorDeAgencia.getContrasenia().equalsIgnoreCase(contrasenia))
								return administradorDeAgencia;
							else
								throw new ContraseniaIncorrectaException("La contrasenia ingresada es incorrecta");
						else
							throw new NombreUsuarioIncorrectoException("El nombre de usuario ingresado no existe");
					else
						throw new ArrayVacioException("El usuario no se encuentra registrado");
				}
				else
					throw new TipoUsuarioIncorrectoExcpection("El tipo de usuario ingresado no existe");
	}


	public boolean isBotonRondas() {
		return botonRondas;
	}


	public void setBotonRondas(boolean botonRondas) {
		this.botonRondas = botonRondas;
	}

	

}