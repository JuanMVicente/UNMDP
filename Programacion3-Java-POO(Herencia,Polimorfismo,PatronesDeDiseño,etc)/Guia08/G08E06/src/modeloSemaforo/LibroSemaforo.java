package modeloSemaforo;

import interfaces.ILibro;

import java.util.concurrent.Semaphore;

public class LibroSemaforo implements ILibro
{
    private int idLibro;
    private String titulo;
    protected static int siguienteID = 0;
    private Semaphore semaforo;

    public LibroSemaforo(String titulo)
    {
        this.titulo = titulo;
        LibroSemaforo.siguienteID++;
        this.idLibro = LibroSemaforo.siguienteID;
        this.semaforo = new Semaphore(1, true);
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

    public void pedirEsteLibro() throws InterruptedException
    {
        this.semaforo.acquire();
    }

    public void devolverEsteLibro()
    {
        this.semaforo.release();
    }
}
