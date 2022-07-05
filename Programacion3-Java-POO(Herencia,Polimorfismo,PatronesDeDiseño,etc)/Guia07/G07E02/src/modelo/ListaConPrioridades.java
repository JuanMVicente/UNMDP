package modelo;

import java.util.PriorityQueue;

public class ListaConPrioridades<T extends Comparable> {

	PriorityQueue<T> elementos = new PriorityQueue<T>();
	
	public ListaConPrioridades() {};
	
	
	public void agrega(T elemento) {
		this.elementos.add(elemento);
	}
	public T consultaElemento() {
		return elementos.peek();
	}
	
	public int getCantidad() {
		return elementos.size();
	}
	public T getElemento() {
		return this.elementos.poll();
	}
}
