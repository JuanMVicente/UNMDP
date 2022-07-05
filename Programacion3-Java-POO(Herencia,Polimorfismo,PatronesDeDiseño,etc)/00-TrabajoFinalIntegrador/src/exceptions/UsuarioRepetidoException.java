package exceptions;

public class UsuarioRepetidoException extends Exception {
    
	private String nombreusuario;

	public UsuarioRepetidoException(String arg0,String nombreusuario) {
		super(arg0);
		this.nombreusuario = nombreusuario;
	}
	
	public UsuarioRepetidoException(String arg0) {
		super(arg0);
	}
	
} 
