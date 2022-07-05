package modelo;

public class Domicilio implements Cloneable {
	private String calle;
	private int numero;
	
	public Domicilio() {
		super();
	}

	public Domicilio(String calle, int numero) {
		super();
		this.calle = calle;
		this.numero = numero;
	}

	@Override
	public Object clone() throws CloneNotSupportedException
	{
		Domicilio domicilioClonado = null;
		domicilioClonado =(Domicilio) super.clone();
		
		return domicilioClonado;
		
	
	}
	
	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Domicilio [calle=" + calle + ", numero=" + numero + "]";
	}
	
	
	
}
