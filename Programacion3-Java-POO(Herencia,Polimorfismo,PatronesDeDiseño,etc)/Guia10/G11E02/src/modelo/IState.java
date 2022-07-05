package modelo;

public interface IState
{
	void apagada();
	void esperaPrimerOperando();
	void recibeDigitos();
	void recibeOperador();
	void recibeSegundoOperando();
	void recibeBotonIgual();
	void muestra();
	void dividePorCero();
	void recibeBotonCE();
}
