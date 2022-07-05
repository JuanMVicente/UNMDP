package prueba;

import interfaces.IBiblioteca;

import modelo.SocioLibro;
import modelo.SocioRevista;

import modeloSemaforo.BibliotecaSemaforo;
import modeloSemaforo.LibroSemaforo;
import modeloSemaforo.RevistaSemaforo;

public class PruebaSemaforo
{
        public static void main(String[] args)
        {
            IBiblioteca biblio = new BibliotecaSemaforo();
            
            /* CREO LIBROS */
            biblio.agregarLibro(new LibroSemaforo("Física II"));
            biblio.agregarLibro(new LibroSemaforo("Harry Potter"));
            biblio.agregarLibro(new LibroSemaforo("Coso"));
            biblio.agregarLibro(new LibroSemaforo("Cocina Fácil"));
            biblio.agregarLibro(new LibroSemaforo("Todo sobre bidets"));
            
            /* CREO REVISTAS */
            biblio.agregarRevista(new RevistaSemaforo("Auto Test"));
            biblio.agregarRevista(new RevistaSemaforo("Evo"));
            biblio.agregarRevista(new RevistaSemaforo("Autos Clásicos"));
            biblio.agregarRevista(new RevistaSemaforo("Octane"));
            biblio.agregarRevista(new RevistaSemaforo("Parabrisas"));
            
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
