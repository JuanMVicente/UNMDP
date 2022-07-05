package modelo;

import java.io.Serializable;

public class Proveedor implements Comparable, Serializable
{
    private String email, nombre, telefono;
    
    public Proveedor()
    {
        super();
    }

    public Proveedor(String email, String nombre, String telefono)
    {
        this.email = email;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    public String getTelefono()
    {
        return telefono;
    }
    
    @Override
    public int compareTo(Object obj)
    {
        return this.nombre.compareToIgnoreCase(((Proveedor) obj).nombre);
    }

    @Override
    public String toString()
    {
        return " NOMBRE: " + this.nombre + " TEL.: " + this.telefono + " EMAIL: " + this.email;
    }
}