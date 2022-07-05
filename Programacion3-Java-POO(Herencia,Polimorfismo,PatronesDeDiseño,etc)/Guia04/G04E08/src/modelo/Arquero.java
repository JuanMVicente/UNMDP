package modelo;

/**
 * @author guille
 *<br>
 *Clase qu representa un personaje con la capacidad de arrojar flechas
 */
/**
 * @author guille
 *
 */
public class Arquero extends Personaje
{
    private int cantidadFlechas;

    /**
     * Constructor con dos parametros para setear el nombre y la posicion del personaje. La vitalidad inicial sera de 400 unidades<br>
     * @param nombre : parametro de tipo String que representa el nombre del personaje 
     * @param posicion : parametro de tipo Posicion que representa la posicion en el plano del personaje
     */
    public Arquero(String nombre, Posicion posicion)
    {
	super(nombre, 400, posicion);
	this.cantidadFlechas = 20;
    }

    public int getCantidadFlechas()
    {
	return cantidadFlechas;
    }

    /**
     * Agrega la cantidad de flechas que indique el parametro cantidad<br>
     * <b>Pre: </b> la cantidad debe ser positiva<br>
     * <b>Post: </b> la cantidad de flechas se incrementa como lo indique el parametro cantidad
     * @param cantidad : de tipo entero, indica cuantas flechas se agregaran
     */
    public void agregarFechas(int cantidad)
    {
	this.cantidadFlechas += cantidad;
    }

    /**
     *Si el arquero posee flechas y el adversario se encuentra a una distancia menor o igual a 100, se consume una flecha y se inflinge al adversario un daño de 20 unidades<br>
     *Si no posee flechas y el adversario se encuentra a una distancia menor o igual a 5, se inflinge al adversario un daño de 5 unidades <br>
     *<b>Pre: </b> El adversario debe ser distinto de null<br>
     *<b>Post: </b> Si se poseian flechas y el adversario estaba a menos de 100 unidades de distancia se consume una flecha y el adversario recibe 20 de daño<br>
     *Si no se poseian flechas y el adversario estaba a menos de 5 unidades de distancia, el adversario recibe un daño de 5 unidades
     * @param adversario : de tipo Personaje, quien recibira el ataque
     * @return String con informacion acerca del exito o fracaso del ataque
     */
    @Override
    public String ataca(Personaje adversario)
    {
	String respuesta = null;
	if (this.cantidadFlechas > 0)// tenemos flechas
	{
	    if (this.distancia(adversario) < 100)
	    {
		this.cantidadFlechas--;
		adversario.recibeDano(20);
		respuesta = this.getNombre() + " lanzo una flecha a " + adversario.getNombre();
	    } else
	    {

		respuesta = this.getNombre() + " No pudo atacar a " + adversario.getNombre()
			+ " aunque tenia flechas, la distacia es muy grande " + this.distancia(adversario);
	    }

	} else
	{
	    if (this.distancia(adversario) < 5)
	    {

		adversario.recibeDano(5);
		respuesta = this.getNombre() + " realizo un ataque corto a " + adversario.getNombre();
	    } else
	    {

		respuesta = this.getNombre() + " No pudo atacar a " + adversario.getNombre()
			+ " No tenia flechas y la distancia era muy grande para ataques cortos "
			+ this.distancia(adversario);
		;
	    }

	}
	return respuesta;
    }

    /**
     *Se decrementa la vitalidad, la cantidad indicada por el parametro cantidad<br>
     *<b>Pre: </b> La cantidad debe ser positiva<br>
     *<b>Post: </b> Se decrementa la vitalidad , la cantidad indicada por el parametro cantidad
     * @param cantidad : de tipo int, indica la cantidad de daño inflingido
     */
    @Override
    public void recibeDano(int cantidad)
    {
	this.vitalidad -= cantidad;
    }

    @Override
    public String toString()
    {
	return "Arquero " + super.toString() + " [cantidadFlechas=" + cantidadFlechas + "]";
    }

}
