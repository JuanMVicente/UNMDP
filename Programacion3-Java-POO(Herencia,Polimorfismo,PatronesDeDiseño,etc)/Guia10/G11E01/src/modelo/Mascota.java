package modelo;

import java.util.Observable;
import java.util.Random;

import utilidades.Esperador;

public class Mascota extends Observable implements Runnable
{
    private String nombre;
    
    public Mascota(String nombre)
    {
        this.nombre = nombre;
    }

    @Override
    public String toString()
    {
        return this.nombre;
    }

    public String getNombre()
    {
        return nombre;
    }

    @Override
    public void run()
    {
        int i;
        Random rnd = new Random();
        String estado = null;
        
        for (i = 0; i < 5; i++)
        {
            Esperador.espera(rnd.nextInt(7001) + 3000); /* espera entre 3-10 seg. */
            switch (rnd.nextInt(3))
            {
                case 0: estado = this + " tiene sed"       ; break;
                case 1: estado = this + " tiene hambre"    ; break;
                case 2: estado = this + " está aburrido/a" ; break;
            }
            this.setChanged();
            this.notifyObservers(estado);
        }
    }
}
