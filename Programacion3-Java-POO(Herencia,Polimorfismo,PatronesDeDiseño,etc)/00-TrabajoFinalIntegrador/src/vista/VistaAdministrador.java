package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import dato.EmpleadoPretenso;
import dato.Empleador;
import dato.TicketEmpleado;
import dato.TicketEmpleador;
import negocio.Sistema;

public class VistaAdministrador extends JFrame {

	private JPanel contentPane;
	private JPanel panel_1;
	private JButton Rondaencuentros;
	private JButton Contrataciones;
	private ActionListener actionlistener;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel TicketsEmpleados;
	private JPanel TicketsEmpleadores;
	private DefaultListModel<EmpleadoPretenso> contenidoempleados = new DefaultListModel<EmpleadoPretenso>();
	private DefaultListModel<Empleador> contenidoempleadores = new DefaultListModel<Empleador>();
	private DefaultListModel<TicketEmpleador> ContenidoticketsEmpleadores = new DefaultListModel<TicketEmpleador>();
	private DefaultListModel<TicketEmpleado> ContenidoTicketsPretensos = new DefaultListModel<TicketEmpleado>();
	private JButton Cerrarsesion;
	private JScrollPane scrollPane;
	private JList<TicketEmpleador> ListaticketEmpleador;
	private JScrollPane scrollPane_1;
	private JList<TicketEmpleado> ListaticketEmpleado;
	private JScrollPane scrollPane_2;
	private JList<Empleador> ListaEmpleadores;
	private JScrollPane scrollPane_3;
	private JList<EmpleadoPretenso> ListaEmpleados;
	
	


	public VistaAdministrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		Rondaencuentros = new JButton("Generar ronda de encuentros");
		Rondaencuentros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		Cerrarsesion = new JButton("Cerrar sesion");
		panel_1.add(Cerrarsesion);
		panel_1.add(Rondaencuentros);
		
		Contrataciones = new JButton("Generar ronda de contrataciones");
		panel_1.add(Contrataciones);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 0, 0, 0));
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Empleados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		scrollPane_3 = new JScrollPane();
		panel_2.add(scrollPane_3, BorderLayout.CENTER);
		
		ListaEmpleados = new JList<EmpleadoPretenso>();
		scrollPane_3.setViewportView(ListaEmpleados);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Empleadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		scrollPane_2 = new JScrollPane();
		panel_3.add(scrollPane_2, BorderLayout.CENTER);
		
		ListaEmpleadores = new JList<Empleador>();
		scrollPane_2.setViewportView(ListaEmpleadores);
		
		TicketsEmpleados = new JPanel();
		TicketsEmpleados.setBorder(new TitledBorder(null, "Tickets Empleados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(TicketsEmpleados);
		TicketsEmpleados.setLayout(new BorderLayout(0, 0));
		
		scrollPane_1 = new JScrollPane();
		TicketsEmpleados.add(scrollPane_1, BorderLayout.CENTER);
		
		ListaticketEmpleado = new JList<TicketEmpleado>();
		scrollPane_1.setViewportView(ListaticketEmpleado);
		
		TicketsEmpleadores = new JPanel();
		TicketsEmpleadores.setBorder(new TitledBorder(null, "Tickets Empleadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(TicketsEmpleadores);
		TicketsEmpleadores.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		TicketsEmpleadores.add(scrollPane, BorderLayout.CENTER);
		
		ListaticketEmpleador = new JList<TicketEmpleador>();
		scrollPane.setViewportView(ListaticketEmpleador);
		
		
		
		this.ListaticketEmpleador.setModel(ContenidoticketsEmpleadores);
		this.ListaEmpleados.setModel(contenidoempleados);
		this.ListaticketEmpleado.setModel(ContenidoTicketsPretensos);
		this.ListaEmpleadores.setModel(contenidoempleadores);
		
		
		
	
		this.Contrataciones.setEnabled(false);
		this.setVisible(true);
		
	}
	
	
	public void setactionlistener(ActionListener action) {
		//acciones a botones
	    this.Rondaencuentros.addActionListener(action);
	    this.Contrataciones.addActionListener(action);
	    this.Cerrarsesion.addActionListener(action);
		this.actionlistener = action;
	}
	
	public void actualizarvista() {
		
		this.contenidoempleados.clear();
		this.contenidoempleadores.clear();
		this.ContenidoticketsEmpleadores.clear();
		this.ContenidoTicketsPretensos.clear();
		
		for(int i=0; i<Sistema.getInstance().getEmpleados().size(); i++)
			this.contenidoempleados.addElement(Sistema.getInstance().getEmpleados().get(i));
		
		for(int i=0; i<Sistema.getInstance().getEmpleadores().size(); i++)
			this.contenidoempleadores.addElement(Sistema.getInstance().getEmpleadores().get(i));
			
		for (int i=0; i<Sistema.getInstance().getTicketEmpleadores().size(); i++)
			if(Sistema.getInstance().getTicketEmpleadores().get(i).getEstado().equalsIgnoreCase("activo"))
			this.ContenidoticketsEmpleadores.addElement(Sistema.getInstance().getTicketEmpleadores().get(i));
				
		for(int i=0; i<Sistema.getInstance().getTicketsEmpleados().size(); i++)
			 if(Sistema.getInstance().getTicketsEmpleados().get(i).getEstado().equalsIgnoreCase("activo"))
			this.ContenidoTicketsPretensos.addElement(Sistema.getInstance().getTicketsEmpleados().get(i));
		
		if(!Sistema.getInstance().isBotonRondas()) 
		{
			this.Rondaencuentros.setEnabled(false);
			this.Contrataciones.setEnabled(true);
		}
	}

	public JButton getRondaencuentros() {
		return Rondaencuentros;
	}


	public JButton getContrataciones() {
		return Contrataciones;
	}

}
