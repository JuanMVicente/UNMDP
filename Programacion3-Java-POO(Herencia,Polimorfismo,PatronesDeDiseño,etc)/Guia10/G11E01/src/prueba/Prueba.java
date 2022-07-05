package prueba;

import modelo.Cuidador;
import modelo.Mascota;

public class Prueba
{
    public static void main(String[] args)
    {
        Cuidador cuidador = new Cuidador();
        
        Mascota m1 = new Mascota("Martín");
        Mascota m2 = new Mascota("Ivan");
        Mascota m3 = new Mascota("Guido");
        Mascota m4 = new Mascota("Tomás");
        
        cuidador.agregarMascota(m1);
        cuidador.agregarMascota(m2);
        cuidador.agregarMascota(m3);
        cuidador.agregarMascota(m4);
        
        new Thread (m1).start();
        new Thread (m2).start();
        new Thread (m3).start();
        new Thread (m4).start();
    }
}