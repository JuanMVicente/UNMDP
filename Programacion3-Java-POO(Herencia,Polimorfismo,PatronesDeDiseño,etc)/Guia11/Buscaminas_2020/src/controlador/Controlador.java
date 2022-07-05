package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;
import java.util.Observable;
import java.util.Observer;

import modelo.ICelda;
import modelo.Tablero;
import vista.IVista;
import vista.VentanaBuscaminas;

public class Controlador implements ActionListener, Observer
{
    private Tablero tablero;
    private IVista vista;

    public Controlador()
    {
	this.vista = new VentanaBuscaminas();
	this.vista.setActionListener(this);
    }

    public IVista getVista()
    {
        return vista;
    }

    public void setVista(IVista vista)
    {
        this.vista = vista;
        this.vista.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
	String comando = e.getActionCommand();
	if (comando.equalsIgnoreCase("INICIAR"))
	{
	    this.tablero = new Tablero(vista.getAlto(), vista.getAncho(), vista.getCantidad());
	    this.tablero.addObserver(this);
	    this.vista.iniciarJuego(vista.getAlto(), vista.getAncho());
	    
	} else if (comando.equalsIgnoreCase("PISAR"))
	{
	    ICelda celda = (ICelda) e.getSource();
	    int i = celda.getI();
	    int j = celda.getJ();
	    if (!this.tablero.isPisado(i, j) && !this.tablero.isMarcado(i, j))
		this.tablero.pisa(i, j);
	} else if (comando.equalsIgnoreCase("MARCAR"))
	{
	    ICelda celda = (ICelda) e.getSource();
	    int i = celda.getI();
	    int j = celda.getJ();
	    if (!this.tablero.isPisado(i, j))
		this.tablero.marca(i, j);
	}
	  this.vista.dibujar(tablero);
    }

    @Override
    public void update(Observable arg0, Object arg1)
    {
	if (arg0 != this.tablero)
	    throw new InvalidParameterException();
	this.vista.dibujarFinal(tablero);
	if (arg1.toString().contentEquals("GANO"))
	{
	    this.vista.ganar();
	} else if (arg1.toString().contentEquals("PERDIO"))
	{
	    this.vista.perder();
	}
    }
}
