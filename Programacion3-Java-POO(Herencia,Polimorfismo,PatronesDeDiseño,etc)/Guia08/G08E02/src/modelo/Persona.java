package modelo;

public class Persona extends Thread {
    private String nombre; 
	private int numero;
	private Mostrador mostrador;
	
	
	
	public String getNombre() {
		return nombre;
	}
	public int getNumero() {
		return numero;
	}
	public Persona(String nombre, int numero,Mostrador m) {
		super();
		this.nombre = nombre;
		this.numero = numero;
		this.mostrador = m;
	}

	public void run() {
		this.mostrador.tomaturno(this);
	}
}
