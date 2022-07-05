package dato;

public class EmpleadorFisico extends Empleador{


	public EmpleadorFisico(String nombreUsuario, String contrasenia,String razonSocial,String rubro) {
		super(nombreUsuario, contrasenia,razonSocial,rubro);
	}


	public double comisionesEmpleador() {

		double comision = 0;
		
		if (super.getRubro() == TiposRubro.salud)
			 comision =  0.6 * TiposDatosTicktets.getRemuneracion().get(getTicketEmpleador().getFormularioBusqueda().getRemuneracion());
		
		else if (super.getRubro() == TiposRubro.comercioLocal)
			comision =  0.7 * TiposDatosTicktets.getRemuneracion().get(getTicketEmpleador().getFormularioBusqueda().getRemuneracion());
		
		else if (super.getRubro() == TiposRubro.comercioInternacional)
			comision = 0.8 * TiposDatosTicktets.getRemuneracion().get(getTicketEmpleador().getFormularioBusqueda().getRemuneracion());
		
		return comision; //no debería entrar nunca
	}


	/*@Override
	public String toString() {
		return this.getNombre();
	}*/

}