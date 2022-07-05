package modelo;

/**
 * @author guille
 * <br>
 * Clase que sirve para representar una posicion bidimensional en un plano cartesiano
 *
 */
public class Posicion
{
	private double x;
	private double y;

	/**
	 * Constructor con dos parametros doubles para setear los coordenadas
	 * @param x Coordenada x de la posicion
	 * @param y Coordenada y de la posicion
	 */
	public Posicion(double x, double y)
	{

		this.x = x;
		this.y = y;
	}

	public double getX()
	{
		return x;
	}

	public void setX(double x)
	{
		this.x = x;
	}

	public double getY()
	{
		return y;
	}

	public void setY(double y)
	{
		this.y = y;
	}

	@Override
	public String toString()
	{
		return "[x=" + x + ", y=" + y + "]";
	}

	/**
	 * Metodo que calcula la distancia pitagorica a otra posicion
	 * @param otra De tipo Posicion, posicion a la cual quiero calcular la distancia
	 * @return El resultado de la distancia euclidea.
	 */
	public double distancia(Posicion otra)
	{
		double respuesta;
		respuesta = (otra.x - this.x) * (otra.x - this.x) + (otra.y - this.y) * (otra.y - this.y);
		respuesta = Math.sqrt(respuesta);
		return respuesta;
	}

	public void mueve(double x, double y)
	{
		this.x += x;
		this.y += y;

	}

}
