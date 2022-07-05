	package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import dato.Empleador;
import dato.ResultadosContrataciones;
import java.awt.FlowLayout;

public class VistaEmpleadoP extends JFrame implements MouseListener{
	
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel Tickets;
	private JPanel Principal;
	private JPanel panelExterior;
	private JPanel panelLocacion;
	private JLabel Opcion;
	private JRadioButton HomeOffice;
	private JRadioButton Presencial;
	private JRadioButton Indistinto;
	private JPanel panelRemuneracion;
	private JLabel Remuneracion;
	private JRadioButton HastaV1;
	private JRadioButton EntreV1yV2;
	private JRadioButton MasdeV2;
	private JPanel panelCargaHoraria;
	private JLabel CargaHoraria;
	private JRadioButton Media;
	private JRadioButton Completa;
	private JRadioButton Extendida;
	private JPanel panelTipoPuesto;
	private JLabel TipoPuesto;
	private JRadioButton Junior;
	private JRadioButton Senior;
	private JRadioButton Managment;
	private JPanel PanelRangoEtario;
	private JLabel RangoEtario;
	private JRadioButton menos40;
	private JRadioButton de40a50;
	private JRadioButton masde50;
	private JPanel panelExperienciaPrevia;
	private JLabel ExperienciaPrevia;
	private JRadioButton Nada;
	private JRadioButton EMedia;
	private JRadioButton Mucha;
	private JPanel panelEstudiosCursados;
	private JLabel EstudiosCursados;
	private JRadioButton Primario;
	private JRadioButton Secundario;
	private JRadioButton Terciario;
	private final ButtonGroup Locacio = new ButtonGroup();
	private final ButtonGroup Remunera = new ButtonGroup();
	private final ButtonGroup Carga_Hora = new ButtonGroup();
	private final ButtonGroup TipoPues = new ButtonGroup();
	private final ButtonGroup Rango_Etar = new ButtonGroup();
	private final ButtonGroup Experiencia = new ButtonGroup();
	private final ButtonGroup Estudios = new ButtonGroup();
	private ActionListener actionListener;
	private JPanel PanelVisualizacionRondaEncuentros;
	private JPanel PanelEleccion;
	private JPanel PanelVisulizacionResultados;
	private JButton Enviar;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JPanel panelEnviar;
	private JLabel lblEnviar;
	private JPanel panelBotonAceptar;
	private JButton btnAceptar;
	private DefaultListModel<Empleador> modelEleccion;
	private JList<Empleador> ListaEleccion;
	private DefaultListModel<Empleador> modelRonda;
	private JList<Empleador> ListaRonda;
	private JButton CerrarSesion;
	private DefaultListModel<ResultadosContrataciones> modelContrataciones;
	private JList<ResultadosContrataciones> VisualizacionContrataciones;
	private JPanel panelEstadoTicket;
	private JPanel panelSeleccionEstadoTicket;
	private JPanel panelLblSeleccion;
	private JPanel panelButtonsSeleccion;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JPanel panelAceptarEstadoTicket;
	private JButton btnAceptarEstadoTicket;
	private JLabel lblNewLabel;
	private final ButtonGroup EstadoTickets = new ButtonGroup();
	private JPanel panel;
	private JList<Integer> listPuntuacion;
	private DefaultListModel<Integer> modelPuntuaciones;

