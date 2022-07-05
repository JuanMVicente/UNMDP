package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import negocio.Sistema;
import persistencia.PersistenciaEscritura;
import vista.VentanaRegistroAdmin;



public class ControladorRegistroAdmin implements  ActionListener{
	private static VentanaRegistroAdmin vista;
	
	public ControladorRegistroAdmin() {
		super();
		vista = new VentanaRegistroAdmin();
		vista.setactionlistener(this);
	}

	public static void mostrarVista() {
		vista.setVisible(true);
	}
	
	public static void ocultarVista() {
		vista.setVisible(false);
	}
	
	public void setVista(VentanaRegistroAdmin v) {
		vista =v;
		vista.setactionlistener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equalsIgnoreCase("registrar")) {
			try {
				Sistema.getInstance().registrarAdministrador(vista.getTextField_1NOMBRE(),vista.getPasswordFieldCONTRASENIA(),vista.getTextField_1NOMBRE());
				JOptionPane.showMessageDialog(null,"Administrador registrado exitosamente!","Registro Administrador Agencia", JOptionPane.INFORMATION_MESSAGE);
				vista.setVisible(false);
				ControladorMain.mostrarVista();
				PersistenciaEscritura.EscrituraArchivo();
				//Controladorbase.ventanafuncionesempleadop();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null,e1.getMessage(),null, JOptionPane.INFORMATION_MESSAGE); 
			} 
			
		}
		else if(e.getActionCommand().equalsIgnoreCase(vista.getBtnIrAtras().getActionCommand())) {
			vista.setVisible(false);
			vista.repaint();
			ControladorMain.mostrarVista();
		}
		
		
	}
	
	
}
