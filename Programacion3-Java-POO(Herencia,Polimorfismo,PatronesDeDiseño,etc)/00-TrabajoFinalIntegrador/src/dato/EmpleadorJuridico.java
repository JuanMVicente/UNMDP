package dato;

public class EmpleadorJuridico extends Empleador{

	public EmpleadorJuridico(String nombreUsuario, String contrasenia, String razonSocial,String rubro) {
		super(nombreUsuario, contrasenia, razonSocial,rubro);
		// TODO Auto-generated constructor stub
	}

	public double comisionesEmpleador() {
			
		double comision = 0;
		
		if (super.getRubro() == TiposRubro.salud)
			comision = 0.8 * TiposDatosTicktets.getRemuneracion().get(getTicketEmpleador().getFormularioBusqueda().getRemuneracion());
		
		else if (super.getRubro() == TiposRubro.comercioLocal)
			comision = 0.9 * TiposDatosTicktets.getRemuneracion().get(getTicketEmpleador().getFormularioBusqueda().getRemuneracion());
		
		else if (super.getRubro() == TiposRubro.comercioInternacional)
			comision = 1 * TiposDatosTicktets.getRemuneracion().get(getTicketEmpleador().getFormularioBusqueda().getRemuneracion());
		
		return comision;
	}

	/*@Override
	public String toString() {
		return this.getNombre();
	}*/
}

