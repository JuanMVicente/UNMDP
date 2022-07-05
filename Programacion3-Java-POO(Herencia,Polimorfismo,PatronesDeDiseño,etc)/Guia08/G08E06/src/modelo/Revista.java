package modelo;

import interfaces.IRevista;

public class Revista implements IRevista
{
    private int idRevista;
    private String titulo;
    protected static int siguienteID = 0;
    private boolean prestado;
    
    public Revista(String titulo)
    {
        this.titulo = titulo;
        Revista.siguienteID++;
        this.idRevista = Revista.siguienteID;
        this.prestado = false;
    }

    @Override
    public String toString()
    {
        return this.titulo + " - I.D.: " + this.idRevista;
    }

    public int getIdRevista()
    {
        return idRevista;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void setPrestado(boolean prestado)
    {
        this.prestado = prestado;
    }

    public boolean isPrestado()
    {
        return prestado;
    }
}