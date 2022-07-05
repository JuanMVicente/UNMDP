package modeloSemaforo;

import interfaces.IRevista;

import java.util.concurrent.Semaphore;

public class RevistaSemaforo implements IRevista
{
    private int idRevista;
    private String titulo;
    protected static int siguienteID = 0;
    private Semaphore semaforo;

    public RevistaSemaforo(String titulo)
    {
        this.titulo = titulo;
        RevistaSemaforo.siguienteID++;
        this.idRevista = RevistaSemaforo.siguienteID;
        this.semaforo = new Semaphore(1, true);
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

    public void pedirEstaRevista() throws InterruptedException
    {
        this.semaforo.acquire();
    }

    public void devolverEstaRevista()
    {
        this.semaforo.release();
    }
}

