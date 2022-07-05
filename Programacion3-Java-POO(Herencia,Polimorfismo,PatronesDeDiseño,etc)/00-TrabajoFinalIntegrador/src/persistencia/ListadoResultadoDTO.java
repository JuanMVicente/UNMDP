package persistencia;

import java.io.Serializable;

public class ListadoResultadoDTO implements Serializable {
	private double puntuacion;
	//private UsuarioExternoDTO usuario;
	private String usuario;
	
	public double getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}
	/*public UsuarioExternoDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioExternoDTO usuario) {
		this.usuario = usuario;
	}*/
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	
}
