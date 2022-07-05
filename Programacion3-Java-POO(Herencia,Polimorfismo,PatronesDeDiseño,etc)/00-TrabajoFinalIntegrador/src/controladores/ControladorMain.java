package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dato.Usuario;
import negocio.Sistema;
import presentacion.PruebaThreads;
import vista.VentanaMain;

public class ControladorMain implements ActionListener {
	private static VentanaMain vista;
	
	public ControladorMain() {	
		vista = new VentanaMain();
		vista.setactionlistener(this);
	}	
	
	public static void mostrarVista() {
		vista.setVisible(true);
	}
	
	public static void ocultarVista() {
		vista.setVisible(false);
	}

	public void setVista(VentanaMain v) 
	{
		vista = v;
		vista.setactionlistener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
			

		
		if(e.getActionCommand().equalsIgnoreCase("REGISTRARSE")) 
		{
			if(vista.tipo().equalsIgnoreCase("ADMINISTRADOR")) 
			{
				vista.setVisible(false);
				Controladorbase.ventanregistroadmin();
			}
			else
				if(vista.tipo().equalsIgnoreCase("EMPLEADOR")) 
				{
					vista.setVisible(false);
					Controladorbase.ventanaregistroempleador();
				}
				else
					if(vista.tipo().equalsIgnoreCase("EMPLEADO")) 
					{
						vista.setVisible(false);
						Controladorbase.ventanaregistroempleado();
					}
		}

		else
			if(e.getActionCommand().equalsIgnoreCase("LOGIN")) 
			{
				Usuario usuario = null;

				if(vista.tipo().equalsIgnoreCase("ADMINISTRADOR"))
					try 
					{
						usuario	= Sistema.getInstance().login(vista.getTextFieldusuariolog(),vista.getPasswordFieldcontralog(),vista.tipo());
					} 
					catch (Exception e1) 
					{
						JOptionPane.showMessageDialog(null,e1.getMessage(),null, JOptionPane.INFORMATION_MESSAGE); 
					}
				else if(vista.tipo().equalsIgnoreCase("EMPLEADOR"))
					try 
					{
						usuario =	Sistema.getInstance().login(vista.getTextFieldusuariolog(),vista.getPasswordFieldcontralog(),vista.tipo());
					} 
					catch (Exception e1) 
					{
						JOptionPane.showMessageDialog(null,e1.getMessage(),null, JOptionPane.INFORMATION_MESSAGE); 
					}	
				if(vista.tipo().equalsIgnoreCase("EMPLEADO"))
					try 
					{
						usuario = Sistema.getInstance().login(vista.getTextFieldusuariolog(),vista.getPasswordFieldcontralog(),vista.tipo());
					} 
					catch (Exception e1) 
					{
						JOptionPane.showMessageDialog(null,e1.getMessage(),null, JOptionPane.INFORMATION_MESSAGE); 
					}
				//se loguea, si se loguea ok, paso a mostrar ventana con las funciones del usuario.


				if(usuario!=null) {
					vista.setVisible(false);

					if(vista.tipo().equalsIgnoreCase("EMPLEADO")) {
						Controladorbase.ventanafuncionesempleadop(usuario);
					}
					else
						if(vista.tipo().equalsIgnoreCase("EMPLEADOR"))	{
							Controladorbase.ventanaFuncionesEmpleador(usuario);
						}
						else
							if(vista.tipo().equalsIgnoreCase("ADMINISTRADOR")) {
								Controladorbase.ventanaFuncionesAdministrador();
							}


				}
			}
			else
			if(e.getActionCommand().equalsIgnoreCase("Simulacion")){
				vista.setVisible(false);
				Controladorbase.VentanaSimulacion();
				PruebaThreads.PruebaConcurrencia();
			}

	}

}
