package modeloSemaforo;

import interfaces.IBiblioteca;

import interfaces.ILibro;

import interfaces.IRevista;

import java.util.HashMap;
import java.util.Random;

import modelo.Revista;
import modelo.SocioLibro;
import modelo.SocioRevista;

public class BibliotecaSemaforo implements IBiblioteca
{
    private HashMap<Integer,LibroSemaforo> libros;
    private HashMap<Integer,RevistaSemaforo> revistas;
    
    public BibliotecaSemaforo()
    {
        this.libros = new HashMap<Integer,LibroSemaforo>();
        this.revistas = new HashMap<Integer,RevistaSemaforo>();
    }
    
    public void agregarLibro(ILibro libro)
    {
        if ( ! this.libros.containsKey(libro.getIdLibro()))
            this.libros.put(libro.getIdLibro(), (LibroSemaforo)libro);
    }
    
    public void solicitarLibro(SocioLibro socio)
    {
        Random rnd = new Random();
        int idBuscado = rnd.nextInt(this.libros.size()) + 1;
        
        try
        {
            System.out.println(socio + " desea retirar " + this.libros.get(idBuscado));
            this.libros.get(idBuscado).pedirEsteLibro();
            System.out.println(socio + " retiró " + this.libros.get(idBuscado));
            socio.setIdLibroPrestado(idBuscado);
        } 
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    
    public void devolverLibro(SocioLibro socio)
    {
        int idPrestado = socio.getIdLibroPrestado();
        
        socio.setIdLibroPrestado(-1);
        System.out.println(socio + " devolvió " + this.libros.get(idPrestado));
        this.libros.get(idPrestado).devolverEsteLibro();
    }

    @Override
    public void agregarRevista(IRevista revista)
    {
        if ( ! this.revistas.containsKey(revista.getIdRevista()))
            this.revistas.put(revista.getIdRevista(), (RevistaSemaforo) revista);
    }

    @Override
    public void solicitarRevista(SocioRevista socio)
    {
        Random rnd = new Random();
        int idBuscado = rnd.nextInt(this.revistas.size()) + 1;
        
        try
        {
            System.out.println(socio + " desea retirar " + this.revistas.get(idBuscado));
            this.revistas.get(idBuscado).pedirEstaRevista();
            System.out.println(socio + " retiró " + this.revistas.get(idBuscado));
            socio.setIdRevistaPrestada(idBuscado);
        } 
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void devolverRevista(SocioRevista socio)
    {
        int idPrestado = socio.getIdRevistaPrestada();
        
        socio.setIdRevistaPrestada(-1);
        System.out.println(socio + " devolvió " + this.revistas.get(idPrestado));
        this.revistas.get(idPrestado).devolverEstaRevista();
    }
}
