package modelo;

import java.util.ArrayList;

public class CDAudio implements Prestable, Comparable{
	private int codigo;
	private String titulo;
	private String interprete;
	private ArrayList<Cancion> listaCanciones = new ArrayList<Cancion>();
	private boolean prestado;
	
	
	public int getCodigo() {
		return codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getInterprete() {
		return interprete;
	}
	public ArrayList<Cancion> getListaCanciones() {
		return listaCanciones;
	}
	@Override
	public void prestar() {
		// TODO Auto-generated method stub
		this.prestado = true;
	}
	@Override
	public void devolver() {
		// TODO Auto-generated method stub
		this.prestado = false;
	}
	@Override
	public boolean isPrestado() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		CDAudio a = (CDAudio) o;
		if (this.interprete.compareTo(a.getInterprete()) != 0)
			return this.interprete.compareTo(a.getInterprete());
		else
			return this.titulo.compareTo(a.getTitulo());
	}
	
	
	
}
