package vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class VentanaRegistroEmpleado extends JFrame implements KeyListener {

	private JPanel contentPane;
	private ActionListener actionlistener;
	private JLabel lblNewLabel;
	private JTextField textFieldUSUARIO;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPasswordField passwordField;
	private JTextField textFieldNOMBRE;
	private JLabel lblNewLabel_3;
	private JTextField textFieldTELEFONO;
	private JLabel lblNewLabel_4;
	private JTextField textFieldFECHA;
	private JLabel lblNewLabel_5;
	private JTextField textFieldDNI;
	private JPanel panelUsuario;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel Nombre_Apellido;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JButton Registrarse;
	private JPanel panel_13;
	private JPanel panelIrAtras;
	private JButton btnIrAtras;
	

	public VentanaRegistroEmpleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		panelUsuario = new JPanel();
		contentPane.add(panelUsuario);
		
		
		lblNewLabel = new JLabel("Nombre usuario");
		panelUsuario.add(lblNewLabel);
		
		panel_11 = new JPanel();
		contentPane.add(panel_11);
		
		textFieldUSUARIO = new JTextField();
		this.textFieldUSUARIO.addKeyListener(this);
		panel_11.add(textFieldUSUARIO);
		textFieldUSUARIO.setColumns(10);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		panel_1.add(lblNewLabel_1);
		
		panel_10 = new JPanel();
		contentPane.add(panel_10);
		
		passwordField = new JPasswordField();
		this.passwordField.addKeyListener(this);
		passwordField.setColumns(10);
		panel_10.add(passwordField);
		
		panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		lblNewLabel_2 = new JLabel("Nombre y apellido");
		panel_2.add(lblNewLabel_2);
		
		Nombre_Apellido = new JPanel();
		contentPane.add(Nombre_Apellido);
		
		textFieldNOMBRE = new JTextField();
		this.textFieldNOMBRE.addKeyListener(this);
		Nombre_Apellido.add(textFieldNOMBRE);
		textFieldNOMBRE.setColumns(10);
		
		panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		lblNewLabel_3 = new JLabel("Telefono");
		panel_3.add(lblNewLabel_3);
		
		panel_8 = new JPanel();
		contentPane.add(panel_8);
		
		textFieldTELEFONO = new JTextField();
		this.textFieldTELEFONO.addKeyListener(this);
		panel_8.add(textFieldTELEFONO);
		textFieldTELEFONO.setColumns(10);
		
		panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		lblNewLabel_4 = new JLabel("Fecha nacimiento");
		panel_4.add(lblNewLabel_4);
		
		panel_7 = new JPanel();
		contentPane.add(panel_7);
		
		textFieldFECHA = new JTextField();
		this.textFieldFECHA.addKeyListener(this);
		panel_7.add(textFieldFECHA);
		textFieldFECHA.setColumns(10);
		
		panel_5 = new JPanel();
		contentPane.add(panel_5);
		
		lblNewLabel_5 = new JLabel("DNI");
		panel_5.add(lblNewLabel_5);
		
		panel_6 = new JPanel();
		contentPane.add(panel_6);
		
		textFieldDNI = new JTextField();
		this.textFieldDNI.addKeyListener(this);
		panel_6.add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		panel_13 = new JPanel();
		contentPane.add(panel_13);
		this.panel_13.setLayout(new BorderLayout(0, 0));
		
		panel_12 = new JPanel();
		panel_13.add(panel_12);
		
		Registrarse = new JButton("Registrarse");
		panel_12.add(Registrarse);
		
		
		this.Registrarse.setEnabled(false);
		
		this.panelIrAtras = new JPanel();
		this.contentPane.add(this.panelIrAtras);
		this.panelIrAtras.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.btnIrAtras = new JButton("Ir Atras");
		this.panelIrAtras.add(this.btnIrAtras);
		this.setVisible(true);
	}
	
	
	 public void setactionlistener(ActionListener action) {
			//acciones a botones
			this.Registrarse.addActionListener(action);
			this.btnIrAtras.addActionListener(action);
			this.actionlistener = action;
		}


	public String getTextFieldUSUARIO() {
		return textFieldUSUARIO.getText();
	}


	public String getPasswordField() {
		return passwordField.getText();
	}


	public String getTextFieldNOMBRE() {
		return textFieldNOMBRE.getText();
	}


	public String getTextFieldTELEFONO() {
		return textFieldTELEFONO.getText();
	}


	public String getTextFieldFECHA() {
		return textFieldFECHA.getText();
	}


	public String getTextFieldDNI() {
		return textFieldDNI.getText();
	}


	public JButton getBtnIrAtras() {
		return btnIrAtras;
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

		boolean condicionRegistro = (!this.getTextFieldUSUARIO().isBlank()) && (!this.getPasswordField().isBlank()) && (!this.getTextFieldNOMBRE().isBlank()) &&
									(!this.getTextFieldTELEFONO().isBlank())&&
									(!this.getTextFieldFECHA().isBlank())&&
									(!this.getTextFieldDNI().isBlank());
		
		this.Registrarse.setEnabled(condicionRegistro);
	
	}

	 
}
