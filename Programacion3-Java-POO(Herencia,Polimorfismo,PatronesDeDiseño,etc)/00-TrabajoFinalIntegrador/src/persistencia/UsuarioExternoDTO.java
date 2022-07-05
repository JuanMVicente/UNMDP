package persistencia;

import java.io.Serializable;
import java.util.ArrayList;

public class UsuarioExternoDTO extends UsuarioDTO implements Serializable {

	private ListaDTO listadoResultados = new ListaDTO();
	//private ArrayList<UsuarioExternoDTO> elecciones = new ArrayList<UsuarioExternoDTO>(); 
	private ArrayList<String> elecciones = new ArrayList<String>();
	private int puntajefijo;
	
	
	
	public ArrayList<String> getElecciones() {
		return elecciones;
	}
	public void setElecciones(ArrayList<String> elecciones) {
		this.elecciones = elecciones;
	}
	public ListaDTO getListadoResultados() {
		return listadoResultados;
	}
	public void setListadoResultados(ListaDTO listadoResultados) {
		this.listadoResultados = listadoResultados;
	}
	/*public ArrayList<UsuarioExternoDTO> getElecciones() {
		return elecciones;
	}
	public void setElecciones(ArrayList<UsuarioExternoDTO> elecciones) {
		this.elecciones = elecciones;
	}*/
	public int getPuntajefijo() {
		return puntajefijo;
	}
	public void setPuntajefijo(int puntajefijo) {
		this.puntajefijo = puntajefijo;
	}
	
	
	
}
