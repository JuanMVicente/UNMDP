package modelo;

import interfaces.IBiblioteca;

import utilidades.Util;

public class SocioLibro implements Runnable
{
    private String nombre;
    private int idLibro;
    private IBiblioteca biblioteca;
    
    public SocioLibro(String nombre, IBiblioteca biblioteca)
    {
        this.nombre = nombre;
        this.idLibro = -1;
        this.biblioteca = biblioteca;
    }

    public void setIdLibroPrestado(int idLibroPrestado)
    {
        this.idLibro = idLibroPrestado;
    }

    public int getIdLibroPrestado()
    {
        return idLibro;
    }

    @Override
    public String toString()
    {
        return this.nombre;
    }

    @Override
    public void run()
    {
        int i;
        
        for (i = 1; i < 5; i++)
        {
            Util.espera(); /* tiempo que tarda en ir a retirar un libro */
            this.biblioteca.solicitarLibro(this);
            Util.espera(); /* tiempo que tarda leyéndolo */
            this.biblioteca.devolverLibro(this);
        }
    }
}
