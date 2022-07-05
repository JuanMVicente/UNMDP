package threads;

import java.util.Random;

public class Util
{
    private static Random r = new Random();
    
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
        Util.espera(r.nextInt(2000));
    }
    
    public static void esperaExtendida()
    {
        Util.espera(r.nextInt(4000));
    }
    
    public static int random()
    {
    	return r.nextInt(3);
    }
}