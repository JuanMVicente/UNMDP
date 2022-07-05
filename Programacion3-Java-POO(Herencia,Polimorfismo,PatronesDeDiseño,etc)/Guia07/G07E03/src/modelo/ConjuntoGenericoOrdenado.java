package modelo;

import java.util.Iterator;
import java.util.TreeSet;

import excepciones.OperacionConjuntoInvalidaException;

public class ConjuntoGenericoOrdenado<E> extends Comparable> implements IConjunto<E>{

	TreeSet<E> elementos;
	
	
	public ConjuntoGenericoOrdenado() {
		super();
		this.elementos = new TreeSet<E>();
	}

	@Override
	public void agrega(E elemento) throws OperacionConjuntoInvalidaException 
	{
		// TODO Auto-generated method stub
		if(elemento != null)
			this.elementos.add(elemento);
		else
			throw new OperacionConjuntoInvalidaException("elemento inexistente",elemento);
		
	}

	@Override
	public void elimina(E elemento) throws OperacionConjuntoInvalidaException {
		// TODO Auto-generated method stub
		if(elementos.contains(elemento))
			elementos.remove(elemento);
		else
			throw new OperacionConjuntoInvalidaException("elemento inexistente",elemento);
	}

	@Override
	public int getCardinal() {
		// TODO Auto-generated method stub
		return this.elementos.size();
	}

	@Override
	public Iterator<E> getIterator() {
		// TODO Auto-generated method stub
		return this.elementos.iterator();
	}

	public E getMayor() {
		Iterator<E> itr = this.getIterator();
		E aux == null;
		while(itr.hasNext()) {
			if(aux == null)
				itr.
			System.out.println(itr.next().toString());
		}
		return aux;
		
	}
	
	public E getMenor() {
		
	}
}
