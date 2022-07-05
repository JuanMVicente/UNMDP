package modelo;

public class MuertoState implements IState
{
    private Soldado soldado;

    public MuertoState(Soldado soldado)
    {
	
    }

    @Override
    public void volvePatrullar()
    {
	
    }

    @Override
    public void haySospechas()
    {
	
    }

    @Override
    public void hayEvidencia()
    {
	
    }

    @Override
    public void saludaSuperior()
    {
	
    }

    @Override
    public void recibeDanoLetal()
    {
	
    }

    @Override
    public String actua()
    { // Muchas Lineas de codigo que realizan la accion correspondiente
	return ( "Se encuentra imposibilitado de actuar de forma permanente");
    }

    @Override
    public String toString()
    {
	return "MuertoState";
    }

}
