package prueba;

import interfaces.IBiblioteca;

import modelo.Biblioteca;
import modelo.Libro;
import modelo.Revista;
import modelo.SocioLibro;
import modelo.SocioRevista;

public class Prueba
{
    public static void main(String[] args)
    {
        IBiblioteca biblio = new Biblioteca();
        
        /* CREO LIBROS */
        biblio.agregarLibro(new Libro("Física II"));
        biblio.agregarLibro(new Libro("Harry Potter"));
        biblio.agregarLibro(new Libro("Coso"));
        biblio.agregarLibro(new Libro("Cocina Fácil"));
        biblio.agregarLibro(new Libro("Todo sobre bidets"));
        
        /* CREO REVISTAS */
        biblio.agregarRevista(new Revista("Auto Test"));
        biblio.agregarRevista(new Revista("Evo"));
        biblio.agregarRevista(new Revista("Autos Clásicos"));
        biblio.agregarRevista(new Revista("Octane"));
        biblio.agregarRevista(new Revista("Parabrisas"));
        
        /* CREO SOCIOS, tanto de libros como revistas */
        new Thread(new SocioLibro("SL1", biblio)).start();
        new Thread(new SocioRevista("SR1", biblio)).start();
        new Thread(new SocioLibro("SL2", biblio)).start();
        new Thread(new SocioRevista("SR2", biblio)).start();
        new Thread(new SocioLibro("SL3", biblio)).start();
        new Thread(new SocioRevista("SR3", biblio)).start();
        new Thread(new SocioLibro("SL4", biblio)).start();
        new Thread(new SocioRevista("SR4", biblio)).start();
        new Thread(new SocioLibro("SL5", biblio)).start();
        new Thread(new SocioRevista("SR5", biblio)).start();
        new Thread(new SocioLibro("SL6", biblio)).start();
        new Thread(new SocioRevista("SR6", biblio)).start();
        new Thread(new SocioLibro("SL7", biblio)).start();
        new Thread(new SocioRevista("SR7", biblio)).start();
        new Thread(new SocioLibro("SL8", biblio)).start();
        new Thread(new SocioRevista("SR8", biblio)).start();
        new Thread(new SocioLibro("SL9", biblio)).start();
        new Thread(new SocioRevista("SR9", biblio)).start();
        new Thread(new SocioLibro("SL10", biblio)).start();
        new Thread(new SocioRevista("SR10", biblio)).start();
    }
}