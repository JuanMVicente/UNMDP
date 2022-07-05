package persistencia;

import java.io.IOException;

import exceptions.EstadoTicketException;
import negocio.Sistema;

public class PersistenciaLectura{


	private static Sistema sistema = Sistema.getInstance();

	public static void LecturaArchivo() throws EstadoTicketException {
		
		IPersistencia persistencia = new PersistenciaBIN();
		try
		{
			persistencia.abrirInput("Sistema.bin");
			System.out.println("Archivo abierto");
			SistemaDTO sdto=(SistemaDTO) persistencia.leer();
			sistema = UtilSistema.sistemaFromSistemaDTO(sdto);
			System.out.println("Sistema recuperado");
			persistencia.cerrarInput();
			System.out.println("Archivo cerado");
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}