package dato;

public class AdministradorAgencia extends Usuario {
	
	public static double comisionesCobradas = 0;
	
	public AdministradorAgencia(String nombreUsuario, String contrasenia, String nombre) {
		super(nombreUsuario, contrasenia, nombre);
	}
	
	

	public static double getComisionesCobradas() {
		return comisionesCobradas;
	}



	public static void setComisionesCobradas(double comisionesCobradas) {
		AdministradorAgencia.comisionesCobradas = comisionesCobradas;
	}



	@Override
	public String toString() {
		return "AdministradorAgencia: " + super.toString();
	}

}
