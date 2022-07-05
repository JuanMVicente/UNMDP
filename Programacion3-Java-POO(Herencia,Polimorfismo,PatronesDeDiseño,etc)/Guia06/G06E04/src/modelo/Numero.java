package modelo;

public class Numero implements cloneable {
	int dato;

	public Numero(int dato) {
		super();
		this.dato = dato;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		return "Numero [dato=" + dato + "]";
	}
	
	
}
