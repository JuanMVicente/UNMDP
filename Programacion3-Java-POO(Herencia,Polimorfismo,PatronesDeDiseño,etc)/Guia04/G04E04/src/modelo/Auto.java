package modelo;

/**
 * @author jmvic
 * <br>
 * Clase que representa un Auto dentro del ejercicio 4 de la Guias 4.<br>
 *
 */
public class Auto extends Vehiculo {
	private int plaza;
	
	
	/**
	 * Agrega un Auto a nuestro sistema.<br>
	 * <b>Pre: </b>Ingresa Patente y plaza.
	 * <b>Post: </b>Auto creado.
	 * @param patente: Identificación unica del Auto
	 * @param plaza: Determina la cantidad de plazas del auto.
	 */
	public Auto(String patente, int plaza) {
		super(patente);
		this.plaza = plaza;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 *
	 */
	@Override
	public void getPrecio() {
		// TODO Auto-generated method stub
		System.out.println(super.precio + 0.015 * this.plaza + " por día");
	}
}
