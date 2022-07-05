package modelo;

import java.util.Iterator;
import java.util.LinkedHashSet;

import excepciones.OperacionConjuntoInvalidaException;

public class ConjuntoGenerico<T> implements IConjunto<T> {

	LinkedHashSet<T> elementos;
	
	public ConjuntoGenerico() {
		super();
		this.elementos = new LinkedHashSet<T>();
	}

	@Override
	public void agrega(T o) throws OperacionConjuntoInvalidaException
	{
		// TODO Auto-generated method stub
		if(o != null)
			elementos.add(o);
		else
			throw new OperacionConjuntoInvalidaException("elemento inexistente",o);
	}

	@Override
	public void elimina(T o) throws OperacionConjuntoInvalidaException
	{
		// TODO Auto-generated method stub
		if(elementos.contains(o))
			elementos.remove(o);
		else
			throw new OperacionConjuntoInvalidaException("elemento inexistente",o);
		

	}

	@Override
	public int getCardinal() {
		// TODO Auto-generated method stub
		return elementos.size();
	}

	@Override
	public Iterator<T> getIterator() {
		// TODO Auto-generated method stub
		return elementos.iterator();
	}

}
