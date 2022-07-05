package utilidades;

import java.util.Random;

public class Esperador
{
    private static Random rnd = new Random();
    
    public static void espera(int milisegundos)
    {
        try
        {
            Thread.sleep(milisegundos);
        } 
        catch (InterruptedException e)
        {
           e.printStackTrace();
        }

    }

    public static void espera()
    {
        Esperador.espera(rnd.nextInt(1000));
    }
}