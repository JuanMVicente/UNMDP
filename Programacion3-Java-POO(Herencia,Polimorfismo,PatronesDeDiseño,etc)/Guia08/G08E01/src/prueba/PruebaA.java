package prueba;

import Interface.IVia;
import a.Tren;
import a.ViaA;

public class PruebaA
{
    public static void main(String[] args)
    {
        IVia via = new ViaA();
        
        new Tren("AAA", null, via).start();
        new Tren("BBB", null, via).start();
        new Tren("CCC", null, via).start();
        new Tren("DDD", null, via).start();
    }
}
