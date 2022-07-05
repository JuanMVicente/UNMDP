package modelo;

import interfaces.ILibro;

public class Libro implements ILibro
{
    private int idLibro;
    private String titulo;
    protected static int siguienteID = 0;
    private boolean prestado;
    
    public Libro(String titulo)
    {
        this.titulo = titulo;
        Libro.siguienteID++;
        this.idLibro = Libro.siguienteID;
        this.prestado = false;
    }

    @Override
    public String toString()
    {
        return this.titulo + " - I.D.: " + this.idLibro;
    }

    public int getIdLibro()
    {
        return idLibro;
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
