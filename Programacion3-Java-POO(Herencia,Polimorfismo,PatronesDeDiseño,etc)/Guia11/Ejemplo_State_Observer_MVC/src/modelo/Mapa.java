package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Mapa
{
    private ArrayList<Soldado> soldados = new ArrayList<Soldado>();
    private static Mapa instance = null;

    private Mapa()
    {
    }

    public static Mapa getInstance()
    {
	if (Mapa.instance == null)
	    Mapa.instance = new Mapa();
	return Mapa.instance;
    }

    public void agregarSoldado(Soldado soldado)
    {
	this.soldados.add(soldado);
    }

    public Iterator<Soldado> iteratorSoldados()
    {
	return this.soldados.iterator();
    }

    public void ordenarSoldado(Soldado soldado, String comando) throws ComandoDesconocidoException
    {
	if(comando.equalsIgnoreCase("Patrullar"))
	    soldado.volvePatrullar();
	else if (comando.equalsIgnoreCase("Sospechar"))
	    soldado.haySospechas();
	else if (comando.equalsIgnoreCase("Atacar"))
	    soldado.hayEvidencia();
	else if (comando.equalsIgnoreCase("Saludar"))
	    soldado.saludaSuperior();
	else if (comando.equalsIgnoreCase("Morir"))
	    soldado.recibeDanoLetal();
	else throw new ComandoDesconocidoException(comando);
	
	
    }
}
