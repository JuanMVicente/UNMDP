package modelo;

import interfaces.IBiblioteca;
import interfaces.ILibro;

import interfaces.IRevista;

import java.util.HashMap;

import java.util.Random;

public class Biblioteca implements IBiblioteca /* con synchronized, wait, notifyAll */
{
    private HashMap<Integer,Libro> libros;
    private HashMap<Integer,Revista> revistas;
    
    public Biblioteca()
    {
        this.libros = new HashMap<Integer,Libro>();
        this.revistas = new HashMap<Integer,Revista>();
    }
    
    public void agregarLibro(ILibro libro)
    {
        if ( ! this.libros.containsKey(libro.getIdLibro()))
            this.libros.put(libro.getIdLibro(), (Libro) libro);
    }
    
    public void solicitarLibro(SocioLibro socio)
    {
        Random rnd = new Random();
        int idBuscado = rnd.nextInt(this.libros.size()) + 1;
        
        System.out.println(socio + " desea retirar " + this.libros.get(idBuscado));
        synchronized (this.libros)
        {
            while (this.libros.get(idBuscado).isPrestado())
            {
                System.out.println(socio + " está esperando a que " + this.libros.get(idBuscado) + " esté disponible");
                try
                {
                    this.libros.wait();
                } 
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            this.libros.get(idBuscado).setPrestado(true);
            socio.setIdLibroPrestado(idBuscado);
            System.out.println(socio + " retiró " + this.libros.get(idBuscado));
        }
    }
    
    public void devolverLibro(SocioLibro socio)
    {
        int idPrestado = socio.getIdLibroPrestado();
        
        System.out.println(socio + " desea devolver " + this.libros.get(idPrestado));
        synchronized (this.libros)
        {  
            this.libros.get(idPrestado).setPrestado(false);
            socio.setIdLibroPrestado(-1);
            System.out.println(socio + " devolvió " + this.libros.get(idPrestado));
            this.libros.notifyAll();
        }
    }

    @Override
    public void agregarRevista(IRevista revista)
    {
        if ( ! this.revistas.containsKey(revista.getIdRevista()))
            this.revistas.put(revista.getIdRevista(), (Revista) revista);
    }

    @Override
    public void solicitarRevista(SocioRevista socio)
    {
        Random rnd = new Random();
        int idBuscado = rnd.nextInt(this.revistas.size()) + 1;
        
        System.out.println(socio + " desea retirar " + this.revistas.get(idBuscado));
        synchronized (this.revistas)
        {
            while (this.revistas.get(idBuscado).isPrestado())
            {
                System.out.println(socio + " está esperando a que " + this.revistas.get(idBuscado)+ " esté disponible");
                try
                {
                    this.revistas.wait();
                } 
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            this.revistas.get(idBuscado).setPrestado(true);
            socio.setIdRevistaPrestada(idBuscado);
            System.out.println(socio + " retiró " + this.revistas.get(idBuscado));
        }
    }

    @Override
    public void devolverRevista(SocioRevista socio)
    {
        int idPrestado = socio.getIdRevistaPrestada();
        
        System.out.println(socio + " desea devolver " + this.revistas.get(idPrestado));
        synchronized (this.revistas)
        {  
            this.revistas.get(idPrestado).setPrestado(false);
            socio.setIdRevistaPrestada(-1);
            System.out.println(socio + " devolvió " + this.revistas.get(idPrestado));
            this.revistas.notifyAll();
        }
    }
}
