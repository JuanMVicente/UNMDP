package dato;

import java.util.ArrayList;


public class UsuarioExterno extends Usuario {
	/**
 	* Clase que tiene representa un usuarioexterno al sistema (empleador o empleado). tendra como atributo los mismos atributos que comparten los empleados y empleadores.
 	* en este caso : un listado de resultados (El que se obtiene luego en la ronda de encuentros), un arreglo de tipo usuarioexterno (arreglo de usuarios externos seleccionados)
 	*  y un tipo de dato entero que representa el puntaje de este mismo usuario.
 	* @author Grupo 9
 	*/

	private Lista listadoResultados = new Lista();
	private ArrayList<UsuarioExterno> elecciones = new ArrayList<UsuarioExterno>(); 
	private int puntajefijo = 0;
	
	/**
	 * Constructor del usuarioexterno (empleados y empleadores), con su respectivo nombre de usuario validado, contrasenia y nombre.
	 **/
	public UsuarioExterno(String nombreUsuario, String contrasenia, String nombre) {
		super(nombreUsuario, contrasenia, nombre);
	}

	public int getPuntajefijo() {
		return puntajefijo;
	}

	/**
	 * Establece el puntaje calculado previamente del respectivo usuario (empleado o empleador). si el puntaje calculado es menor a 0, se establece en 0.
	 **/

	public void setPuntajefijo(int puntajefijo) {
		if(puntajefijo<0)
			this.puntajefijo=0;
		else
			this.puntajefijo = puntajefijo;
	}


	public ArrayList<UsuarioExterno> getElecciones() {
		return elecciones;
	}


	public void setElecciones(ArrayList<UsuarioExterno> elecciones) {
		this.elecciones = elecciones;
	}


	public void setListadoResultados(Lista listadoResultados) {
		this.listadoResultados = listadoResultados;
	}


	public Lista getListadoResultados() {
		return listadoResultados;
	}



} 
