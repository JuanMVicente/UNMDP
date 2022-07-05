package dato;

/**
 * Clase abstracta hija de usuarioexterno que representa un empleador, que tiene como atributos el rubro, el ticket correspondiente a esta clase y un arreglo de empleados pretensos contratados.
 * @author Grupo 9
 */

public abstract class Empleador extends UsuarioExterno { 

	private String rubro; // "salud" - "comercio local" - "comercio internacional"
	private TicketEmpleador ticketEmpleador;
	
	/**
	 * Constructor del Empleador:
	 * pre: ninguno, todos los parametros pueden estar mal ingresados.
	 * post: Crea el empleador con los datos de los parametros, en el momento de registrar dicho empleador se vera si los parametros son admitidos.
	 * @param nombreUsuario
	 * @param contrasenia
	 * @param rubro
	 * @param nombre
	 */
	public Empleador(String nombreUsuario, String contrasenia, String nombre, String rubro) {
		super(nombreUsuario, contrasenia, nombre);
		this.setRubro(rubro);
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}
	
	public TicketEmpleador getTicketEmpleador() {
		return ticketEmpleador;
	}

	public void setTicketEmpleador(TicketEmpleador ticketEmpleador) {
		this.ticketEmpleador = ticketEmpleador;
	}

    /**
   	  * Funcion abstracta que desarrollara cada tipo de empleador segun sea fisico o juridico. dependiendo de esto ultimo, se desarrollara en cada clase la<br>
   	  * funcion que devolvera la comision que le correspondera al administrador. 
     */

	public abstract double comisionesEmpleador();

	@Override
	public String toString() {
		return this.getNombreUsuario();
	}
	
	
} 