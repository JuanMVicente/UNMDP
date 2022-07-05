package modelo;

import java.util.Arrays;

public class ConjuntoNumeros implements Cloneable {

	int[] celda;
	int largo;
	String nombre;
	
	public ConjuntoNumeros(int largo, String nombre) {
		super();
		this.largo = largo;
		this.nombre = nombre;
	}

	public int[] getCelda() {
		return celda;
	}

	public void setCelda(int[] celda) {
		this.celda = celda;
	}

	public int getLargo() {
		return largo;
	}

	public String getNombre() {
		return nombre;
	}
	
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		ConjuntoNumeros conjuntoClonado = null;
		conjuntoClonado = (ConjuntoNumeros) this.clone();
		return conjuntoClonado;
	}

	@Override
	public String toString() {
		return "ConjuntoNumeros [celda=" + Arrays.toString(celda) + ", largo=" + largo + ", nombre=" + nombre + "]";
	}
	
	
}
