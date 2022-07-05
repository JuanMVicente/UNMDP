package modelo;

public class Animal implements Cloneable{
	private int esperanzaDeVida;
	private String nombre;
	
		public Animal() {
		super();
	}

	public Animal(int esperanzaDeVida, String nombre) {
		super();
		this.esperanzaDeVida = esperanzaDeVida;
		this.nombre = nombre;
	}

	@Override
	public Object clone() throws CloneNotSupportedException
	{
	     //La clase Animal conserva la propagacion de la excepcion, ya que
        //no sabemos si las clases hijas seran o no cloneables
        //El unico objeto de sobreescribir este metodo es hacerlo publico
        return super.clone();
	}
	
	public int getEsperanzaDeVida() {
		return esperanzaDeVida;
	}

	public void setEsperanzaDeVida(int esperanzaDeVida) {
		this.esperanzaDeVida = esperanzaDeVida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Animal [esperanzaDeVida=" + esperanzaDeVida + ", nombre=" + nombre + "]";
	}
	
	
}
