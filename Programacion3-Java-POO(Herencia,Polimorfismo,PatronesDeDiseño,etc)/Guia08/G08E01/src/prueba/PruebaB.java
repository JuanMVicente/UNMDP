package prueba;

import Interface.IVia;
import a.Tren;
import b.ViaB;

public class PruebaB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        IVia via = new ViaB();
        
        new Tren("AAA", ViaB.izquierda, via).start();
        new Tren("BBB", ViaB.derecha, via).start();
        new Tren("CCC", ViaB.izquierda, via).start();
        new Tren("DDD", ViaB.derecha, via).start();
	}

}
