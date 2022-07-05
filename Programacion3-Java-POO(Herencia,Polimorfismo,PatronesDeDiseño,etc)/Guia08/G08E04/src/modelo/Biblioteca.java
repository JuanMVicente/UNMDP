package modelo;

import java.util.ArrayList;

public class Biblioteca {
	private ArrayList<Libro> libros = new ArrayList<Libro>();
	private Libro seleccion;
    int i;
    
    
    
	public void agregar(Libro l) {
		this.libros.add(l);
	}
    
	public synchronized void prestamo(Socio s,int id) {
		 
		i=0;
		  
		 while(i<libros.size() && libros.get(i).getIdnum() != id)
			     i++;
		
		while (i>=libros.size())
		{   
			try
			{
				System.out.println(s.getNombre()+" quiere llevar un libro"+"pero esta en uso");
				wait();
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while(i<libros.size() && libros.get(i).getIdnum() != id)
			     i++;
		}

		s.setElegido(libros.get(i));
		System.out.println(s.getNombre() +" se llevo el libro "+libros.get(i).getTitulo());
		libros.remove(i);
	}


	public synchronized void devolucion(Socio s,Libro l) {
		this.libros.add(l);
		System.out.println(s.getNombre()+" devolvio el libro "+l.getTitulo());
		notifyAll();
	}
}
