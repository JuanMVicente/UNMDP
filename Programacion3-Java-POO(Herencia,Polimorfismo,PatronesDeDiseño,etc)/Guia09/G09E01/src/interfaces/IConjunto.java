package interfaces;

import excepciones.OperacionConjuntosException;

import java.io.Serializable;

import java.util.Iterator;

public interface IConjunto<T>
{
    void agrega(T elemento) throws OperacionConjuntosException;
    void elimina(T elemento) throws OperacionConjuntosException;
    int getCardinal();
    Iterator<T> getIterator();
}