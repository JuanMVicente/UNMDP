package modelo;

import excepciones.OperacionConjuntosException;

import interfaces.IConjunto;

import java.io.Serializable;

import java.util.Iterator;
import java.util.TreeSet;

public class ConjuntoGenericoOrdenado<T extends Comparable & Serializable> implements IConjunto<T>, Serializable
{
    private TreeSet<T> elementos = new TreeSet<T>();
    
    public ConjuntoGenericoOrdenado()
    {
        super();
    }

    @Override
    public void agrega(T elemento) throws OperacionConjuntosException
    {
        if (this.elementos.add(elemento) ==  false)
            throw new OperacionConjuntosException("Se intentó agregar un elemento existente.", elemento);
    }

    @Override
    public void elimina(T elemento) throws OperacionConjuntosException
    {
        if (this.elementos.remove(elemento) ==  false)
            throw new OperacionConjuntosException("Se intentó eliminar un elemento inexistente.", elemento);
    }

    @Override
    public int getCardinal()
    {
        return this.elementos.size();
    }

    @Override
    public Iterator<T> getIterator()
    {
        return this.elementos.iterator();
    }

    public void setElementos(TreeSet<T> elementos)
    {
        this.elementos = elementos;
    }

    public TreeSet<T> getElementos()
    {
        return elementos;
    }
}