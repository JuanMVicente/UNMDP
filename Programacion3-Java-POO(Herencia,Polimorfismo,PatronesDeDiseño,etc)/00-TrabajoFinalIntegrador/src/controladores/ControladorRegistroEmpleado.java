package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import negocio.Sistema;
import persistencia.PersistenciaEscritura;
import vista.VentanaRegistroEmpleado;

public class ControladorRegistroEmpleado implements ActionListener  {
	
	private static VentanaRegistroEmpleado vista;
	private ActionListener actionlistener;
	
	public ControladorRegistroEmpleado() {
		vista = new VentanaRegistroEmpleado();
		vista.setactionlistener(this);
	}

	public static void mostrarVista() {
		vista.setVisible(true);
	}
	
	public static void ocultarVista() {
		vista.setVisible(false);
	}
	
	public void setVista(VentanaRegistroEmpleado v) {
		vista = v;
		vista.setactionlistener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 
		if(e.getActionCommand().equalsIgnoreCase("Registrarse"))
			try {
				Sistema.getInstance().registrarEmpleadoPretenso(vista.getTextFieldUSUARIO(),vista.getPasswordField(),vista.getTextFieldNOMBRE(),vista.getTextFieldTELEFONO(),vista.getTextFieldFECHA(),vista.getTextFieldDNI());
				JOptionPane.showMessageDialog(null,"Empleado registrado exitosamente!","Registro Empleado", JOptionPane.INFORMATION_MESSAGE);
				vista.setVisible(false);
				ControladorMain.mostrarVista();
				PersistenciaEscritura.EscrituraArchivo();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,e1.getMessage(),"Registro Empleado", JOptionPane.ERROR_MESSAGE);
			}
		else if(e.getActionCommand().equalsIgnoreCase(vista.getBtnIrAtras().getActionCommand())) {
			vista.setVisible(false);
			vista.repaint();
			ControladorMain.mostrarVista();
		}
	}
		
	
}
