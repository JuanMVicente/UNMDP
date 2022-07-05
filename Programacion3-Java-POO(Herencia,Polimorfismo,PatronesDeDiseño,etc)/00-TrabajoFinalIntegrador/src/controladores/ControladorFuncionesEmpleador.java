package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dato.EmpleadoPretenso;
import dato.Empleador;
import exceptions.EstadoTicketException;
import negocio.FuncionesAdministrador;
import negocio.FuncionesEmpleador;
import negocio.Sistema;
import persistencia.PersistenciaEscritura;
import vista.VistaEmpleador;

public class ControladorFuncionesEmpleador implements ActionListener{

	private Empleador empleador;
	private FuncionesEmpleador fEmpleador = new FuncionesEmpleador();
	private FuncionesAdministrador fAdmin = ControladorVistaAdmin.fAdmin;
	private static VistaEmpleador vista;
		
	public ControladorFuncionesEmpleador(Empleador empleador) {

		this.setVista(new VistaEmpleador());
		this.empleador = empleador;	
		
	}
	
	public static void mostrarVista() {
		vista.setVisible(true);
		
	}

	public static void ocultarVista() {
		vista.setVisible(false);
	}

	public void setVista(VistaEmpleador v) {
		vista = v;
		vista.setactionlistener(this);
	}
	

	public static VistaEmpleador getVista() {
		return vista;
	}

	public Empleador getEmpleador() {
		return empleador;
	}

	public void setEmpleador(Empleador empleador) {
		this.empleador = empleador;
	}
	
	public void actualizar() {	
		
		vista.getModelRonda().clear();
		vista.getModelEleccion().clear();
		vista.getModelContrataciones().clear();
		vista.getModelPuntuacion().clear();
		
		
		for(int i=0; i<empleador.getListadoResultados().getArrayResultadosRondaEncuentros().size();i++) {
			vista.getModelRonda().addElement((EmpleadoPretenso) empleador.getListadoResultados().getArrayResultadosRondaEncuentros().get(i).getUsuario());
			vista.getModelPuntuacion().addElement((int) empleador.getListadoResultados().getArrayResultadosRondaEncuentros().get(i).getPuntuacion());
		}
		
		for (int i=0; i<empleador.getElecciones().size(); i++) 
			vista.getModelEleccion().addElement((EmpleadoPretenso) empleador.getElecciones().get(i));
		
		
		for (int i=0; i<Sistema.getInstance().getHistoricoResultados().size() ; i++) 
			vista.getModelContrataciones().addElement(Sistema.getInstance().getHistoricoResultados().get(i));
		
		
		
		// vista.getResultadoscontrataciones().setModel(vista.getModelContrataciones());
			//vista.getModelContrataciones().addElement(Sistema.getInstance().getHistoricoResultados().get(i).getEmpleado());
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getActionCommand().equalsIgnoreCase("CerrarSesion")) {
			 vista.getEstadosTicket().clearSelection();
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
				fEmpleador.generarTicket(empleador,
						Integer.parseInt(vista.getTextFieldCantidadEmpleados()),
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
				fEmpleador.RondaEleccionEmpleadosPretensos(empleador,vista.getListaRonda().getSelectedValuesList());
				this.actualizar();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null,e1.getMessage(),"Ronda de Eleccion Empleado", JOptionPane.ERROR_MESSAGE);
			}
		
		}
		else if(e.getActionCommand().equalsIgnoreCase("AceptarEstadoTicket")) {
			try {
				fEmpleador.setEstadoTicket(empleador, vista.getEstadosTicket().getSelection().getActionCommand());
				JOptionPane.showMessageDialog(null,"El Estado del Ticket se cambio de forma exitosa","Estado Ticket", JOptionPane.INFORMATION_MESSAGE);
			} catch (EstadoTicketException e1) {
				JOptionPane.showMessageDialog(null,e1.getMessage(),"Estado Ticket", JOptionPane.ERROR_MESSAGE);
			}
		}

	}
	
	/* void agregarObservable() {
		this.fAdmin.addObserver(this);
	}

	 @Override
	public void update(Observable o, Object arg) 
	{		
		ArrayList<EmpleadoPretenso> resultadoRondaEncuentros = new ArrayList<EmpleadoPretenso>();
		try {
			vista.getModelRonda().clear();
			resultadoRondaEncuentros = fEmpleador.getResultadoRondaEncuentros(empleador);
			for(int i=0; i<resultadoRondaEncuentros.size();i++)
				vista.getModelRonda().addElement(resultadoRondaEncuentros.get(i));
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"Resultado Ronda Encuentros", JOptionPane.INFORMATION_MESSAGE);
		}
	} */
	
	//#########

}