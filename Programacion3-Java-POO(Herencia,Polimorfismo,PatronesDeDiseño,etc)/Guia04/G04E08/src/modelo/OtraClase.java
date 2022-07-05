package modelo;

public class OtraClase
{
    public void metodo1(Personaje p, Personaje q)
    {

	System.out.println(p.ataca(q));
	p.mueve(3, 3);
	System.out.println(p.toString());
	System.out.println(q.toString());

    }
    
    
    public void metodo2(Arquero a) 
    {
	a.mueve(-3, -3);  //SEGURO se ejecuta el metodo mueve de la clase Personaje
	
	a.agregarFechas(4); //SEGURO  se ejecuta el metodo agregarFlechas de la clase Arquero
    }

}
