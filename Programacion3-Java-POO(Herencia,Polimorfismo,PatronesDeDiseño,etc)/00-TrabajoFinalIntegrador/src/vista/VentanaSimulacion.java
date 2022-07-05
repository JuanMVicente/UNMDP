package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dato.TicketEmpleado;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;

public class VentanaSimulacion extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private DefaultListModel<String> contenidolista = new DefaultListModel<String>();
	private JScrollPane scrollPane;
	private JList list;
	private JPanel panel_1;
	private JButton terminar;
	private JButton btnIrAtras;
	private JLabel lblNewLabel;
	

	
		
	

	public VentanaSimulacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 697);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		list = new JList();
		scrollPane.setViewportView(list);
		this.setVisible(true);
		
		list.setModel(contenidolista);
		
		this.panel_1 = new JPanel();
		this.contentPane.add(this.panel_1, BorderLayout.SOUTH);
		this.panel_1.setLayout(new GridLayout(3, 1, 0, 0));
		
		this.terminar = new JButton("Terminar");
		this.terminar.setActionCommand("terminar");
		this.panel_1.add(this.terminar);
		
		this.lblNewLabel = new JLabel("");
		this.panel_1.add(this.lblNewLabel);
		
		this.btnIrAtras = new JButton("Ir Atras");
		this.panel_1.add(this.btnIrAtras);
		
		
	}
	
	
	
	public DefaultListModel<String> getContenidolista() {
		return contenidolista;
	}



	public void setContenidolista(DefaultListModel<String> contenidolista) {
		this.contenidolista = contenidolista;
	}

	

	public JButton getBtnIrAtras() {
		return btnIrAtras;
	}



	public void setactionlistener(ActionListener action) {
			this.terminar.addActionListener(action);
			this.btnIrAtras.addActionListener(action);
	}



	public JButton getTerminar() {
		return terminar;
	}
	
	

}
