package prueba;

import modelo.Arquero;
import modelo.ArqueroDeFuego;
import modelo.Caballero;
import modelo.OtraClase;
import modelo.Posicion;

public class Prueba2
{

    public static void main(String[] args)
    {
	OtraClase oc=new OtraClase();
	
	Caballero cab= new Caballero("Percival",new Posicion(0,0));
	Arquero arq=new ArqueroDeFuego("Merida",new Posicion (10,10));
	
	oc.metodo1(arq, cab);
	
	oc.metodo2(arq);
	System.out.println(arq);
	
    }

}
