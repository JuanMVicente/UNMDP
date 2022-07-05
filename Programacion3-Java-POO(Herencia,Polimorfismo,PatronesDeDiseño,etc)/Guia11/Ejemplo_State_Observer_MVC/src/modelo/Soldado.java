package modelo;

import java.util.Observable;

import util.Util;

public class Soldado extends Observable implements Runnable
{
    private IState estado;
    private String nombre;
    private boolean vivo = true;

    public Soldado(String nombre)
    {
	this.nombre = nombre;
	this.estado = new PatrullaState(this);
    }

    public String getNombre()
    {
	return nombre;
    }

    protected void setEstado(IState estado)
    {
	this.estado = estado;
	
    }

    public void volvePatrullar()
    {
	this.setChanged();
	this.notifyObservers("Recibe estimulo para volver a patrullar");

	this.estado.volvePatrullar();

	this.setChanged();
	this.notifyObservers(this.estado.toString());

    }

    public void haySospechas()
    {
	this.setChanged();
	this.notifyObservers("Recibe estimulo para sospechar");

	this.estado.haySospechas();

	this.setChanged();
	this.notifyObservers(this.estado.toString());

    }

    public void hayEvidencia()
    {
	this.setChanged();
	this.notifyObservers("Recibe estimulo para atacar");

	this.estado.hayEvidencia();

	this.setChanged();
	this.notifyObservers(this.estado.toString());

    }

    public void saludaSuperior()
    {
	this.setChanged();
	this.notifyObservers("Recibe estimulo para saludar a superior");

	this.estado.saludaSuperior();

	this.setChanged();
	this.notifyObservers(this.estado.toString());

    }

    public void recibeDanoLetal()
    {
	this.setChanged();
	this.notifyObservers("Recibe estimulo para morir");

	this.estado.recibeDanoLetal();
	this.vivo = false;
	this.setChanged();
	this.notifyObservers(this.estado.toString());

    }

    public void actua()
    {
	String resultado = this.estado.actua();
	this.setChanged();
	this.notifyObservers(resultado);

    }

    @Override
    public String toString()
    {
	return this.nombre;
    }

    @Override
    public void run()
    {
	while (this.vivo)
	{
	    this.actua();
	    Util.espera(500);
	}
    }

}