	public VistaEmpleadoP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 504);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);

		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.contentPane.add(this.tabbedPane, BorderLayout.CENTER);

		this.Principal = new JPanel();
		this.tabbedPane.addTab("Principal", null, this.Principal, null);
		this.tabbedPane.setForegroundAt(0, Color.BLACK);
		this.tabbedPane.setEnabledAt(0, true);
		this.Principal.setLayout(new GridLayout(0, 3, 0, 0));

		this.PanelVisualizacionRondaEncuentros = new JPanel();
		this.PanelVisualizacionRondaEncuentros.setBorder(new TitledBorder(null, "Visualizacion Ronda Encuentros Laborales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.Principal.add(this.PanelVisualizacionRondaEncuentros);
		this.PanelVisualizacionRondaEncuentros.setLayout(new GridLayout(0, 2, 0, 0));

		this.scrollPane = new JScrollPane();
		this.PanelVisualizacionRondaEncuentros.add(this.scrollPane);
		
		this.ListaRonda = new JList<Empleador>();
		this.ListaRonda.setBorder(new TitledBorder(null, "Empleadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.ListaRonda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollPane.setViewportView(this.ListaRonda);
		
		this.panel = new JPanel();
		this.PanelVisualizacionRondaEncuentros.add(this.panel);
		this.panel.setLayout(new BorderLayout(0, 0));
		
		this.listPuntuacion = new JList();
		this.listPuntuacion.setBorder(new TitledBorder(null, "Puntuacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel.add(this.listPuntuacion);
		
		this.panelBotonAceptar = new JPanel();
		this.PanelVisualizacionRondaEncuentros.add(this.panelBotonAceptar);
		
		this.btnAceptar = new JButton("Aceptar");
		btnAceptar.setActionCommand("aceptar");
		this.btnAceptar.addMouseListener(this);
		this.panelBotonAceptar.add(this.btnAceptar);
		
		CerrarSesion = new JButton("Cerrar Sesion");
		CerrarSesion.setActionCommand("CerrarSesion");
		panelBotonAceptar.add(CerrarSesion);

		this.PanelEleccion = new JPanel();
		this.PanelEleccion.setBorder(new TitledBorder(null, "Elecciones de la Ronda de Encuentros", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.Principal.add(this.PanelEleccion);
		this.PanelEleccion.setLayout(new BorderLayout(0, 0));

		this.scrollPane_1 = new JScrollPane();
		this.PanelEleccion.add(this.scrollPane_1, BorderLayout.CENTER);
		
		this.ListaEleccion = new JList<Empleador>();
		this.scrollPane_1.setViewportView(this.ListaEleccion);

		this.PanelVisulizacionResultados = new JPanel();
		this.PanelVisulizacionResultados.setBorder(new TitledBorder(null, "Visualizacion Resultados Contratacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.Principal.add(this.PanelVisulizacionResultados);
		this.PanelVisulizacionResultados.setLayout(new BorderLayout(0, 0));

		this.scrollPane_2 = new JScrollPane();
		this.PanelVisulizacionResultados.add(this.scrollPane_2, BorderLayout.CENTER);
		
		this.VisualizacionContrataciones = new JList<ResultadosContrataciones>();
		this.scrollPane_2.setViewportView(this.VisualizacionContrataciones);

		this.Tickets = new JPanel();
		this.tabbedPane.addTab("Tickets", null, this.Tickets, null);
		this.Tickets.setLayout(new BorderLayout(0, 0));

		this.panelExterior = new JPanel();
		this.Tickets.add(this.panelExterior);
		this.panelExterior.setLayout(new GridLayout(3, 3, 3, 0));

		this.panelLocacion = new JPanel();
		this.panelLocacion.setBorder(new TitledBorder(null, "Locacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelExterior.add(this.panelLocacion);
		this.panelLocacion.setLayout(new GridLayout(5, 1, 0, 0));

		this.Opcion = new JLabel("");
		this.panelLocacion.add(this.Opcion);

		this.HomeOffice = new JRadioButton("Home Office");
		HomeOffice.setActionCommand("0");
		this.HomeOffice.addMouseListener(this);
		Locacio.add(this.HomeOffice);
		this.panelLocacion.add(this.HomeOffice);

		this.Presencial = new JRadioButton("Presencial");
		Presencial.setActionCommand("1");
		this.Presencial.addMouseListener(this);
		Locacio.add(this.Presencial);
		this.panelLocacion.add(this.Presencial);

		this.Indistinto = new JRadioButton("Indistinto");
		Indistinto.setActionCommand("2");
		this.Indistinto.addMouseListener(this);
		Locacio.add(this.Indistinto);
		this.panelLocacion.add(this.Indistinto);

		this.panelRemuneracion = new JPanel();
		this.panelRemuneracion.setBorder(new TitledBorder(null, "Remuneracion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelExterior.add(this.panelRemuneracion);
		this.panelRemuneracion.setLayout(new GridLayout(5, 1, 0, 0));

		this.Remuneracion = new JLabel("");
		this.panelRemuneracion.add(this.Remuneracion);

		this.HastaV1 = new JRadioButton("Hasta V1");
		HastaV1.setActionCommand("0");
		this.HastaV1.addMouseListener(this);
		Remunera.add(this.HastaV1);
		this.panelRemuneracion.add(this.HastaV1);

		this.EntreV1yV2 = new JRadioButton("Entre V1 y V2");
		EntreV1yV2.setActionCommand("1");
		this.EntreV1yV2.addMouseListener(this);
		Remunera.add(this.EntreV1yV2);
		this.panelRemuneracion.add(this.EntreV1yV2);

		this.MasdeV2 = new JRadioButton("M\u00E1s de V2");
		MasdeV2.setActionCommand("2");
		this.MasdeV2.addMouseListener(this);
		Remunera.add(this.MasdeV2);
		this.panelRemuneracion.add(this.MasdeV2);

		this.panelCargaHoraria = new JPanel();
		this.panelCargaHoraria.setBorder(new TitledBorder(null, "Carga Horaria", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelExterior.add(this.panelCargaHoraria);
		this.panelCargaHoraria.setLayout(new GridLayout(5, 1, 0, 0));

		this.CargaHoraria = new JLabel("");
		this.panelCargaHoraria.add(this.CargaHoraria);

		this.Media = new JRadioButton("Media");
		Media.setActionCommand("0");
		this.Media.addMouseListener(this);
		Carga_Hora.add(this.Media);
		this.panelCargaHoraria.add(this.Media);

		this.Completa = new JRadioButton("Completa");
		Completa.setActionCommand("1");
		this.Completa.addMouseListener(this);
		Carga_Hora.add(this.Completa);
		this.panelCargaHoraria.add(this.Completa);

		this.Extendida = new JRadioButton("Extendida");
		Extendida.setActionCommand("2");
		this.Extendida.addMouseListener(this);
		Carga_Hora.add(this.Extendida);
		this.panelCargaHoraria.add(this.Extendida);

		this.panelTipoPuesto = new JPanel();
		this.panelTipoPuesto.setBorder(new TitledBorder(null, "Tipo Puesto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelExterior.add(this.panelTipoPuesto);
		this.panelTipoPuesto.setLayout(new GridLayout(5, 1, 0, 0));

		this.TipoPuesto = new JLabel("");
		this.panelTipoPuesto.add(this.TipoPuesto);

		this.Junior = new JRadioButton("Junior");
		Junior.setActionCommand("0");
		this.Junior.addMouseListener(this);
		TipoPues.add(this.Junior);
		this.panelTipoPuesto.add(this.Junior);

		this.Senior = new JRadioButton("Senior");
		Senior.setActionCommand("1");
		this.Senior.addMouseListener(this);
		TipoPues.add(this.Senior);
		this.panelTipoPuesto.add(this.Senior);

		this.Managment = new JRadioButton("Managment");
		Managment.setActionCommand("2");
		this.Managment.addMouseListener(this);
		TipoPues.add(this.Managment);
		this.panelTipoPuesto.add(this.Managment);

		this.PanelRangoEtario = new JPanel();
		this.PanelRangoEtario.setBorder(new TitledBorder(null, "Rango Etario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelExterior.add(this.PanelRangoEtario);
		this.PanelRangoEtario.setLayout(new GridLayout(5, 1, 0, 0));

		this.RangoEtario = new JLabel("");
		this.PanelRangoEtario.add(this.RangoEtario);

		this.menos40 = new JRadioButton("Menos de 40 a\u00F1os");
		menos40.setActionCommand("0");
		this.menos40.addMouseListener(this);
		Rango_Etar.add(this.menos40);
		this.PanelRangoEtario.add(this.menos40);

		this.de40a50 = new JRadioButton("40 a 50 a\u00F1os");
		de40a50.setActionCommand("1");
		this.de40a50.addMouseListener(this);
		Rango_Etar.add(this.de40a50);
		this.PanelRangoEtario.add(this.de40a50);

		this.masde50 = new JRadioButton("Mas de 50 a\u00F1os");
		masde50.setActionCommand("2");
		this.masde50.addMouseListener(this);
		Rango_Etar.add(this.masde50);
		this.PanelRangoEtario.add(this.masde50);

		this.panelExperienciaPrevia = new JPanel();
		this.panelExperienciaPrevia.setBorder(new TitledBorder(null, "Experiencia Previa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelExterior.add(this.panelExperienciaPrevia);
		this.panelExperienciaPrevia.setLayout(new GridLayout(5, 0, 0, 0));

		this.ExperienciaPrevia = new JLabel("");
		this.panelExperienciaPrevia.add(this.ExperienciaPrevia);

		this.Nada = new JRadioButton("Nada");
		Nada.setActionCommand("0");
		this.Nada.addMouseListener(this);
		Experiencia.add(this.Nada);
		this.panelExperienciaPrevia.add(this.Nada);

		this.EMedia = new JRadioButton("Media");
		EMedia.setActionCommand("1");
		this.EMedia.addMouseListener(this);
		Experiencia.add(this.EMedia);
		this.panelExperienciaPrevia.add(this.EMedia);

		this.Mucha = new JRadioButton("Mucha");
		Mucha.setActionCommand("2");
		this.Mucha.addMouseListener(this);
		Experiencia.add(this.Mucha);
		this.panelExperienciaPrevia.add(this.Mucha);

		this.panelEstudiosCursados = new JPanel();
		this.panelEstudiosCursados.setBorder(new TitledBorder(null, "Estudios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelExterior.add(this.panelEstudiosCursados);
		this.panelEstudiosCursados.setLayout(new GridLayout(5, 0, 0, 0));

		this.EstudiosCursados = new JLabel("");
		this.panelEstudiosCursados.add(this.EstudiosCursados);

		this.Primario = new JRadioButton("Primario");
		Primario.setActionCommand("0");
		this.Primario.addMouseListener(this);
		Estudios.add(this.Primario);
		this.panelEstudiosCursados.add(this.Primario);

		this.Secundario = new JRadioButton("Secundario");
		Secundario.setActionCommand("1");
		this.Secundario.addMouseListener(this);
		Estudios.add(this.Secundario);
		this.panelEstudiosCursados.add(this.Secundario);

		this.Terciario = new JRadioButton("Terciario");
		Terciario.setActionCommand("2");
		this.Terciario.addMouseListener(this);
		Estudios.add(this.Terciario);
		this.panelEstudiosCursados.add(this.Terciario);

		this.panelEnviar = new JPanel();
		this.panelExterior.add(this.panelEnviar);
		this.panelEnviar.setLayout(new GridLayout(3, 0, 0, 0));

		this.lblEnviar = new JLabel("");
		this.panelEnviar.add(this.lblEnviar);

		this.Enviar = new JButton("Enviar");
		this.panelEnviar.add(this.Enviar);
		this.Enviar.setEnabled(false);
		this.Enviar.setDefaultCapable(false);
		this.modelContrataciones = new DefaultListModel<ResultadosContrataciones>();
		this.VisualizacionContrataciones.setModel(modelContrataciones);
		this.modelRonda = new DefaultListModel<Empleador>();
		this.ListaRonda.setModel(modelRonda);
		this.modelEleccion = new DefaultListModel<Empleador>();
		this.ListaEleccion.setModel(modelEleccion);
		
		this.panelEstadoTicket = new JPanel();
		this.tabbedPane.addTab("Estado Ticket", null, this.panelEstadoTicket, null);
		this.panelEstadoTicket.setLayout(new GridLayout(2, 0, 0, 0));
		
		this.panelSeleccionEstadoTicket = new JPanel();
		this.panelSeleccionEstadoTicket.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelEstadoTicket.add(this.panelSeleccionEstadoTicket);
		this.panelSeleccionEstadoTicket.setLayout(new GridLayout(3, 0, 0, 0));
		
		this.panelLblSeleccion = new JPanel();
		this.panelSeleccionEstadoTicket.add(this.panelLblSeleccion);
		this.panelLblSeleccion.setLayout(new BorderLayout(0, 0));
		
		this.lblNewLabel = new JLabel("Seleccione un estado para el ticket:");
		this.panelLblSeleccion.add(this.lblNewLabel, BorderLayout.CENTER);
		
		this.panelButtonsSeleccion = new JPanel();
		this.panelButtonsSeleccion.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelSeleccionEstadoTicket.add(this.panelButtonsSeleccion);
		this.panelButtonsSeleccion.setLayout(new GridLayout(0, 3, 0, 0));
		
		this.rdbtnNewRadioButton = new JRadioButton("Estado Activo");
		this.rdbtnNewRadioButton.setSelected(true);
		EstadoTickets.add(this.rdbtnNewRadioButton);
		this.rdbtnNewRadioButton.setActionCommand("activo");
		this.panelButtonsSeleccion.add(this.rdbtnNewRadioButton);
		
		this.rdbtnNewRadioButton_1 = new JRadioButton("Estado Suspendido");
		EstadoTickets.add(this.rdbtnNewRadioButton_1);
		this.rdbtnNewRadioButton_1.setActionCommand("suspendido");
		this.panelButtonsSeleccion.add(this.rdbtnNewRadioButton_1);
		
		this.rdbtnNewRadioButton_2 = new JRadioButton("Estado Cancelado");
		EstadoTickets.add(this.rdbtnNewRadioButton_2);
		this.rdbtnNewRadioButton_2.setActionCommand("cancelado");
		this.panelButtonsSeleccion.add(this.rdbtnNewRadioButton_2);
		
		this.panelAceptarEstadoTicket = new JPanel();
		this.panelSeleccionEstadoTicket.add(this.panelAceptarEstadoTicket);
		this.panelAceptarEstadoTicket.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.btnAceptarEstadoTicket = new JButton("Aceptar");
		this.btnAceptarEstadoTicket.setActionCommand("AceptarEstadoTicket");
		this.panelAceptarEstadoTicket.add(this.btnAceptarEstadoTicket);
		this.modelPuntuaciones = new DefaultListModel<Integer>();
		this.listPuntuacion.setModel(modelPuntuaciones);
		this.setVisible(true);
	}

	

	public void setactionlistener(ActionListener action) {
		this.Enviar.addActionListener(action);
		this.CerrarSesion.addActionListener(action);
		this.btnAceptar.addActionListener(action);
		this.btnAceptarEstadoTicket.addActionListener(action);
		this.actionListener = action;
	}

	public void deshabilitarBotonEnviar() {
		this.Enviar.setEnabled(false);
	}

	public ButtonGroup getLocacio() {
		return Locacio;
	}

	public ButtonGroup getRemunera() {
		return Remunera;
	}

	public ButtonGroup getCarga_Hora() {
		return Carga_Hora;
	}

	public ButtonGroup getTipoPues() {
		return TipoPues;
	}

	public ButtonGroup getRango_Etar() {
		return Rango_Etar;
	}

	public ButtonGroup getExperiencia() {
		return Experiencia;
	}

	public ButtonGroup getEstudios() {
		return Estudios;
	}

	

	public ButtonGroup getEstadoTickets() {
		return EstadoTickets;
	}



	public JButton getBtnAceptarEstadoTicket() {
		return btnAceptarEstadoTicket;
	}



	public JButton getBtnAceptar() {
		return btnAceptar;
	}
	
	public DefaultListModel<Empleador> getModelEleccion() {
		return modelEleccion;
	}

	public JList<Empleador> getListaEleccion() {
		return ListaEleccion;
	}
	

	public DefaultListModel<Empleador> getModelRonda() {
		return modelRonda;
	}

	public JList<Empleador> getListaRonda() {
		return ListaRonda;
	}

	public DefaultListModel<ResultadosContrataciones> getModelContrataciones() {
		return modelContrataciones;
	}
	
	public JList<ResultadosContrataciones> getVisualizacionContrataciones() {
		return VisualizacionContrataciones;
	}



	public DefaultListModel<Integer> getModelPuntuaciones() {
		return modelPuntuaciones;
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		
		/*this.getModelEleccion().addAll(this.getListaRonda().getSelectedValuesList());
		this.getListaEleccion().setModel(modelEleccion);

		for(int i=0; i<this.getListaRonda().getSelectedValuesList().size();i++)
			this.getModelRonda().removeElement(this.getListaRonda().getSelectedValuesList().get(i));
		this.getListaRonda().setModel(modelRonda);
		*/
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		boolean condicion = getLocacio().getSelection()!=null &&
				getRemunera().getSelection()!=null && 
				getCarga_Hora().getSelection()!=null &&
				getTipoPues().getSelection()!=null &&
				getRango_Etar().getSelection()!=null&&
				getExperiencia().getSelection()!=null &&
				getEstudios().getSelection()!=null;

		this.Enviar.setEnabled(condicion);

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

