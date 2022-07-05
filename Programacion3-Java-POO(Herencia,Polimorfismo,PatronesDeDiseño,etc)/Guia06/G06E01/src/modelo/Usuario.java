package modelo;

import excepsiones.ContrasenaInvalidaExcepcion;
import excepsiones.ExcepsionesLogIn;
import excepsiones.NombreInvalidoExcepcion;

public class Usuario {
	private String nombre;
	private String contrasena;
	
	public String getNombre() 
	{
		return nombre;
	}
	public void setNombre(String nombre) throws NombreInvalidoExcepcion
	{
		if(nombre != null && nombre !="")
			this.nombre = nombre;
		else
			throw new NombreInvalidoExcepcion("Nombre Invalido");
	}
	public String getContrasena() 
	{
		return contrasena;
	}
	public void setContrasena(String contrasena) throws ContrasenaInvalidaExcepcion
	{
		if(contrasena != null && contrasena.length()>5)
			this.contrasena = contrasena;
		else
			throw new ContrasenaInvalidaExcepcion("Contraseña invalida");
	}
	public Usuario(String nombre, String contrasena)
	{
		super();
		try{
			this.setNombre(nombre);
			try
			{
				this.setContrasena(contrasena);
				System.out.println("Usuario generado correctamente");
			}
			catch (ContrasenaInvalidaExcepcion e)
			{
				System.out.println("Contraseña invalida");
			}
		}
		catch (NombreInvalidoExcepcion e)
		{
			System.out.println("Nombre Invalido");

		}

	}
	
	
}
