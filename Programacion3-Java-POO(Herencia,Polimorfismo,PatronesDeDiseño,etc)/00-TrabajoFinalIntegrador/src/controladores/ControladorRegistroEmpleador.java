package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import negocio.Sistema;
import persistencia.PersistenciaEscritura;
import vista.VentanaRegistroEmpleador;

public class ControladorRegistroEmpleador implements ActionListener  {
	
	private static VentanaRegistroEmpleador vista;
	
	public ControladorRegistroEmpleador() {
		vista = new VentanaRegistroEmpleador();
		vista.setactionlistener(this);
	}

	public static void mostrarVista() {
		vista.setVisible(true);
	}
	
	public static void ocultarVista() {
		vista.setVisible(false);
	}
	
	public void setVista(VentanaRegistroEmpleador v) {
		vista = v;
		vista.setactionlistener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		  
		
		if(e.getActionCommand().equalsIgnoreCase("registrar")) {
			  try {
				Sistema.getInstance().registrarEmpleador(vista.getTextFieldUSUARIO(),vista.getPasswordFieldCONTRA(),vista.gettipopers(),vista.getTextField_1RAZON(),vista.getrubro());
				JOptionPane.showMessageDialog(null,"Empleador registrado exitosamente!","Registro Empleador", JOptionPane.INFORMATION_MESSAGE);
				vista.setVisible(false);
				ControladorMain.mostrarVista();
				PersistenciaEscritura.EscrituraArchivo();
			  } catch (Exception e1) {
			JOptionPane.showMessageDialog(null,e1.getMessage(),"Registro Empleador", JOptionPane.ERROR_MESSAGE);
			}
		  }
		else if(e.getActionCommand().equalsIgnoreCase("Ir Atras")) {
			vista.setVisible(false);
			vista.repaint();
			ControladorMain.mostrarVista();
		}
		
	}
	
	
	
}
