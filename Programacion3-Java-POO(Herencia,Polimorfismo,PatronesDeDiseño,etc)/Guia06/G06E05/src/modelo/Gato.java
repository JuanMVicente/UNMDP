package modelo;

public class Gato extends Animal {

	
	public Gato() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gato(int esperanzaDeVida, String nombre) {
		super(esperanzaDeVida, nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object clone() throws CloneNotSupportedException
	{
		// Esta clase SIEMPRE lanza una excepcion, los gatos no ser�n cloneables
	    throw new CloneNotSupportedException();
	}
	   
	
}
