package modelo;

public class Perro extends Animal {

	public Perro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Perro(int esperanzaDeVida, String nombre) {
		super(esperanzaDeVida, nombre);
		// TODO Auto-generated constructor stub
	}
	

    @Override
    public Object clone()
    {
        //La clase Perro SIEMPRE sera cloneable. Se elimino la propagacion de la excepcion
        //La Excepcion, si existiese, se trata dentro del metodo, el cual, en el peor de los casos
        // retornaria un objeto null. De todas formas, como los atributos de la clase son primitivos y String
        // esta metodo nunca entrara al bloque catch
        Object clon = null;
        try
        {
            clon = super.clone();
        } catch (CloneNotSupportedException e)
        {
            //NUNCA entraremos a este bloque
            e.printStackTrace();
        }
        return clon;
    }
	
}
