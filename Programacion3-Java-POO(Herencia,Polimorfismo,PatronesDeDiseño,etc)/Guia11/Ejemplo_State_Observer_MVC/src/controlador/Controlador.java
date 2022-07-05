package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.ComandoDesconocidoException;
import modelo.Mapa;
import modelo.Soldado;
import vista.IVista;

public class Controlador implements ActionListener
{
    private IVista vista = null;

    public Controlador(IVista vista)
    {
	this.vista = vista;
	this.vista.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
	String comando = e.getActionCommand();
	if (comando.equalsIgnoreCase("Agregar"))
	{
	    Soldado soldado = new Soldado(this.vista.getNombreNuevoSoldado());
	    Mapa.getInstance().agregarSoldado(soldado);
	    Thread h = new Thread(soldado);
	    h.start();
	    this.vista.actualizaLista(Mapa.getInstance().iteratorSoldados());
	} else
	{
	    Soldado soldado=this.vista.getSoldadoSeleccionado();
	    if (soldado!=null)
	    try
	    {
		Mapa.getInstance().ordenarSoldado(soldado, comando);
	    } catch (ComandoDesconocidoException e1)
	    {
		JOptionPane.showMessageDialog(null, "Comando desconocido: " + e1.getComandoPretendido());
	    }
	    else JOptionPane.showMessageDialog(null, "Seleccione un soldado de la lista para dar una orden");
	}
    }

}
