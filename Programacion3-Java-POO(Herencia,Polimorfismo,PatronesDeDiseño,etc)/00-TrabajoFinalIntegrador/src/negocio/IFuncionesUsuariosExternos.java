package negocio;

import dato.UsuarioExterno;
import exceptions.ArrayVacioException;
import exceptions.EstadoTicketException;
import exceptions.FechaExpiradaException;

public interface IFuncionesUsuariosExternos {
	
	void visualizacionResultadoRondaEncuentros(UsuarioExterno u) throws ArrayVacioException, FechaExpiradaException;
	void setEstadoTicket(UsuarioExterno u, String estado) throws EstadoTicketException;

}