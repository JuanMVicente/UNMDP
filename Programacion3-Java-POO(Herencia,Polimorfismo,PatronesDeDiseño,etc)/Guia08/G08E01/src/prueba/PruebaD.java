package prueba;

import Interface.IVia;
import a.Tren;
import d.ViaD;

public class PruebaD {
    public static void main(String[] args)
    {
        IVia via = new ViaD();
        
        new Tren("AAA", ViaD.izquierda, via).start();
        new Tren("BBB", ViaD.derecha,   via).start();
        new Tren("CCC", ViaD.izquierda, via).start();
        new Tren("DDD", ViaD.derecha,   via).start();
    }
}
