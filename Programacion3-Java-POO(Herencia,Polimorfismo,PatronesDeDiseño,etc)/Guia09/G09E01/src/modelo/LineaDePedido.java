package modelo;

import java.io.Serializable;

public class LineaDePedido implements Comparable, Serializable
{
    private int cantidad;
    private Producto producto;
    
    public LineaDePedido()
    {
        super();
    }

    public LineaDePedido(int cantidad, Producto producto)
    {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public void setCantidad(int cantidad)
    {
        this.cantidad = cantidad;
    }

    public int getCantidad()
    {
        return cantidad;
    }

    public void setProducto(Producto producto)
    {
        this.producto = producto;
    }

    public Producto getProducto()
    {
        return producto;
    }

    @Override
    public int compareTo(Object obj)
    {   
        return this.producto.getCodigo() - ((LineaDePedido) obj).producto.getCodigo();
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof LineaDePedido))
        {
            return false;
        }
        final LineaDePedido other = (LineaDePedido) object;
        if (!(producto == null ? other.producto == null : producto.equals(other.producto)))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + ((producto == null) ? 0 : producto.hashCode());
        return result;
    }

    @Override
    public String toString()
    {
        return this.producto + " CANT.: " + this.cantidad;
    }
}
