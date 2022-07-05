package modelo;

public class ComandoDesconocidoException extends Exception
{
    private String comandoPretendido;

    public ComandoDesconocidoException(String comando)
    {
	this.comandoPretendido = comando;
    }

    public String getComandoPretendido()
    {
        return comandoPretendido;
    }
    
    

}
