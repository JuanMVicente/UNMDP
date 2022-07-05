package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dato.AdministradorAgencia;
import exceptions.ArrayVacioException;
import exceptions.FechaExpiradaException;
import negocio.FuncionesAdministrador;
import negocio.Sistema;
import persistencia.PersistenciaEscritura;
import vista.VistaAdministrador;

public class ControladorVistaAdmin implements ActionListener {

	private AdministradorAgencia admin;
	private static VistaAdministrador vista;
	public static FuncionesAdministrador fAdmin = new FuncionesAdministrador();
	
	public ControladorVistaAdmin() {
		vista  = new VistaAdministrador();
		vista.actualizarvista();
		vista.setactionlistener(this);
	}
	
	public static void mostrarVista() {
		vista.setVisible(true);
		vista.actualizarvista();
	}

	public static void ocultarVista() {
		vista.setVisible(false);
	}
	
	public static VistaAdministrador getVista() {
		return vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        
		if(e.getActionCommand().equalsIgnoreCase("Cerrar sesion")) {
			  vista.setVisible(false);
			  ControladorMain.mostrarVista();
			  PersistenciaEscritura.EscrituraArchivo();
		}
		if(e.getActionCommand().equalsIgnoreCase("Generar Ronda de Encuentros")) {
			vista.getRondaencuentros().setEnabled(false);
			vista.getContrataciones().setEnabled(true);
			Sistema.getInstance().setBotonRondas(false);
			fAdmin.RondaEncuentrosLaborales();	//llama a genera ronda enc.
			Sistema.getInstance().getHistoricoResultados().clear();
			vista.actualizarvista();
		}
		 else
		if(e.getActionCommand().equalsIgnoreCase("Generar ronda de contrataciones")) {
			
			vista.getRondaencuentros().setEnabled(true);
			vista.getContrataciones().setEnabled(false);
			Sistema.getInstance().setBotonRondas(true);
			
			fAdmin.RondaDeContratacion();
			

				this.vista.actualizarvista();
			}
		}
} 

