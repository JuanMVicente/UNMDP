package modelo;

public class Calculadora {

	private IState estado;
	
	public void apagada() {
		this.estado.apagada();
	}
	public void esperaPrimerOperando() {
		this.estado.esperaPrimerOperando();
	}
	public void recibeDigitos() {
		this.estado.recibeDigitos();
	}
	public void recibeOperador() {
		this.estado.recibeOperador();
	}
	public void recibeSegundoOperando() {
		this.estado.recibeSegundoOperando();
	}
	public void recibeBotonIgual() {
		this.estado.recibeBotonIgual();
	}
	public void muestra() {
		this.estado.muestra();
	}
	public void dividePorCero() {
		this.estado.dividePorCero();
	}
	public void recibeBotonCE() {
		this.estado.recibeBotonCE();
	}
}
