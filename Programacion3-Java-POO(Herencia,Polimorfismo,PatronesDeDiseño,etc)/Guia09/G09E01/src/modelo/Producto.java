package modelo;

import java.io.Serializable;

public class Producto implements Comparable, Serializable
{
    private int codigo;
    private String descripcion;
    private double preciounitario;
    
    public Producto()
    {
        super();
    }

    public Producto(int codigo, String descripcion, double preciounitario)
    {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.preciounitario = preciounitario;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setPreciounitario(double preciounitario)
    {
        this.preciounitario = preciounitario;
    }

    public double getPreciounitario()
    {
        return preciounitario;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof Producto))
        {
            return false;
        }
        final Producto other = (Producto) object;
        if (codigo != other.codigo)
        {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Object obj)
    {   
        return this.codigo - ((Producto) obj).codigo;
    }

    @Override
    public int hashCode()
    {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + codigo;
        return result;
    }

    @Override
    public String toString()
    {
        return "COD.: " + this.codigo + " DESCRIP.: " + this.descripcion + " Pu: $" + this.preciounitario;
    }
}