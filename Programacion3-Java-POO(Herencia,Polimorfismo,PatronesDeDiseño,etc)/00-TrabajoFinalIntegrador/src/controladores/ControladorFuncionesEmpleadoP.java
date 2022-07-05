package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dato.EmpleadoPretenso;
import dato.Empleador;
import exceptions.EstadoTicketException;
import negocio.FuncionesAdministrador;
import negocio.FuncionesEmpleadoPretenso;
import negocio.Sistema;
import persistencia.PersistenciaEscritura;
import vista.VistaEmpleadoP;

public class ControladorFuncionesEmpleadoP implements ActionListener{

	private EmpleadoPretenso empleado;
	private FuncionesEmpleadoPretenso fEmpleado = new FuncionesEmpleadoPretenso();
	private FuncionesAdministrador fAdmin = ControladorVistaAdmin.fAdmin;
	private static VistaEmpleadoP vista;
	
		
	public ControladorFuncionesEmpleadoP(EmpleadoPretenso empleado) {
		this.setVista(new VistaEmpleadoP());
		this.empleado = empleado;
	}
	
	public static void mostrarVista() {
		vista.setVisible(true);
	}

	public static void ocultarVista() {
		vista.setVisible(false);
	}

	public void setVista(VistaEmpleadoP vistaEmpleadoP) {
		vista = vistaEmpleadoP;
		vista.setactionlistener(this);
	}
	
	public static VistaEmpleadoP getVista() {
		return vista;
	}

	public EmpleadoPretenso getEmpleador() {
		return empleado;
	}

	public void setEmpleado(EmpleadoPretenso empleado) {
		this.empleado = empleado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getActionCommand().equalsIgnoreCase("CerrarSesion")) {
			 vista.getEstadoTickets().clearSelection();
			 vista.getLocacio().clearSelection();
			 vista.getRemunera().clearSelection();
			 vista.getCarga_Hora().clearSelection();
			 vista.getTipoPues().clearSelection();
			 vista.getRango_Etar().clearSelection();
			 vista.getExperiencia().clearSelection();
			 vista.getEstudios().clearSelection();
			 vista.setVisible(false);
			 ControladorMain.mostrarVista();
			 PersistenciaEscritura.EscrituraArchivo();
		}
		else
		if(e.getActionCommand().equalsIgnoreCase("Enviar")) 
		{	
			
			/*System.out.println(Integer.parseInt(vista.getLocacio().getSelection().getActionCommand()));
			System.out.println(vista.getCarga_Hora().getSelection().getMnemonic());
			System.out.println(vista.getTipoPues().getButtonCount()-1);
			System.out.println(vista.getRango_Etar().getButtonCount()-1);
			System.out.println(vista.getExperiencia().getButtonCount()-1);
			System.out.println(vista.getEstudios().getButtonCount()-1);
			System.out.println(Integer.parseInt(vista.getTextFieldCantidadEmpleados()));
			
			*/
			
			try {
				fEmpleado.generarTicket(empleado,
						Integer.parseInt(vista.getLocacio().getSelection().getActionCommand()),
						Integer.parseInt(vista.getRemunera().getSelection().getActionCommand()),
						Integer.parseInt(vista.getCarga_Hora().getSelection().getActionCommand()),
						Integer.parseInt(vista.getTipoPues().getSelection().getActionCommand()),
						Integer.parseInt(vista.getRango_Etar().getSelection().getActionCommand()),
						Integer.parseInt(vista.getExperiencia().getSelection().getActionCommand()),
						Integer.parseInt(vista.getEstudios().getSelection().getActionCommand())); 
				JOptionPane.showMessageDialog(null,"Ticket Generado Correctamente","Generacion de ticket", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null,e1.getMessage(),"Error Generacion Ticket", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if (e.getActionCommand().equalsIgnoreCase("aceptar")) 
		{
			try {
				fEmpleado.RondaEleccionEmpleadores(empleado, vista.getListaRonda().getSelectedValuesList());
				this.actualizar();
			} 
			catch (Exception e1) 
			{
				JOptionPane.showMessageDialog(null,e1.getMessage(),"Ronda Eleccion Empleador", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getActionCommand().equalsIgnoreCase("AceptarEstadoTicket")) {
			try {
				fEmpleado.setEstadoTicket(empleado, vista.getEstadoTickets().getSelection().getActionCommand());
				JOptionPane.showMessageDialog(null,"El Estado del Ticket se cambio de forma exitosa","Estado Ticket", JOptionPane.INFORMATION_MESSAGE);
			} catch (EstadoTicketException e1) {
				JOptionPane.showMessageDialog(null,e1.getMessage(),"Estado Ticket", JOptionPane.ERROR_MESSAGE);
			}
		}

	}
	
	public void actualizar() {
		
		vista.getModelRonda().clear();
		for(int i=0; i<empleado.getListadoResultados().getArrayResultadosRondaEncuentros().size();i++) {
			vista.getModelRonda().addElement((Empleador) empleado.getListadoResultados().getArrayResultadosRondaEncuentros().get(i).getUsuario());
			vista.getModelPuntuaciones().addElement((int)empleado.getListadoResultados().getArrayResultadosRondaEncuentros().get(i).getPuntuacion());
		}
		
		///
		vista.getModelEleccion().clear();
		for(int i=0; i<empleado.getElecciones().size();i++)
			vista.getModelEleccion().addElement((Empleador) empleado.getElecciones().get(i));
		
		////
		vista.getModelContrataciones().clear();
		for (int i=0; i<Sistema.getInstance().getHistoricoResultados().size() ; i++) 	 
			 vista.getModelContrataciones().addElement(Sistema.getInstance().getHistoricoResultados().get(i));		
			 vista.getVisualizacionContrataciones().setModel(vista.getModelContrataciones());
			//vista.getModelContrataciones().addElement(Sistema.getInstance().getHistoricoResultados().get(i).getEmpleado());
		
	}
	
	
	
	/*public void actualizarListaRondaEncuentros() {
		vista.getModelRonda().clear();
		for(int i=0; i<empleado.getListadoResultados().getArrayResultadosRondaEncuentros().size();i++)
			vista.getModelRonda().addElement((Empleador) empleado.getListadoResultados().getArrayResultadosRondaEncuentros().get(i).getUsuario());
		System.out.println(vista.getModelRonda());
	}
	
	public void actualizarListaRondaElecciones() {
		vista.getModelEleccion().clear();
		for(int i=0; i<empleado.getElecciones().size();i++)
			vista.getModelEleccion().addElement((Empleador) empleado.getElecciones().get(i));
	}
	
     void agregarObservable() {
		this.fAdmin.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) 
	{		
		
		ArrayList<Empleador> resultadoRondaEncuentros = new ArrayList<Empleador>();
		try {
			vista.getModelRonda().clear();
			resultadoRondaEncuentros = fEmpleado.getResultadoRondaEncuentros(empleado);
			for(int i=0; i< resultadoRondaEncuentros.size();i++) 
				vista.getModelRonda().addElement(resultadoRondaEncuentros.get(i));
				
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"Resultado Ronda Encuentros", JOptionPane.INFORMATION_MESSAGE);
		}
	}*/
	
	//#########

}