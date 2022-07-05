package modelo;

import interfaces.IBiblioteca;

import utilidades.Util;

public class SocioRevista implements Runnable
{
    private String nombre;
    private int idRevista;
    private IBiblioteca biblioteca;
    
    public SocioRevista(String nombre, IBiblioteca biblioteca)
    {
        this.nombre = nombre;
        this.idRevista = -1;
        this.biblioteca = biblioteca;
    }

    public void setIdRevistaPrestada(int idRevista)
    {
        this.idRevista = idRevista;
    }

    public int getIdRevistaPrestada()
    {
        return idRevista;
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
            Util.espera(); /* tiempo que tarda en ir a retirar una revista */
            this.biblioteca.solicitarRevista(this);
            Util.espera(); /* tiempo que tarda leyéndolo */
            this.biblioteca.devolverRevista(this);
        }
    }
}
