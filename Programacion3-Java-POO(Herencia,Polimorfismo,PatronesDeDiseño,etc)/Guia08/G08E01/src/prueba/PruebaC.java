package prueba;

import Interface.IVia;
import a.Tren;
import c.ViaC;

public class PruebaC 
{
    public static void main(String[] args)
    {
        IVia via = new ViaC();
        String izq = "IZQUIERDA";
        String der = "DERECHA";
        
        new Tren("AAA", izq, via).start();
        new Tren("BBB", der, via).start();
        new Tren("CCC", izq, via).start();
        new Tren("DDD", der, via).start();
    }
}