package vista;

import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.border.EmptyBorder;

public class VentanaRegistroEmpleador extends JFrame implements KeyListener,MouseListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textFieldUSUARIO;
	private JLabel lblNewLabel_1;
	private JPasswordField passwordFieldCONTRA;
	private JLabel lblNewLabel_2;
	private JTextField textField_1RAZON;
	private JLabel lblNewLabel_3;
	private JPanel panel;
	private JRadioButton Botonpersfisica;
	private JRadioButton Botonpersjuridica;
	private final ButtonGroup Tipopersonabuttons = new ButtonGroup();
	private JLabel lblNewLabel_4;
	private JPanel panel_1;
	private JRadioButton Rubrosalud;
	private JRadioButton Rubrocomlocal;
	private JRadioButton Rubrocominter;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_13;
	private JPanel panel_14;
	private final ButtonGroup Rubrogrupobutton = new ButtonGroup();
	private JButton botonregistrar;
	private JPanel panel_15;
	private JPanel panel_16;
	private ActionListener actionlistener;
	private JButton btnIrAtras;

	
	
	public VentanaRegistroEmpleador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		panel_9 = new JPanel();
		contentPane.add(panel_9);
		
		lblNewLabel = new JLabel("Nombre de usuario");
		panel_9.add(lblNewLabel);
		
		panel_8 = new JPanel();
		contentPane.add(panel_8);
		
		textFieldUSUARIO = new JTextField();
		this.textFieldUSUARIO.addKeyListener(this);
		panel_8.add(textFieldUSUARIO);
		textFieldUSUARIO.setColumns(10);
		
		panel_10 = new JPanel();
		contentPane.add(panel_10);
		
		lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		panel_10.add(lblNewLabel_1);
		
		panel_7 = new JPanel();
		contentPane.add(panel_7);
		
		passwordFieldCONTRA = new JPasswordField();
		this.passwordFieldCONTRA.addKeyListener(this);
		passwordFieldCONTRA.setColumns(10);
		panel_7.add(passwordFieldCONTRA);
		
		panel_5 = new JPanel();
		contentPane.add(panel_5);
		
		lblNewLabel_2 = new JLabel("Nombre / Razon social");
		panel_5.add(lblNewLabel_2);
		
		panel_6 = new JPanel();
		contentPane.add(panel_6);
		
		textField_1RAZON = new JTextField();
		this.textField_1RAZON.addKeyListener(this);
		panel_6.add(textField_1RAZON);
		textField_1RAZON.setColumns(10);
		
		panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		lblNewLabel_3 = new JLabel("Tipo de persona");
		panel_4.add(lblNewLabel_3);
		
		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		panel_3 = new JPanel();
		panel.add(panel_3);
		
		Botonpersfisica = new JRadioButton("Fisica");
		this.Botonpersfisica.addMouseListener(this);
		Botonpersfisica.setActionCommand("FISICA");
		panel_3.add(Botonpersfisica);
		Tipopersonabuttons.add(Botonpersfisica);
		
		panel_2 = new JPanel();
		panel.add(panel_2);
		
		Botonpersjuridica = new JRadioButton("Juridica");
		this.Botonpersjuridica.addMouseListener(this);
		Botonpersjuridica.setActionCommand("JURIDICA");
		panel_2.add(Botonpersjuridica);
		Tipopersonabuttons.add(Botonpersjuridica);
		
		panel_11 = new JPanel();
		contentPane.add(panel_11);
		
		lblNewLabel_4 = new JLabel("Rubro");
		panel_11.add(lblNewLabel_4);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		
		panel_12 = new JPanel();
		panel_1.add(panel_12);
		
		Rubrosalud = new JRadioButton("Salud");
		this.Rubrosalud.addMouseListener(this);
		Rubrosalud.setActionCommand("salud");
		Rubrosalud.setFont(new Font("Tahoma", Font.PLAIN, 9));
		Rubrogrupobutton.add(Rubrosalud);
		panel_12.add(Rubrosalud);
		
		panel_13 = new JPanel();
		panel_1.add(panel_13);
		
		Rubrocomlocal = new JRadioButton("Comercio local");
		this.Rubrocomlocal.addMouseListener(this);
		Rubrocomlocal.setActionCommand("comerciolocal");
		Rubrocomlocal.setFont(new Font("Tahoma", Font.PLAIN, 9));
		Rubrogrupobutton.add(Rubrocomlocal);
		panel_13.add(Rubrocomlocal);
		
		panel_14 = new JPanel();
		panel_1.add(panel_14);
		
		Rubrocominter = new JRadioButton("Comercio intern.");
		this.Rubrocominter.addMouseListener(this);
		Rubrocominter.setActionCommand("comerciointer");
		Rubrocominter.setFont(new Font("Tahoma", Font.PLAIN, 9));
		Rubrogrupobutton.add(Rubrocominter);
		panel_14.add(Rubrocominter);
		
		panel_15 = new JPanel();
		contentPane.add(panel_15);
		
		this.btnIrAtras = new JButton("Ir Atras");
		this.panel_15.add(this.btnIrAtras);
		
		panel_16 = new JPanel();
		contentPane.add(panel_16);
		
		botonregistrar = new JButton("Registrar");
		this.panel_16.add(this.botonregistrar);
		botonregistrar.setActionCommand("registrar");
		botonregistrar.setEnabled(false);
		
		this.setVisible(true);
	}
 
	
	
	public void setactionlistener(ActionListener action) {
		//acciones a botones
	    this.botonregistrar.addActionListener(action);
	    this.btnIrAtras.addActionListener(action);
		this.actionlistener = action;
	}
	
	
	public String getTextFieldUSUARIO() {
		return textFieldUSUARIO.getText();
	}



	public String getPasswordFieldCONTRA() {
		return passwordFieldCONTRA.getText();
	}



	public String getTextField_1RAZON() {
		return textField_1RAZON.getText();
	}


   public String getrubro() {
	
	   
	   return this.Rubrogrupobutton.getSelection().getActionCommand();
   }
	
	
	public String gettipopers() {
		return this.Tipopersonabuttons.getSelection().getActionCommand();
	}

	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) 
	{
		boolean condicion = this.Rubrogrupobutton.getSelection()!=null &&
							this.Tipopersonabuttons.getSelection()!=null &&
							!this.getTextFieldUSUARIO().isBlank() &&
							!this.getPasswordFieldCONTRA().isBlank() &&
							!this.getTextField_1RAZON().isBlank();
		
		this.botonregistrar.setEnabled(condicion);
	}
	public void keyTyped(KeyEvent e) {
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		boolean condicion = this.Rubrogrupobutton.getSelection()!=null &&
				this.Tipopersonabuttons.getSelection()!=null &&
				!this.getTextFieldUSUARIO().isBlank() &&
				!this.getPasswordFieldCONTRA().isBlank() &&
				!this.getTextField_1RAZON().isBlank();

               this.botonregistrar.setEnabled(condicion); 
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
	
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
