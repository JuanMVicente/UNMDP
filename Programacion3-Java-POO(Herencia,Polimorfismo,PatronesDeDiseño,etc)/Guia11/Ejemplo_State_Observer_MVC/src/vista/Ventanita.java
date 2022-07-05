package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Soldado;

public class Ventanita extends JFrame implements IVista
{

    private JPanel contentPane;
    private JPanel panelOeste;
    private JPanel panel_Arriba;
    private JPanel panel_Abajo;
    private JTextField textField;
    private JButton btnAgregar;
    private JScrollPane scrollPane;
    private JPanel panel_Centro;
    private JPanel panel_Abajo_1;
    private JScrollPane scrollPane_1;
    private JList<Soldado> list;
    private JPanel panel;
    private JPanel panel_1;
    private JButton btnPatrullar;
    private JPanel panel_2;
    private JButton btnSaludar;
    private JPanel panel_3;
    private JButton btnSospechar;
    private JPanel panel_4;
    private JButton btnAtacar;
    private JPanel panel_5;
    private JButton btnMorir;
    private DefaultListModel<Soldado> modeloLista= new DefaultListModel<Soldado>();
    private ArrayList<Soldado> soldadosRegistrados = new ArrayList<Soldado>();

   
    public Ventanita()
    {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 872, 676);
	this.contentPane = new JPanel();
	this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	this.contentPane.setLayout(new BorderLayout(0, 0));
	setContentPane(this.contentPane);

	this.panelOeste = new JPanel();
	this.panelOeste.setPreferredSize(new Dimension(150, 100));
	this.contentPane.add(this.panelOeste, BorderLayout.WEST);
	this.panelOeste.setLayout(new GridLayout(3, 0, 0, 0));

	this.panel_Arriba = new JPanel();
	this.panelOeste.add(this.panel_Arriba);

	this.textField = new JTextField();
	this.panel_Arriba.add(this.textField);
	this.textField.setColumns(10);

	this.btnAgregar = new JButton("Agregar");
	this.panel_Arriba.add(this.btnAgregar);

	this.panel_Abajo = new JPanel();
	this.panelOeste.add(this.panel_Abajo);
	this.panel_Abajo.setLayout(new BorderLayout(0, 0));

	this.scrollPane_1 = new JScrollPane();
	this.panel_Abajo.add(this.scrollPane_1, BorderLayout.CENTER);

	this.list = new JList<Soldado>();
	this.scrollPane_1.setViewportView(this.list);

	this.panel_Abajo_1 = new JPanel();
	this.panelOeste.add(this.panel_Abajo_1);

	this.panel = new JPanel();
	this.panel_Abajo_1.add(this.panel);
	this.panel.setLayout(new GridLayout(0, 1, 0, 0));

	this.panel_1 = new JPanel();
	this.panel.add(this.panel_1);

	this.btnPatrullar = new JButton("Patrullar");
	this.panel_1.add(this.btnPatrullar);

	this.panel_2 = new JPanel();
	this.panel.add(this.panel_2);

	this.btnSaludar = new JButton("Saludar");
	this.panel_2.add(this.btnSaludar);

	this.panel_3 = new JPanel();
	this.panel.add(this.panel_3);

	this.btnSospechar = new JButton("Sospechar");
	this.panel_3.add(this.btnSospechar);

	this.panel_4 = new JPanel();
	this.panel.add(this.panel_4);

	this.btnAtacar = new JButton("Atacar");
	this.panel_4.add(this.btnAtacar);

	this.panel_5 = new JPanel();
	this.panel.add(this.panel_5);

	this.btnMorir = new JButton("Morir");
	this.panel_5.add(this.btnMorir);

	this.scrollPane = new JScrollPane();
	this.contentPane.add(this.scrollPane, BorderLayout.CENTER);

	this.panel_Centro = new JPanel();
	this.scrollPane.setViewportView(this.panel_Centro);
	this.panel_Centro.setLayout(new GridLayout(0, 5, 6, 6));
	this.list.setModel(modeloLista);
    }

    @Override
    public Soldado getSoldadoSeleccionado()
    {
	return this.list.getSelectedValue();
    }

    @Override
    public String getNombreNuevoSoldado()
    {

	return this.textField.getText();
    }

    @Override
    public void addActionListener(ActionListener listener)
    {
	this.btnAgregar.addActionListener(listener);
	this.btnAtacar.addActionListener(listener);
	this.btnMorir.addActionListener(listener);
	this.btnPatrullar.addActionListener(listener);
	this.btnSaludar.addActionListener(listener);
	this.btnSospechar.addActionListener(listener);

    }

    @Override
    public void actualizaLista(Iterator<Soldado> iteratorSoldados)
    {
	while (iteratorSoldados.hasNext())
	{
	    Soldado soldado = iteratorSoldados.next();
	    if (!this.soldadosRegistrados.contains(soldado))
	    {this.agregaNuevoSoldado(soldado);
		
	    }

	}

    }

    private void agregaNuevoSoldado(Soldado soldado)
    {
	this.panel_Centro.add(new PanelSoldado(soldado));
	this.modeloLista.addElement(soldado);
	this.soldadosRegistrados.add(soldado);
	this.validate();
    }
}
