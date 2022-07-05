package modelo;

import java.io.Serializable;

import java.text.SimpleDateFormat;

import java.util.GregorianCalendar;

public class Llamado implements Comparable, Serializable
{
    private GregorianCalendar fechaHoraPedido, fechaHoraAtendido;
    private int prioridad;
    private Socio socio;

    public Llamado(int prioridad, Socio socio)
    {
        this.prioridad = prioridad;
        this.socio = socio;
        this.fechaHoraAtendido = null;
        this.fechaHoraPedido = new GregorianCalendar();
    }

    public GregorianCalendar getFechaHoraPedido()
    {
        return fechaHoraPedido;
    }

    public void setFechaHoraAtendido(GregorianCalendar fechaHoraAtendido)
    {
        this.fechaHoraAtendido = fechaHoraAtendido;
    }

    public GregorianCalendar getFechaHoraAtendido()
    {
        return fechaHoraAtendido;
    }

    public int getPrioridad()
    {
        return prioridad;
    }

    public Socio getSocio()
    {
        return socio;
    }

    @Override
    public int compareTo(Object obj)
    {
        Llamado otro = (Llamado) obj;
        int aux = - (this.prioridad - otro.prioridad);
        
        if (aux == 0)
            aux = this.fechaHoraPedido.compareTo(otro.fechaHoraPedido);
        
        return aux;
    }

    @Override
    public String toString()
    {
        String retorno = "Socio: " + this.socio + "\nPrioridad: " + this.prioridad + "\nPedido: ";
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy '-' HH:mm:ss.SSS");
        
        retorno = retorno + formato.format(this.fechaHoraPedido.getTime()) + "\nAtendido: ";
        
        if (this.fechaHoraAtendido != null)
            retorno += formato.format(this.fechaHoraAtendido.getTime());
        else
            retorno += "No";
        
        return retorno;
    }
}
