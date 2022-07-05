package presentacion;

import java.io.IOException;

import dato.TiposDatosTicktets;
import exceptions.EstadoTicketException;
import negocio.Sistema;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;
import persistencia.SistemaDTO;
import persistencia.UtilSistema;

public class PruebaPersLectura {

	public static void main(String[] args) throws EstadoTicketException {
		// TODO Auto-generated method stub
        //IPersistencia persistencia = new PersistenciaXML();
		TiposDatosTicktets.armarListasDatos();
        IPersistencia persistencia = new PersistenciaBIN();
        Sistema sistema = Sistema.getInstance();
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
        
        System.out.println("========================================================");
        System.out.println("Empleador: "+sistema.getEmpleadores().get(1).getNombre());
        System.out.println("Ticket Estado: "+sistema.getEmpleadores().get(1).getTicketEmpleador().getEstado());
        System.out.println("Ticket Cantidad: "+sistema.getEmpleadores().get(1).getTicketEmpleador().getCantidadEmpleadosSolicitados());
        System.out.println("========================================================");
        System.out.println("Empleado: "+sistema.getEmpleados().get(0).getNombre());
        
        
	}

}
