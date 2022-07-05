package modelo;

/**
 * @author guille
 *<br>
 *Clase abstracta que representa un Personje
 */
public abstract class Personaje
{
	private String nombre;
	protected int vitalidad;
	private Posicion posicion;

	
	
	
	/**
	 * Constructor con tres parametros para setear el nombre, la vitalidad y la posicion del personaje 
	 * <br>
	 * @param nombre : parametro de tipo String que representa el nombre del personaje 
	 * @param vitalidad : parametro de tipo int que representa la vitalidad del personaje
	 * @param posicion : parametro de tipo Posicion que representa la posicion en el plano del personaje
	 */
	public Personaje(String nombre, int vitalidad, Posicion posicion)
	{
		this.nombre = nombre;
		this.vitalidad = vitalidad;
		this.posicion = posicion;
	}

	public String getNombre()
	{
		return nombre;
	}

	public int getVitalidad()
	{
		return vitalidad;
	}

	public Posicion getPosicion()
	{
		return posicion;
	}

	@Override
	public String toString()
	{
		return "[nombre=" + nombre + ", vitalidad=" + vitalidad + ", posicion=" + posicion + "]";
	}

	
	/**
	 * Mueve al personaje incrementando sus posicion "x" e "y" 
	 * @param x : valor que incrementara la coordena x del personaje
	 * @param y : valor que incrementara la coordena y del personaje
	 */
	public void mueve(double x, double y)
	{
		this.posicion.mueve(x, y);
	}
	/**
	 * Metodo que calcula la distancia pitagorica a otro Personaje
	 * @param otro De tipo Personaje, al cual quiero calcular la distancia
	 * @return El resultado de la distancia euclidea.
	 */
	public double distancia(Personaje otro)
	{
		return this.posicion.distancia(otro.posicion);
	}
	
	//El metodo ataca devuelve un String par informar 
	//sobre su xito o fracaso, esto NO ES CORRECTO pero
	// por ahora lo vamos a dejar pasar
	// Este ejemplo lo retomaremos en la clase de Excepciones
	/**
	 * Realiza un ataque al Personaje pasado como parametro si la distancia lo permite<br>
	 * <b>Pre: </b> adversario debe ser distinto de null <br>
	 * <b>Post: </b> adversario recibira daño en caso de estar a la distancia adecuada
	 * @param adversario Personaje que sera atacado
	 * @return String con informacion acerca del exito o fracaso del ataque
	 */
	public abstract String ataca(Personaje adversario);
	
	
	/**
	 * Inflinge el la cantidad de daño pasada por parametro<br>
	 *  <b>Pre: </b> La cantidad debe ser positiva<br>
	 *  <b>Post: </b> El Personaje modificara sus atributos de acuerdo al daño recibido
	 * @param cantidad : de tipo int, indica la cantidad de daño inflingido
	 */
	public abstract void recibeDano(int cantidad);
	

}
