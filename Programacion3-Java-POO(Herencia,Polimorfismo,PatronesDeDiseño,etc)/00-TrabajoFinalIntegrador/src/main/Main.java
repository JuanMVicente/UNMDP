package main;


import controladores.ControladorMain;
import dato.TiposDatosTicktets;
import exceptions.EstadoTicketException;
import persistencia.PersistenciaLectura;



public class Main {

	public static void main(String[] args) 
	{

		
		TiposDatosTicktets.armarListasDatos();
	
		try {
			PersistenciaLectura.LecturaArchivo();
		} catch (EstadoTicketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		ControladorMain controlador = new ControladorMain();
		

	}
	
}