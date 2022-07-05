package dato;

public class StructListadoResultado {
	
	private double puntuacion;
	private UsuarioExterno usuario;

	public double getPuntuacion() {
		return puntuacion;
	}
	
	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}	
	
	public UsuarioExterno getUsuario() {
		return usuario;
	}
	
	public void setUsuario(UsuarioExterno usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "StructListadoResultado [puntuacion=" + puntuacion + ", usuario=" + usuario + "]";
	}
	
	
	
} 