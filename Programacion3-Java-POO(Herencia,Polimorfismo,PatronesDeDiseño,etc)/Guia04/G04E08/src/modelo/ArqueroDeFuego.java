package modelo;

public class ArqueroDeFuego extends Arquero
{

    public ArqueroDeFuego(String nombre, Posicion posicion)
    {
	super(nombre, posicion);
    }

    @Override
    public void agregarFechas(int cantidad)
    {
	System.out.println("Usando el  metodo agegarFlechas de Arquero de Fuego");
	super.agregarFechas(cantidad*100);
    }

    @Override
    public void mueve(double x, double y)
    {
	// TODO Auto-generated method stub
	System.out.println("Usando el metodo de arquero de fuego");
	super.mueve(x*2, y*2);
    }
    
    
    
    

}
