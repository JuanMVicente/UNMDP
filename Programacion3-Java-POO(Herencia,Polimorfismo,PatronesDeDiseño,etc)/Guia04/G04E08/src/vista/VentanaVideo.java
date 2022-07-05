package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import modelo.Mapa;
import modelo.Personaje;
import modelo.PersonajeFactory;
import modelo.Posicion;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class VentanaVideo extends JFrame implements ActionListener, ListSelectionListener
{

    private JPanel contentPane;
    private JPanel panelCentral;
    private JPanel panelSur;
    private JPanel panelColumna_1;
    private JPanel panelColumna_2;
    private JPanel panelColumna_3;
    private JScrollPane scrollPane;
    private JList<Personaje> list_1;
    private JScrollPane scrollPane_1;
    private JList<Personaje> list_2;
    private JPanel panelCrearPersonaje;
    private JPanel panelAcciones;
    private JPanel panelSeleccionTipo;
    private JPanel panelParametrosConstructor;
    private JLabel lblNewLabel;
    private JTextField textFieldNombre;
    private JLabel lblX;
    private JTextField textField_X;
    private JLabel lblY;
    private JTextField textField_Y;
    private JLabel lblNewLabel_3;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_3;
    private JPanel panel_4;
    private JPanel panel_5;
    private JButton btnAgregar;
    private JRadioButton rdbtnGuerrero;
    private JRadioButton rdbtnCaballero;
    private JRadioButton rdbtnArquero;
    private JPanel panelParametrosConstructor_1;
    private JPanel panel_8;
    private JLabel lblX_1;
    private JPanel panel_9;
    private JTextField textField_X_Mover;
    private JPanel panel_10;
    private JLabel lblY_1;
    private JPanel panel_11;
    private JTextField textField_Y_Mover;
    private JLabel lblNewLabel_2;
    private JButton btnMover;
    private JTextArea textArea_Detalles;
    private JScrollPane scrollPane_2;
    private JButton btnAtacar;
    private JButton btnEliminar;
    private JScrollPane scrollPane_3;
    private JTextArea textArea_Log;
    private DefaultListModel<Personaje> modeloLista;
    private Mapa mapa = new Mapa();
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JPanel panel_6;
    private JPanel panel_7;

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
	EventQueue.invokeLater(new Runnable()
	{
	    public void run()
	    {
		try
		{
		    VentanaVideo frame = new VentanaVideo();
		    frame.setVisible(true);
		} catch (Exception e)
		{
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public VentanaVideo()
    {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 720, 605);
	this.contentPane = new JPanel();
	this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(this.contentPane);
	this.contentPane.setLayout(new BorderLayout(0, 0));

	this.panelCentral = new JPanel();
	this.contentPane.add(this.panelCentral, BorderLayout.CENTER);
	this.panelCentral.setLayout(new GridLayout(0, 3, 0, 0));

	this.panelColumna_1 = new JPanel();
	this.panelCentral.add(this.panelColumna_1);
	this.panelColumna_1.setLayout(new BorderLayout(0, 0));

	this.scrollPane = new JScrollPane();
	this.panelColumna_1.add(this.scrollPane, BorderLayout.CENTER);

	this.list_1 = new JList<Personaje>();
	this.list_1.addListSelectionListener(this);
	this.scrollPane.setViewportView(this.list_1);

	this.panelColumna_2 = new JPanel();
	this.panelCentral.add(this.panelColumna_2);
	this.panelColumna_2.setLayout(new GridLayout(2, 0, 0, 0));

	this.panelCrearPersonaje = new JPanel();
	this.panelCrearPersonaje.setBorder(
		new TitledBorder(null, "CrearPersonaje", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	this.panelCrearPersonaje.setBackground(Color.GREEN);
	this.panelColumna_2.add(this.panelCrearPersonaje);
	this.panelCrearPersonaje.setLayout(new GridLayout(2, 0, 0, 0));

	this.panelSeleccionTipo = new JPanel();
	this.panelCrearPersonaje.add(this.panelSeleccionTipo);
	this.panelSeleccionTipo.setLayout(new GridLayout(3, 0, 0, 0));

	this.rdbtnGuerrero = new JRadioButton("Guerrero\r\n");
	buttonGroup.add(this.rdbtnGuerrero);
	this.panelSeleccionTipo.add(this.rdbtnGuerrero);

	this.rdbtnCaballero = new JRadioButton("Caballero");
	buttonGroup.add(this.rdbtnCaballero);
	this.panelSeleccionTipo.add(this.rdbtnCaballero);

	this.rdbtnArquero = new JRadioButton("Arquero");
	buttonGroup.add(this.rdbtnArquero);
	this.rdbtnArquero.setSelected(true);
	this.panelSeleccionTipo.add(this.rdbtnArquero);

	this.panelParametrosConstructor = new JPanel();
	this.panelParametrosConstructor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	this.panelCrearPersonaje.add(this.panelParametrosConstructor);
	this.panelParametrosConstructor.setLayout(new GridLayout(0, 2, 0, 0));

	this.panel = new JPanel();
	this.panelParametrosConstructor.add(this.panel);

	this.lblNewLabel = new JLabel("Nombre:");
	this.panel.add(this.lblNewLabel);

	this.panel_5 = new JPanel();
	this.panelParametrosConstructor.add(this.panel_5);

	this.textFieldNombre = new JTextField();
	this.panel_5.add(this.textFieldNombre);
	this.textFieldNombre.setColumns(10);

	this.panel_2 = new JPanel();
	this.panelParametrosConstructor.add(this.panel_2);

	this.lblX = new JLabel("X:");
	this.panel_2.add(this.lblX);

	this.panel_4 = new JPanel();
	this.panelParametrosConstructor.add(this.panel_4);

	this.textField_X = new JTextField();
	this.panel_4.add(this.textField_X);
	this.textField_X.setColumns(10);

	this.panel_1 = new JPanel();
	this.panelParametrosConstructor.add(this.panel_1);

	this.lblY = new JLabel("Y:");
	this.panel_1.add(this.lblY);

	this.panel_3 = new JPanel();
	this.panelParametrosConstructor.add(this.panel_3);

	this.textField_Y = new JTextField();
	this.panel_3.add(this.textField_Y);
	this.textField_Y.setColumns(10);

	this.lblNewLabel_3 = new JLabel("");
	this.panelParametrosConstructor.add(this.lblNewLabel_3);
	
	this.panel_7 = new JPanel();
	this.panelParametrosConstructor.add(this.panel_7);
	
		this.btnAgregar = new JButton("Agregar");
		this.panel_7.add(this.btnAgregar);
		this.btnAgregar.addActionListener(this);

	this.panelAcciones = new JPanel();
	this.panelAcciones.setBackground(Color.BLUE);
	this.panelColumna_2.add(this.panelAcciones);

	this.panelParametrosConstructor_1 = new JPanel();
	this.panelParametrosConstructor_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	this.panelAcciones.add(this.panelParametrosConstructor_1);
	this.panelParametrosConstructor_1.setLayout(new GridLayout(0, 2, 0, 0));

	this.panel_8 = new JPanel();
	this.panelParametrosConstructor_1.add(this.panel_8);

	this.lblX_1 = new JLabel("X:");
	this.panel_8.add(this.lblX_1);

	this.panel_9 = new JPanel();
	this.panelParametrosConstructor_1.add(this.panel_9);

	this.textField_X_Mover = new JTextField();
	this.textField_X_Mover.setColumns(10);
	this.panel_9.add(this.textField_X_Mover);

	this.panel_10 = new JPanel();
	this.panelParametrosConstructor_1.add(this.panel_10);

	this.lblY_1 = new JLabel("Y:");
	this.panel_10.add(this.lblY_1);

	this.panel_11 = new JPanel();
	this.panelParametrosConstructor_1.add(this.panel_11);

	this.textField_Y_Mover = new JTextField();
	this.textField_Y_Mover.setColumns(10);
	this.panel_11.add(this.textField_Y_Mover);

	this.lblNewLabel_2 = new JLabel("");
	this.panelParametrosConstructor_1.add(this.lblNewLabel_2);
	
	this.panel_6 = new JPanel();
	this.panelParametrosConstructor_1.add(this.panel_6);
	
		this.btnMover = new JButton("Mover");
		this.panel_6.add(this.btnMover);
		this.btnMover.addActionListener(this);

	this.btnAtacar = new JButton("Atacar");
	this.btnAtacar.addActionListener(this);
	this.panelAcciones.add(this.btnAtacar);

	this.btnEliminar = new JButton("Eliminar");
	this.btnEliminar.addActionListener(this);
	this.panelAcciones.add(this.btnEliminar);

	this.scrollPane_2 = new JScrollPane();
	this.panelAcciones.add(this.scrollPane_2);

	this.textArea_Detalles = new JTextArea();
	this.scrollPane_2.setViewportView(this.textArea_Detalles);
	this.textArea_Detalles.setColumns(25);
	this.textArea_Detalles.setRows(3);

	this.panelColumna_3 = new JPanel();
	this.panelCentral.add(this.panelColumna_3);
	this.panelColumna_3.setLayout(new BorderLayout(0, 0));

	this.scrollPane_1 = new JScrollPane();
	this.panelColumna_3.add(this.scrollPane_1);

	this.list_2 = new JList<Personaje>();
	this.scrollPane_1.setViewportView(this.list_2);

	this.panelSur = new JPanel();
	this.panelSur.setBackground(Color.RED);
	this.contentPane.add(this.panelSur, BorderLayout.SOUTH);
	this.panelSur.setLayout(new BorderLayout(0, 0));
	this.panelSur.setPreferredSize(new Dimension(50, 50));

	this.scrollPane_3 = new JScrollPane();
	this.panelSur.add(this.scrollPane_3, BorderLayout.CENTER);

	this.textArea_Log = new JTextArea();
	this.scrollPane_3.setViewportView(this.textArea_Log);
	this.modeloLista = new DefaultListModel<Personaje>();
	this.list_1.setModel(modeloLista);
	this.list_2.setModel(modeloLista);

    }

    public void actionPerformed(ActionEvent arg0)
    {
	if (arg0.getActionCommand().equals("Atacar"))
	    this.atacarPersonaje();
	else if (arg0.getActionCommand().equals("Mover"))
	    this.moverPersonaje();
	else if (arg0.getActionCommand().equals("Eliminar"))
	    this.eliminarPersonaje();
	else if (arg0.getActionCommand().equals("Agregar"))
	    this.agregarPersonaje();

	this.actualizarListas();

    }

    private void actualizarListas()
    {
	this.modeloLista.clear();
	Iterator<Personaje> it = this.mapa.getPersonajes().iterator();
	while (it.hasNext())
	    this.modeloLista.addElement(it.next());
	this.repaint();

    }

    private void agregarPersonaje()
    {
	String tipo = null;
	if (this.rdbtnGuerrero.isSelected())
	    tipo = "Guerrero";
	else if (this.rdbtnCaballero.isSelected())
	    tipo = "Caballero";
	else if (this.rdbtnArquero.isSelected())
	    tipo = "Arquero";

	double x = Double.parseDouble(this.textField_X.getText());
	double y = Double.parseDouble(this.textField_Y.getText());

	String nombre = this.textFieldNombre.getText();
	Personaje personaje = PersonajeFactory.getPersonaje(tipo, nombre, new Posicion(x, y));

	this.mapa.agregarPersonaje(personaje);
	this.textArea_Log.append("\nSe agrego a " + personaje.getNombre());

    }

    private void eliminarPersonaje()
    {
	Personaje personaje = this.list_1.getSelectedValue();
	if (personaje != null)
	{
	    this.mapa.eliminarPersonaje(personaje);
	    this.textArea_Log.append("\nSe elimino a " + personaje.getNombre());
	} else
	    JOptionPane.showMessageDialog(this, "Debe seleccionar un personaje de a lista para elminar");

    }

    private void moverPersonaje()
    {
	Personaje personaje = this.list_1.getSelectedValue();
	if (personaje != null)
	{
	    double x = Double.parseDouble(this.textField_X_Mover.getText());
	    double y = Double.parseDouble(this.textField_Y_Mover.getText());
	    personaje.mueve(x, y);
	    this.textArea_Log.append("\nSe movio a " + personaje.getNombre() + " X: " + x + " Y: " + y);
	} else
	    JOptionPane.showMessageDialog(this, "Debe seleccionar un personaje de a lista para eliminarlo");

    }

    private void atacarPersonaje()
    {
	Personaje personaje = this.list_1.getSelectedValue();
	Personaje victima = this.list_2.getSelectedValue();

	if (personaje != null && victima != null)
	{
	    String cartel = personaje.ataca(victima);
	    this.textArea_Log.append("\n" + cartel);
	} else
	    JOptionPane.showMessageDialog(this, "Debe seleccionar un personaje de cada lista");

    }

    public void valueChanged(ListSelectionEvent arg0)
    {
	Personaje personaje = this.list_1.getSelectedValue();
	if (personaje != null)
	    this.textArea_Detalles.setText(personaje.toString());
    }
}
