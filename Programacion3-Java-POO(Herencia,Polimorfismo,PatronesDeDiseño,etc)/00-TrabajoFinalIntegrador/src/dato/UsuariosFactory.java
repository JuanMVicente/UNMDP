package dato;

public class UsuariosFactory {

	public static Usuario getUsuario(int tipo,String nombreUsuario, String contrasenia, String nombre, String rubroOtelefono,String fechaNacimiento, String dni) {
		Usuario usuario = null;
		if(tipo == 0) {//Empleado Pretenso
			usuario = new EmpleadoPretenso(nombreUsuario, contrasenia, nombre, rubroOtelefono, fechaNacimiento, dni);
		}
		else if(tipo==1) {//Empleador
			usuario = new EmpleadorFisico(nombreUsuario, contrasenia, nombre, rubroOtelefono);
		}
		else if(tipo==2) {
			usuario = new EmpleadorJuridico(nombreUsuario, contrasenia, nombre, rubroOtelefono);
		}
		return usuario;
	}
	
}		
