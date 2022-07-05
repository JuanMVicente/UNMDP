package modelo;

import java.io.Serializable;

import java.util.Iterator;
import java.util.PriorityQueue;

public class ListaConPrioridades<T extends Comparable> implements Serializable
{
    private PriorityQueue<T> elementos = new PriorityQueue<T>();
    
    public ListaConPrioridades()
    {
        super();
    }
    
    public void agrega(T elemento)
    {
        this.elementos.add(elemento);
    }
    
    public T getElemento()
    {
        return this.elementos.poll();
    }
    
    public T consultaElemento()
    {
        return this.elementos.peek();
    }
    
    public int getCantidad()
    {
        return this.elementos.size();
    }

    public Iterator<T> getIterator()
    {
        return elementos.iterator();
    }
}
