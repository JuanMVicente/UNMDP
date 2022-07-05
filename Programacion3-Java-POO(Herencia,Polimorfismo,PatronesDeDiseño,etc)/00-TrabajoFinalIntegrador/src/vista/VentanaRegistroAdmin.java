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

public class VentanaRegistroAdmin extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ActionListener actionlistener;
	private JLabel lblNewLabel;
	private JTextField textFieldUSUARIO;
	private JLabel lblNewLabel_1;
	private JPasswordField passwordFieldCONTRASENIA;
	private JLabel lblNewLabel_2;
	private JTextField textField_1NOMBRE;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JButton Registrar;
	private JPanel panel_7;
	private JButton btnIrAtras;


	public VentanaRegistroAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		panel = new JPanel();
		contentPane.add(panel);
		
		lblNewLabel = new JLabel("Nombre de usuario");
		panel.add(lblNewLabel);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		textFieldUSUARIO = new JTextField();
		panel_1.add(textFieldUSUARIO);
		textFieldUSUARIO.setColumns(15);
		
		
		panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		panel_2.add(lblNewLabel_1);
		
		panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		passwordFieldCONTRASENIA = new JPasswordField();
		passwordFieldCONTRASENIA.setColumns(15);
		panel_3.add(passwordFieldCONTRASENIA);
		
		panel_5 = new JPanel();
		contentPane.add(panel_5);
		
		lblNewLabel_2 = new JLabel("Nombre");
		panel_5.add(lblNewLabel_2);
		
		panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		textField_1NOMBRE = new JTextField();
		panel_4.add(textField_1NOMBRE);
		textField_1NOMBRE.setColumns(15);
		
		panel_6 = new JPanel();
		contentPane.add(panel_6);
		
		Registrar = new JButton("Registrar");
		Registrar.setActionCommand("registrar");
		panel_6.add(Registrar);
		
		
		this.textField_1NOMBRE.addKeyListener(this);
		this.textFieldUSUARIO.addKeyListener(this);
		this.passwordFieldCONTRASENIA.addKeyListener(this);
		
		this.Registrar.setEnabled(false);
		
		this.panel_7 = new JPanel();
		this.contentPane.add(this.panel_7);
		
		this.btnIrAtras = new JButton("Ir Atras");
		this.panel_7.add(this.btnIrAtras);
		this.setVisible(true);
		
	}
	
	
	public String getTextFieldUSUARIO() {
		return textFieldUSUARIO.getText();
	}



	public String getPasswordFieldCONTRASENIA() {
		return passwordFieldCONTRASENIA.getText();
	}


	public String getTextField_1NOMBRE() {
		return textField_1NOMBRE.getText();
	}


	public void setactionlistener(ActionListener action) {
		//acciones a botones
	    this.Registrar.addActionListener(action);
	    this.btnIrAtras.addActionListener(action);
		this.actionlistener = action;
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
		
		boolean condicion = (!this.textField_1NOMBRE.getText().isBlank()) && (!this.passwordFieldCONTRASENIA.getText().isBlank()) &&(!this.textFieldUSUARIO.getText().isBlank());
		
		this.Registrar.setEnabled(condicion);
		
	}
	
	

}
