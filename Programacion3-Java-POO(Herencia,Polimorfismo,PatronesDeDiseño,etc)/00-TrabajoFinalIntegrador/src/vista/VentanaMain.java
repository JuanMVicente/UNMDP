package vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaMain extends JFrame implements KeyListener,MouseListener {

	private JPanel contentPane;
	private JLabel TituloVentana;
	private JRadioButton Admin;
	private JRadioButton Empleador;
	private JRadioButton Empleado;
	private JButton Registrarse;
	private JButton Login;
	private ActionListener actionlistener;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldusuariolog;
	private JLabel labelUsuario;
	private JPasswordField fieldPassword;
	private JLabel labelPassword;
	private JLabel TipoUsuario;
	private JPanel panel;
	private JButton Simulacion;


	
	public VentanaMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 338);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(232767, 232767));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TituloVentana = new JLabel("Registrarse / Login");
		TituloVentana.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TituloVentana.setVerticalAlignment(SwingConstants.BOTTOM);
		TituloVentana.setBounds(130, 0, 182, 32);
		contentPane.add(TituloVentana);
		
		this.panel = new JPanel();
		this.panel.setBounds(23, 73, 371, 23);
		this.contentPane.add(this.panel);
		this.panel.setLayout(null);
		
		Admin = new JRadioButton("Administrador");
		this.Admin.setBounds(0, 0, 109, 23);
		this.panel.add(this.Admin);
		Admin.setActionCommand("ADMINISTRADOR");
		buttonGroup.add(Admin);
		

		Empleador = new JRadioButton("Empleador");
		this.Empleador.setBounds(127, 0, 109, 23);
		this.panel.add(this.Empleador);
		Empleador.setActionCommand("EMPLEADOR");
		buttonGroup.add(Empleador);
		
		Empleado = new JRadioButton("Empleado");
		this.Empleado.setBounds(262, 0, 109, 23);
		this.panel.add(this.Empleado);
		Empleado.setActionCommand("empleado");
		buttonGroup.add(Empleado);
		
		
		this.Empleado.addMouseListener(this);
		this.Empleador.addMouseListener(this);
		this.Admin.addMouseListener(this);
		
		
		Registrarse = new JButton("ir a Registrarse");
		Registrarse.setActionCommand("REGISTRARSE");
		Registrarse.setBounds(51, 213, 128, 23);
		contentPane.add(Registrarse);
		
		Login = new JButton("Login");
		this.Login.setActionCommand("LOGIN");
		Login.setBounds(277, 213, 99, 23);
		contentPane.add(Login);
		
		textFieldusuariolog = new JTextField();
		textFieldusuariolog.setBounds(332, 145, 86, 20);
		contentPane.add(textFieldusuariolog);
		textFieldusuariolog.setColumns(10);
		
		labelUsuario = new JLabel("Usuario");
		labelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelUsuario.setBounds(246, 148, 69, 17);
		contentPane.add(labelUsuario);
		
		fieldPassword = new JPasswordField();
		fieldPassword.setBounds(332, 176, 86, 20);
		contentPane.add(fieldPassword);
		
		labelPassword = new JLabel("Contrase\u00F1a");
		labelPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelPassword.setBounds(234, 176, 81, 14);
		contentPane.add(labelPassword);
		
		TipoUsuario = new JLabel("Seleccione el tipo de usuario: ");
		TipoUsuario.setBounds(23, 52, 409, 14);
		contentPane.add(TipoUsuario);
		this.Registrarse.setEnabled(false);
		this.Login.setEnabled(false);
		
		Simulacion = new JButton("Simulacion");
		Simulacion.setBounds(143, 276, 169, 23);
		contentPane.add(Simulacion);
		this.textFieldusuariolog.addKeyListener(this);
		this.fieldPassword.addKeyListener(this);
		
		
		this.setVisible(true);
	}
	
	
   public String tipo() {
		
		return this.buttonGroup.getSelection().getActionCommand();
	}
	
   public void setactionlistener(ActionListener action) {
		this.Registrarse.addActionListener(action);
		this.Login.addActionListener(action);
		this.Simulacion.addActionListener(action);
		this.actionlistener = action;
	}

   
   public String getTextFieldusuariolog() {
	return textFieldusuariolog.getText();
   }


	public String getPasswordFieldcontralog() {
	return fieldPassword.getText();
	}

	public String getRadioButtonSelected() {
		return this.buttonGroup.getSelection().getActionCommand();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		

		boolean condicionlog = (this.buttonGroup.getSelection() != null) && (!this.getTextFieldusuariolog().isBlank()) && (!this.getPasswordFieldcontralog().isBlank());
		
		this.Login.setEnabled(condicionlog);
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		boolean condicionreg = this.buttonGroup.getSelection() != null;
		
		this.Registrarse.setEnabled(condicionreg);
		
       boolean condicionlog = (this.buttonGroup.getSelection() != null) && (!this.getTextFieldusuariolog().isBlank()) && (!this.getPasswordFieldcontralog().isBlank());
		
		this.Login.setEnabled(condicionlog);
		
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
