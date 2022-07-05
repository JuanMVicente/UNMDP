package modelo;

import util.Util;

public class Socio extends Thread {
    private String nombre;
    private Biblioteca biblio;
    private int idelegir;
    private Libro elegido;
    
    

	public void setElegido(Libro elegido) {
		this.elegido = elegido;
	}


	public String getNombre() {
		return nombre;
	}


	public Socio(String nombre, Biblioteca biblio,int idelegir) {
		super();
		this.nombre = nombre;
		this.biblio = biblio;
		this.idelegir=idelegir;
	}


	@Override
	public void run() {
		
		this.biblio.prestamo(this,this.idelegir);
		Util.espera(3000);
		this.biblio.devolucion(this,elegido);
		this.elegido=null;
	}

}
