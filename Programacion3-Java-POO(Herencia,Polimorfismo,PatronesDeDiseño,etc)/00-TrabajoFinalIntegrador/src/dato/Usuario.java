package dato;

public class Usuario {
	private String nombre;
	private String nombreUsuario;
	private String contrasenia;
	
	public Usuario(String nombreUsuario, String contrasenia, String nombre) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", nombreUsuario=" + nombreUsuario + ", contrasenia=" + contrasenia + "]";
	}
		
}
