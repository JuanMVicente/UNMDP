package dato;


import java.time.LocalDate;
  /**
   * Clase abstracta hija de usuarioexterno que representa un empleado pretenso, que tiene como atributos el rubro, el ticket correspondiente a esta clase y un arreglo de empleadores por los que fue contratado.
   */
public class EmpleadoPretenso extends UsuarioExterno {

	private String telefono;
	private String fechaNacimiento;
	private String dni;
	private TicketEmpleado TicketEmpleadoP;
	
/**
	 * Constructor del Empleado pretenso:contiene el nombre de usuario , el nombre , telefono,fecha de nacimiento y el dni del pretenso. <br> 
	 * pre: ninguno, todos los parametros pueden estar mal ingresados. post: Crea el empleado con los datos de los parametros, en el momento de registrar dicho empleado se vera si los parametros son admitidos.
	 * @param nombreUsuario
	 * @param contrasenia
	 * @param nombre
	 * @param telefono
	 * @param fechaNacimiento
	 * @param dni
	 */
	public EmpleadoPretenso(String nombreUsuario, String contrasenia, String nombre, String telefono,String fechaNacimiento, String dni) {
		super(nombreUsuario, contrasenia, nombre);
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public TicketEmpleado getTicketEmpleadoP() {
		return TicketEmpleadoP;
	}

	public void setTicketEmpleadoP(TicketEmpleado ticketsEmpleadoP) {
		TicketEmpleadoP = ticketsEmpleadoP;
	}

	/**
     	* Funcion  que desarrollara cada empleado que Devolvera la comision que le correspondera al administrador variando su valor segun el tipo de puesto. 
     	*/
	public double comisionesEmpleado() {

		double comision = 0;
		
		
		if ((TiposDatosTicktets.getTipoPuesto().get(this.getTicketEmpleadoP().getFormularioBusqueda().getTipoPuesto())).equals((TiposDatosTicktets.getTipoPuesto().get(0))))
				comision = 0.8 * TiposDatosTicktets.getRemuneracion().get(this.getTicketEmpleadoP().getFormularioBusqueda().getRemuneracion());
		else if ((TiposDatosTicktets.getTipoPuesto().get(this.getTicketEmpleadoP().getFormularioBusqueda().getTipoPuesto())) == (TiposDatosTicktets.getTipoPuesto().get(1)))
				comision =  0.9 * TiposDatosTicktets.getRemuneracion().get(this.getTicketEmpleadoP().getFormularioBusqueda().getRemuneracion());
		else if ((TiposDatosTicktets.getTipoPuesto().get(this.getTicketEmpleadoP().getFormularioBusqueda().getTipoPuesto())) == (TiposDatosTicktets.getTipoPuesto().get(2)))
				comision =  1 * TiposDatosTicktets.getRemuneracion().get(this.getTicketEmpleadoP().getFormularioBusqueda().getRemuneracion());
		
		return comision; //no debería entrar nunca
	}
	
	@Override
	public String toString() {
		return this.getNombre();
	}

} 