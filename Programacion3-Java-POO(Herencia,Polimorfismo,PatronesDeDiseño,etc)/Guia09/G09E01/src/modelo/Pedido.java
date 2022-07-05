package modelo;

import excepciones.OperacionConjuntosException;

import java.io.Serializable;

import java.text.SimpleDateFormat;

import java.util.GregorianCalendar;
import java.util.Iterator;

public class Pedido extends ConjuntoGenericoOrdenado<LineaDePedido>
{
    private Proveedor proveedor;
    private GregorianCalendar fecha;
    private boolean entregado;


    public Pedido()
    {
        super();
    }

    public Pedido(Proveedor proveedor)
    {
        super();
        this.proveedor = proveedor;
        this.entregado = false;
        this.fecha = new GregorianCalendar();
    }

    public String detalle()
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
        String retorno = "FECHA: " + formato.format(this.fecha.getTime()) + "\nPROVEEDOR: " + this.proveedor + 
                        "\nCANT. DE LINEAS: " + this.getCardinal() + "\nENTREGADO: " + ((this.entregado) ? "SÍ" : "NO");
        Iterator<LineaDePedido> iter = this.getIterator();
        LineaDePedido aux;
        double total = 0;
        
        while (iter.hasNext())
        {
            aux = (LineaDePedido) iter.next();
            retorno = retorno + "\n" + aux.toString();
            total = total + (aux.getCantidad() * aux.getProducto().getPreciounitario());
        }
        retorno = retorno + "\nTOTAL: $" + total;
        
        return retorno;
    }
    
    public double totalPedido()
    {
        Iterator<LineaDePedido> iter = this.getIterator();
        LineaDePedido aux;
        double total = 0;
        
        while (iter.hasNext())
        {
            aux = (LineaDePedido) iter.next();
            total = total + (aux.getCantidad() * aux.getProducto().getPreciounitario());
        }
        
        return total;
    }
    
    public void entregar()
    {
        this.entregado = true;
    }
    
    public boolean isEntregado()
    {
        return this.entregado;
    }

    public Proveedor getProveedor()
    {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor)
    {
        this.proveedor = proveedor;
    }

    public void setFecha(GregorianCalendar fecha)
    {
        this.fecha = fecha;
    }

    public GregorianCalendar getFecha()
    {
        return fecha;
    }

    public void setEntregado(boolean entregado)
    {
        this.entregado = entregado;
    }

}
